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
    ":app",
    ":requirektx-test-helper",
    ":requirektx-bundle",
    ":requirektx-intent",
    ":requirektx-navigation",
    ":requirektx-work",
)
