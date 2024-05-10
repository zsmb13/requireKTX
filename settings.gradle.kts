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

include(":app")
include(":requirektx-bundle")
include(":requirektx-intent")
include(":requirektx-navigation")
include(":requirektx-work")
