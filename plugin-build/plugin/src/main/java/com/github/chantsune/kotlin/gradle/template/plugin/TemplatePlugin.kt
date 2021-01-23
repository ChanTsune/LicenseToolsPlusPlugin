package com.github.chantsune.kotlin.gradle.template.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

abstract class TemplatePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        // Add the 'template' extension object
        val extension = project.extensions.create(TemplateExtension.NAME, TemplateExtension::class.java, project)

        // Add a task that uses configuration from the extension object
        project.tasks.register(TemplateExampleTask.NAME, TemplateExampleTask::class.java) {
            it.enableVerify = extension.enableVerify
            it.outputFile.set(extension.outputFile)
            it.inputFile.set(extension.inputFile)
            it.transform = extension.getTransformer()
        }
    }
}
