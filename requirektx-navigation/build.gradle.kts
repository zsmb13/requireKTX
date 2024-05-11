plugins {
    alias(libs.plugins.requireKtxLibrary)
    alias(libs.plugins.requireKtxPublishing)
}

android.namespace = "co.zsmb.requirektx.navigation"

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(project(":requirektx-bundle"))
            implementation(libs.navigation.runtime)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
            implementation(project(":requirektx-test-helper"))
        }
    }
}
