plugins {
    id(AndroidConfig.Plugin.detekt).version(Versions.detekt)
    id(AndroidConfig.Plugin.ktlint).version(Versions.ktlint)
}

buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
    }

    dependencies {
        classpath(Libs.Plugins.buildGradle)
        classpath(Libs.Plugins.kotlinGradle)
        classpath(Libs.Plugins.ktlintGradle)
    }
}

detekt {
    toolVersion = Versions.detekt
    config = files("config/detekt/detekt.yml")
    buildUponDefaultConfig = true
}

tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
    reports {
        xml.required.set(true)
        html.required.set(true)
        txt.required.set(true)
        sarif.required.set(true)
    }
}
