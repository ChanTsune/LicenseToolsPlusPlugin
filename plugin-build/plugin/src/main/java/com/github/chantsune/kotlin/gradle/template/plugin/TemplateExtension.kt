package com.github.chantsune.kotlin.gradle.template.plugin

import com.github.chantsune.kotlin.gradle.template.plugin.models.LibraryInfo
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.internal.CollectionCallbackActionDecorator
import org.gradle.api.provider.Property
import org.gradle.internal.reflect.Instantiator
import javax.inject.Inject

const val DEFAULT_OUTPUT_FILE = "template-example.txt"

@Suppress("UnnecessaryAbstractClass")
abstract class TemplateExtension @Inject constructor(project: Project) {

    private val objects = project.objects

    val message: Property<String> = objects.property(String::class.java)

    val tag: Property<String> = objects.property(String::class.java)

    val outputFile: RegularFileProperty = objects.fileProperty().convention(
        project.layout.buildDirectory.file(DEFAULT_OUTPUT_FILE)
    )

    private var transformer: (LibraryInfo) -> LibraryInfo = { it }

    fun transformLibrariesInfo(transformer: (LibraryInfo) -> LibraryInfo) {
        this.transformer = transformer
    }
    fun getTransformer(): (LibraryInfo) -> LibraryInfo {
        return transformer
    }
}
