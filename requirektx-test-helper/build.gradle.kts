plugins {
    alias(libs.plugins.requireKtxLibrary)
}

android.namespace = "co.zsmb.requirektx.bundle"

kotlin {
    sourceSets {
        androidMain.dependencies {
            implementation(libs.robolectric)
            implementation(libs.junit)
        }
    }
}
