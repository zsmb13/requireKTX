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
        androidMain.dependencies {
            implementation("androidx.work:work-runtime:2.5.0")
        }
        val androidUnitTest by getting {
            dependencies {
                implementation("org.robolectric:robolectric:4.5.1")
                implementation("junit:junit:4.13.2")
                implementation("org.junit.jupiter:junit-jupiter-api:5.7.1")
                runtimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.1")
                implementation("org.junit.jupiter:junit-jupiter-params:5.7.1")
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
