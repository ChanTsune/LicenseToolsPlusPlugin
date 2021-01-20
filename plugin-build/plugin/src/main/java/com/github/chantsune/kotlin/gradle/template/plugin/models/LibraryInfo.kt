package com.github.chantsune.kotlin.gradle.template.plugin.models

data class LibraryInfo(
    val artifactId: ArtifactId,
    val name: String? = null,
    val libraryName: String? = null,
    val url: String? = null,
    val fileName: String? = null,
    val license: String? = null,
    val year: String? = null,
    val copyrightHolder: String? = null,
    val notice: String? = null,
    val licenseUrl: String?,
    val skip: Boolean? = null,
    val forceGenerate: Boolean? = null
)
