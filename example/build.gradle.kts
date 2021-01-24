plugins {
    java
    id("com.cookpad.android.plugin.license-tools") version "1.2.5"
    id("com.github.chantsune.kotlin.gradle.template.plugin")
}

licenseToolsPlus {
    enableVerify = false
    transformLibrariesInfo {
        it
    }
    project.file("example-licenses.yml").also {
        inputFile.set(it)
        outputFile.set(it)
    }
}
