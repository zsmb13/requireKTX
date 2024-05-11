import com.android.build.gradle.LibraryExtension
import com.vanniktech.maven.publish.MavenPublishBaseExtension
import com.vanniktech.maven.publish.SonatypeHost
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.*
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformType
import org.jetbrains.kotlin.gradle.testing.internal.KotlinTestReport

class KmpLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.multiplatform")
                apply("com.vanniktech.maven.publish")
            }

            configure<KotlinMultiplatformExtension> {
                applyDefaultHierarchyTemplate()

                androidTarget {
                    publishLibraryVariants("release")
                    compilations.all {
                        kotlinOptions {
                            jvmTarget = JavaVersion.VERSION_1_8.toString()
                        }
                    }
                }

                if (target.isNotJustAndroid()) {
                    jvm()
                    iosArm64()
                    iosSimulatorArm64()
                    iosX64()
                    js {
                        browser()
                        nodejs()
                    }
                    linuxArm64()
                    linuxX64()
                    macosArm64()
                    macosX64()
                    tvosArm64()
                    tvosSimulatorArm64()
                    tvosX64()
                    wasmJs()
                    watchosArm32()
                    watchosArm64()
                    watchosSimulatorArm64()
                    watchosX64()
                }

                val commonTest by sourceSets.commonTest
                val jbTest by sourceSets.creating {
                    dependsOn(commonTest)
                }

                targets.forEach { target ->
                    if (target.platformType !in listOf(KotlinPlatformType.androidJvm, KotlinPlatformType.common)) {
                        target.compilations.getByName("test").defaultSourceSet {
                            dependsOn(jbTest)
                        }
                    }
                }

                val allTestsTask = tasks.findByName("allTests")
                allTestsTask?.doFirst {
                    (allTestsTask as KotlinTestReport).ignoreFailures = true
                }

                explicitApi()

                @OptIn(ExperimentalKotlinGradlePluginApi::class)
                compilerOptions {
                    freeCompilerArgs.add("-progressive")
                }
            }

            configure<LibraryExtension> {
                compileSdk = 34
                defaultConfig {
                    minSdk = 21
                }
                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_1_8
                    targetCompatibility = JavaVersion.VERSION_1_8
                }
            }

            configure<MavenPublishBaseExtension> {
                publishToMavenCentral(SonatypeHost.DEFAULT)
                signAllPublications()

                pom {
                    name.set("requireKTX")
                    description.set("Kotlin utilities for easily grabbing required values")
                    inceptionYear.set("2021")
                    url.set("https://github.com/zsmb13/requireKTX")
                    licenses {
                        license {
                            name.set("The Apache License, Version 2.0")
                            url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                            distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                        }
                    }
                    developers {
                        developer {
                            id.set("zsmb13")
                            name.set("Márton Braun")
                            email.set("braunmarci@gmail.com")
                        }
                    }
                    scm {
                        connection.set("scm:git:github.com/zsmb13/requireKTX.git")
                        developerConnection.set("scm:git:ssh://github.com/zsmb13/requireKTX.git")
                        url.set("https://github.com/zsmb13/requireKTX/tree/main")
                    }
                }
            }
        }
    }
}

private fun Project.isNotJustAndroid() = hasProperty("android-only").not()
