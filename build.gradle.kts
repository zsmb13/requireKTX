plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.mavenPublish) apply false
    alias(libs.plugins.binaryCompatValidator)
}

apiValidation {
    ignoredProjects += listOf(
        "app",
        "requirektx-test-helper",
    )
    klib {
        enabled = true
        strictValidation = true
    }
}
