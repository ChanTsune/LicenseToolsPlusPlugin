plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    id("java-gradle-plugin")
    id("com.gradle.plugin-publish")
    id("maven-publish")
}

dependencies {
    implementation(gradleApi())

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.SERIALIZATION}")
    implementation("com.charleskorn.kaml:kaml:${Versions.KAML}")

    testImplementation(TestingLib.JUNIT)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

gradlePlugin {
    plugins {
        create(PluginCoordinates.ID) {
            id = PluginCoordinates.ID
            implementationClass = PluginCoordinates.IMPLEMENTATION_CLASS
            version = PluginCoordinates.VERSION
        }
    }
}

// Configuration Block for the Plugin Marker artifact on Plugin Central
pluginBundle {
    website = PluginBundle.WEBSITE
    vcsUrl = PluginBundle.VCS
    description = PluginBundle.DESCRIPTION
    tags = PluginBundle.TAGS

    plugins {
        getByName(PluginCoordinates.ID) {
            displayName = PluginBundle.DISPLAY_NAME
        }
    }
}

tasks.create("setupPluginUploadFromEnvironment") {
    doLast {
        val key = System.getenv("GRADLE_PUBLISH_KEY")
        val secret = System.getenv("GRADLE_PUBLISH_SECRET")

        if (key == null || secret == null) {
            throw GradleException("gradlePublishKey and/or gradlePublishSecret are not defined environment variables")
        }

        System.setProperty("gradle.publish.key", key)
        System.setProperty("gradle.publish.secret", secret)
    }
}

publishing {
    publications {
        create("plugin", MavenPublication::class.java) {
            from(components.findByName("java"))
            groupId = PluginCoordinates.GROUP
            artifactId = PluginCoordinates.ARTIFACT_ID
            version = PluginCoordinates.VERSION
        }
    }
}
