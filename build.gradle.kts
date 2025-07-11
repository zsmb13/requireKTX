plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.mavenPublish) apply false
}

//
//apiValidation {
//    ignoredProjects += listOf(
//        "sample",
//        "requirektx-test-helper",
//    )
//    klib {
//        enabled = true
//        strictValidation = true
//    }
//}
