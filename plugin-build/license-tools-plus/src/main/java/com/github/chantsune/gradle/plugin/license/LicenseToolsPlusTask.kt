package com.github.chantsune.gradle.plugin.license

import com.charleskorn.kaml.Yaml
import com.charleskorn.kaml.YamlConfiguration
import com.github.chantsune.gradle.plugin.license.models.LibraryInfo
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.encodeToString
import org.gradle.api.DefaultTask
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

abstract class LicenseToolsPlusTask : DefaultTask() {

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
    abstract var transform: LibraryInfo.() -> Unit

    @TaskAction
    fun sampleAction() {
        logger.lifecycle("enableVerify is: $enableVerify")
        logger.lifecycle("inputFile is: ${inputFile.orNull}")
        logger.lifecycle("outputFile is: ${outputFile.orNull}")

        val yaml = Yaml(configuration = YamlConfiguration(encodeDefaults = false))
        val serializer = ListSerializer(LibraryInfo.serializer())

        inputFile.get().asFile.readText().let {
            yaml.decodeFromString(serializer, it)
        }.map {
            it.apply(transform)
        }.distinctBy {
            it.artifact
        }.also { libsInfo ->
            if (enableVerify) {
                libsInfo.map { it.verify() }
            }
        }.let {
            yaml.encodeToString(serializer, it)
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
