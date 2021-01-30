object PluginCoordinates {
    const val ARTIFACT_ID = "license-tools-plus"
    const val GROUP = "com.github.chantsune"
    const val ID = "$GROUP.$ARTIFACT_ID"
    const val VERSION = "0.2.0"
    const val IMPLEMENTATION_CLASS = "com.github.chantsune.gradle.plugin.license.LicenseToolsPlusPlugin"
}

object PluginBundle {
    const val VCS = "https://github.com/ChanTsune/LicenseToolsPlusPlugin"
    const val WEBSITE = "https://github.com/ChanTsune/LicenseToolsPlusPlugin"
    const val DESCRIPTION = "Edit the yaml file generated by the Cookpad License Tools plugin"
    const val DISPLAY_NAME = "License Tools plugin Extension"
    val TAGS = listOf(
        "plugin",
        "gradle",
        "license"
    )
}

