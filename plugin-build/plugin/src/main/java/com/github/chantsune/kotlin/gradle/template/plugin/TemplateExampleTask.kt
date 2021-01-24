package com.github.chantsune.kotlin.gradle.template.plugin

import com.charleskorn.kaml.Yaml
import com.charleskorn.kaml.YamlConfiguration
import com.github.chantsune.kotlin.gradle.template.plugin.models.LibraryInfo
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.encodeToString
import org.gradle.api.DefaultTask
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

abstract class TemplateExampleTask : DefaultTask() {

    init {
        description = "Just a sample template task"

        // Don't forget to set the group here.
        // group = BasePlugin.BUILD_GROUP
    }

    @get:Input
    abstract var enableVerify: Boolean

    @get:InputFile
    abstract val inputFile: RegularFileProperty

    @get:OutputFile
    abstract val outputFile: RegularFileProperty

    @get:Input
    abstract var transform: (LibraryInfo) -> LibraryInfo

    @TaskAction
    fun sampleAction() {
        logger.lifecycle("enableVerify is: $enableVerify")
        logger.lifecycle("inputFile is: ${inputFile.orNull}")
        logger.lifecycle("outputFile is: ${outputFile.orNull}")

        val yaml = Yaml(configuration = YamlConfiguration(encodeDefaults = false))

        inputFile.get().asFile.readText().let {
            yaml.decodeFromString(ListSerializer(LibraryInfo.serializer()), it)
        }.map(transform).also { libsInfo ->
            if (enableVerify) {
                libsInfo.map { it.verify() }
            }
        }.let {
            yaml.encodeToString(it)
        }.let {
            if (it.endsWith("\n")) it else it + "\n"
        }.let {
            outputFile.get().asFile.writeText(it)
        }
    }

    companion object {
        const val NAME = "transformLicensesYaml"
    }
}
