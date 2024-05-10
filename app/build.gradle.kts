plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "11"
            }
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    
    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.24")
        implementation("androidx.core:core-ktx:1.5.0")
        implementation("androidx.appcompat:appcompat:1.3.0")
        implementation("com.google.android.material:material:1.3.0")
        implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    }
}
