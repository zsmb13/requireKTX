plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(libs.core.ktx)
            implementation(libs.appcompat)
            implementation(libs.material)
            implementation(libs.constraintlayout)

            implementation(project(":requirektx-bundle"))
            implementation(project(":requirektx-intent"))
            implementation(project(":requirektx-navigation"))
            implementation(project(":requirektx-work"))
        }
    }
}

android {
    namespace = "co.zsmb.requirektx"
    compileSdk = 34

    defaultConfig {
        applicationId = "co.zsmb.requirektx"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}
