plugins {
    alias(libs.plugins.requireKtxLibrary)
}

android.namespace = "co.zsmb.requirektx.intent"

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(project(":requirektx-bundle"))
            implementation("org.jetbrains.androidx.core:core-bundle:1.0.0-rc01")
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
