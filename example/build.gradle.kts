plugins {
    java
    id("com.github.chantsune.kotlin.gradle.template.plugin")
}

templateExampleConfig {
    message.set("Just trying this gradle plugin...")
    transformLibrariesInfo {
        it
    }
}
