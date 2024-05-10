plugins {
    alias(libs.plugins.requireKtxLibrary)
}

android.namespace = "co.zsmb.requirektx.bundle"

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(libs.core.bundle)
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
