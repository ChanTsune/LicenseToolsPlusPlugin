plugins {
    java
    id("com.github.chantsune.kotlin.gradle.template.plugin")
}

templateExampleConfig {
    enableVerify = false
    transformLibrariesInfo {
        it
    }
}
