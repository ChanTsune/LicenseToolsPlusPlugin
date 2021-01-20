package com.github.chantsune.kotlin.gradle.template.plugin.models

data class ArtifactId(
    val group: String,
    val name: String,
    val version: String
) {
    companion object {
        fun parse(artifactId: String): ArtifactId {
            return ArtifactId("", "", "")
        }
    }
}
