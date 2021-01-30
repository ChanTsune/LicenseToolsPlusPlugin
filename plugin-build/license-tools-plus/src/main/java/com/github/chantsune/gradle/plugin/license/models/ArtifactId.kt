package com.github.chantsune.gradle.plugin.license.models

data class ArtifactId(
    val group: String,
    val name: String,
    val version: String
) {
    companion object {
        private const val NUMBER_OF_PARAMETER = 3
        fun parse(artifactId: String): ArtifactId {
            val parts = artifactId.split(":")
            if (parts.size != NUMBER_OF_PARAMETER) {
                throw IllegalArgumentException("Invalid argument $artifactId")
            }
            return ArtifactId(parts[0], parts[1], parts[2])
        }
    }
}
