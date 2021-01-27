pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        jcenter()
    }
}

rootProject.name = ("LicenceToolsPlus")

include(":example")
includeBuild("plugin-build")
