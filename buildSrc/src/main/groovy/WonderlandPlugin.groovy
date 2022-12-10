
import org.apache.tools.ant.filters.ReplaceTokens
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.Copy

import org.gradle.api.provider.Property

abstract class WonderlandPluginExtension {
    abstract Property<String> getCharacterName()
}

class WonderlandPlugin implements Plugin<Project> {
    void apply(Project project) {
        def extension = project.extensions.create('wonderland', WonderlandPluginExtension)
        project.tasks.register('copyQuote', Copy) {
            from 'quote.txt'
            into "$project.buildDir/quotes"
            filter(ReplaceTokens, tokens: [CHARACTER: extension.characterName.get()])
        }
    }
}