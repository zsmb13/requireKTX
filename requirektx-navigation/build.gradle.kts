plugins {
    alias(libs.plugins.requireKtxLibrary)
}

android.namespace = "co.zsmb.requirektx.navigation"

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(project(":requirektx-bundle"))
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        androidMain.dependencies {
            implementation(libs.navigation.runtime)
        }
        val androidUnitTest by getting {
            dependencies {
                implementation(libs.robolectric)
                implementation(libs.junit)
            }
        }
    }
}
