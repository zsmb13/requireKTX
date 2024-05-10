plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

kotlin {
    androidTarget {
        publishLibraryVariants("release")
        compilations.all {
            kotlinOptions {
                jvmTarget = "11"
            }
        }
    }

    sourceSets {
        commonMain.dependencies {}
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        val androidUnitTest by getting {
            dependencies {
                implementation(libs.robolectric)
                implementation(libs.junit)
            }
        }
    }

    explicitApi()
    // TODO progressive mode
}

android {
    namespace = "co.zsmb.requirektx"
    compileSdk = 34

    defaultConfig {
        minSdk = 21
    }
}
