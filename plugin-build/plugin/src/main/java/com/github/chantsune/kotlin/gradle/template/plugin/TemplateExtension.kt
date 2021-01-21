package com.github.chantsune.kotlin.gradle.template.plugin

import com.github.chantsune.kotlin.gradle.template.plugin.models.LibraryInfo
import org.gradle.api.Project
import org.gradle.api.file.RegularFileProperty
import javax.inject.Inject

@Suppress("UnnecessaryAbstractClass")
abstract class TemplateExtension @Inject constructor(project: Project) {

    private val objects = project.objects

    var enableVerify: Boolean = false

    val inputFile: RegularFileProperty = objects.fileProperty().convention {
        project.file(DEFAULT_INPUT_FILE)
    }

    val outputFile: RegularFileProperty = objects.fileProperty().convention {
        project.file(DEFAULT_OUTPUT_FILE)
    }

    private var transformer: (LibraryInfo) -> LibraryInfo = { it }

    fun transformLibrariesInfo(transformer: (LibraryInfo) -> LibraryInfo) {
        this.transformer = transformer
    }

    fun getTransformer(): (LibraryInfo) -> LibraryInfo {
        return transformer
    }

    companion object {
        const val DEFAULT_OUTPUT_FILE = "licenses.yml"
        const val DEFAULT_INPUT_FILE = "licenses.yml"
    }
}
