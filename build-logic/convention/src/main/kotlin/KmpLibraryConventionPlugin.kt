import com.android.build.gradle.LibraryExtension
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

                val commonMain by sourceSets.commonMain
                val jbMain by sourceSets.creating {
                    dependsOn(commonMain)
                }

                targets.forEach { target ->
                    if (target.platformType !in listOf(KotlinPlatformType.androidJvm, KotlinPlatformType.common)) {
                        target.compilations.getByName("main").defaultSourceSet {
                            dependsOn(jbMain)
                        }
                    }
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
        }
    }
}

private fun Project.isNotJustAndroid() = hasProperty("android-only").not()
