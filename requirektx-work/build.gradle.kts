plugins {
    alias(libs.plugins.requireKtxLibrary)
}

android.namespace = "co.zsmb.requirektx.work"

kotlin {
    sourceSets {
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        androidMain.dependencies {
            implementation(libs.work.runtime)
        }
        val androidUnitTest by getting {
            dependencies {
                implementation(libs.robolectric)
                implementation(libs.junit)
                implementation(libs.junit.jupiter.api)
                runtimeOnly(libs.junit.jupiter.engine)
                implementation(libs.junit.jupiter.params)
            }
        }
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
