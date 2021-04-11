package com.github.chantsune.gradle.plugin.license

import com.github.chantsune.gradle.plugin.license.models.LibraryInfo
import org.gradle.api.Project
import org.gradle.api.file.RegularFileProperty
import javax.inject.Inject

@Suppress("UnnecessaryAbstractClass")
abstract class LicenseToolsPlusExtension @Inject constructor(project: Project) {

    private val objects = project.objects

    var enableVerify: Boolean = false

    val inputFile: RegularFileProperty = objects.fileProperty().convention {
        project.file(DEFAULT_INPUT_FILE)
    }

    val outputFile: RegularFileProperty = objects.fileProperty().convention {
        project.file(DEFAULT_OUTPUT_FILE)
    }

    private var transformer: LibraryInfo.() -> Unit = { }

    fun transformLibrariesInfo(transformer: LibraryInfo.() -> Unit) {
        this.transformer = transformer
    }

    fun getTransformer(): LibraryInfo.() -> Unit {
        return transformer
    }

    companion object {
        private const val DEFAULT_OUTPUT_FILE = "licenses.yml"
        private const val DEFAULT_INPUT_FILE = "licenses.yml"
        const val NAME = "licenseToolsPlus"
    }
}
