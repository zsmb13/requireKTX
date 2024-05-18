plugins {
    alias(libs.plugins.requireKtxLibrary)
    alias(libs.plugins.requireKtxPublishing)
}

android.namespace = "co.zsmb.requirektx.intent"

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(project(":requirektx-bundle"))
        }
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
}
