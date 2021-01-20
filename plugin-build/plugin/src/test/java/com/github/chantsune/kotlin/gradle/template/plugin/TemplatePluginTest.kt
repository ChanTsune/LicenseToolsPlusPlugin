package com.github.chantsune.kotlin.gradle.template.plugin

import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

class TemplatePluginTest {

    @Test
    fun `plugin is applied correctly to the project`() {
        val project = ProjectBuilder.builder().build()
        project.pluginManager.apply("com.github.chantsune.kotlin.gradle.template.plugin")

        assert(project.tasks.getByName("templateExample") is TemplateExampleTask)
    }
}
