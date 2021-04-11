plugins {
    java
    id("com.cookpad.android.plugin.license-tools") version "1.2.6"
    id("com.github.chantsune.license-tools-plus")
}

licenseToolsPlus {
    enableVerify = false
    transformLibrariesInfo {
        name
    }
    project.file("example-licenses.yml").also {
        inputFile.set(it)
        outputFile.set(it)
    }
}
