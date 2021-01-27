# LicenseToolsPluginPlus

## Setup

```groovy
buildscript {
    repositories {
        maven {
            url("https://raw.githubusercontent.com/ChanTsune/LicenseToolsPlusPlugin/maven/repository")
        }
    }
    dependencies {
        classpath "com.github.chantsune.gradle.plugin.license-tools-plus:com.github.chantsune.gradle.plugin.license-tools-plus.gradle.plugin:${version}"
    }
}
```

```groovy
plugin {
    id "com.github.chantsune.gradle.plugin.license-tools-plus"
}
```

## License

This project published under MIT License.

This plugin used [cortinico/kotlin-gradle-plugin-template](https://github.com/cortinico/kotlin-gradle-plugin-template) for a template.
