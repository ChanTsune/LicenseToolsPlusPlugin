package com.github.chantsune.kotlin.gradle.template.plugin.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class LibraryInfo(
    @SerialName("artifact")
    var artifact: String,
    @Transient
    var artifactId: ArtifactId = ArtifactId.parse(artifact),
    @SerialName("name")
    var name: String? = null,
    @SerialName("url")
    var url: String? = null,
    @SerialName("fileName")
    var fileName: String? = null,
    @SerialName("license")
    var license: String? = null,
    @SerialName("year")
    var year: String? = null,
    @SerialName("copyrightHolder")
    var copyrightHolder: String? = null,
    @SerialName("copyrightHolders")
    var copyrightHolders: List<String>? = null,
    @SerialName("author")
    var author: String?,
    @SerialName("authors")
    var authors: List<String>? = null,
    @SerialName("notice")
    var notice: String? = null,
    @SerialName("licenseUrl")
    var licenseUrl: String?,
    @SerialName("skip")
    var skip: Boolean? = null,
    @SerialName("forceGenerate")
    var forceGenerate: Boolean? = null
) {
    var libraryName: String?
        get() = name
        set(value) {
            name = value
        }
}
