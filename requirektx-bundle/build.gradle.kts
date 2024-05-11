plugins {
    alias(libs.plugins.requireKtxLibrary)
    alias(libs.plugins.requireKtxPublishing)
}

android.namespace = "co.zsmb.requirektx.bundle"

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(libs.core.bundle)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
            implementation(project(":requirektx-test-helper"))
        }
        val androidUnitTest by getting {
            dependencies {
                implementation(libs.junit)
                implementation(libs.robolectric)
            }
        }
    }
}
