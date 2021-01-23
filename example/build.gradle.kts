plugins {
    java
    id("com.github.chantsune.kotlin.gradle.template.plugin")
}

templateExampleConfig {
    enableVerify = false
    transformLibrariesInfo {
        it
    }
    project.file("example-licenses.yml").also {
        inputFile.set(it)
        outputFile.set(it)
    }
}
