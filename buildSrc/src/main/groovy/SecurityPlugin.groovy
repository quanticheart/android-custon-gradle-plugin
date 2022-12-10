import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.provider.Property

abstract class SecurityPluginExtension {
    abstract Property<String> getTypeSec()
}

class SecurityPlugin implements Plugin<Project> {
    void apply(Project project) {
        def extension = project.extensions.create('security', SecurityPluginExtension)

        project.tasks.register('security') {
            group = "security"
            description = "Security plugin for test"
            doFirst {
                println "Your Security is: ${extension.typeSec.getOrElse("empty")}!"
            }
        }
    }
}