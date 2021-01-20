package com.github.chantsune.kotlin.gradle.template.plugin

import com.charleskorn.kaml.Yaml
import com.github.chantsune.kotlin.gradle.template.plugin.models.LibraryInfo
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.encodeToString
import org.gradle.api.DefaultTask
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.options.Option

abstract class TemplateExampleTask : DefaultTask() {

    init {
        description = "Just a sample template task"

        // Don't forget to set the group here.
        // group = BasePlugin.BUILD_GROUP
    }

    @get:Input
    @get:Option(option = "message", description = "A message to be printed in the output file")
    abstract val message: Property<String>

    @get:Input
    @get:Option(option = "tag", description = "A Tag to be used for debug and in the output file")
    @get:Optional
    abstract val tag: Property<String>

    abstract val inputFile: RegularFileProperty

    @get:OutputFile
    abstract val outputFile: RegularFileProperty

    @get:Input
    abstract var transform: (LibraryInfo) -> LibraryInfo

    @TaskAction
    fun sampleAction() {
        val prettyTag = tag.orNull?.let { "[$it]" } ?: ""

        logger.lifecycle("$prettyTag message is: ${message.orNull}")
        logger.lifecycle("$prettyTag tag is: ${tag.orNull}")
        logger.lifecycle("$prettyTag inputFile is: ${inputFile.orNull}")
        logger.lifecycle("$prettyTag outputFile is: ${outputFile.orNull}")
        inputFile.get().asFile.readText().let {
            Yaml.default.decodeFromString(ListSerializer(LibraryInfo.serializer()), it)
        }.map(transform).let {
            Yaml.default.encodeToString(it)
        }.let {
            outputFile.get().asFile.writeText(it)
        }
    }
}
