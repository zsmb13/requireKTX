import com.vanniktech.maven.publish.MavenPublishBaseExtension
import com.vanniktech.maven.publish.SonatypeHost
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.*

class PublishingConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.vanniktech.maven.publish")
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
