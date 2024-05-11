import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.*
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformType

class KmpLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.multiplatform")
            }

            configure<KotlinMultiplatformExtension> {
                // Create Kotlin Multiplatform targets
                applyDefaultHierarchyTemplate()
                when {
                    isAndroidOnly() -> configureAndroid()
                    isCiTest() -> configureCiTestTargets()
                    else -> configureAllTargets()
                }

                // Create jbMain source set (all - android)
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

                // Create jbTest source set (all - android)
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

                // Compiler settings
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

    private fun KotlinMultiplatformExtension.configureAndroid() {
        androidTarget {
            publishLibraryVariants("release")
            compilations.all {
                kotlinOptions {
                    jvmTarget = JavaVersion.VERSION_1_8.toString()
                }
            }
        }
    }

    private fun KotlinMultiplatformExtension.configureCiTestTargets() {
        configureAndroid()
        jvm()
        iosSimulatorArm64()
        js {
            browser()
            nodejs()
        }
        macosArm64()
    }

    private fun KotlinMultiplatformExtension.configureAllTargets() {
        configureAndroid()
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

    private fun Project.isAndroidOnly() = hasProperty("android-only")
    private fun Project.isCiTest() = System.getenv("IS_CI_TEST") != null || hasProperty("is-ci-test")
}
