pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "requireKTX"

include(
    ":sample",
    ":requirektx-test-helper",
    ":requirektx-bundle",
    ":requirektx-intent",
    ":requirektx-navigation",
    ":requirektx-work",
)
