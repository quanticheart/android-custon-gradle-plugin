import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project

class ProjectPlugin implements Plugin<Project> {
    void apply(Project project) {

        project.plugins.apply("org.jetbrains.kotlin.android")
        project.plugins.apply("org.jetbrains.kotlin.kapt")
        project.plugins.apply("config")

        project.android {
            compileSdk 32
            defaultConfig {
                minSdk 23
                targetSdk 32

                testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
                consumerProguardFiles "consumer-rules.pro"
            }
            compileOptions {
                sourceCompatibility JavaVersion.VERSION_1_8
                targetCompatibility JavaVersion.VERSION_1_8
            }
            kotlinOptions {
                jvmTarget = '1.8'
            }
            buildFeatures {
                viewBinding true
            }
        }

        project.dependencies{
            implementation 'androidx.core:core-ktx:1.7.0'

            testImplementation 'junit:junit:4.13.2'
            androidTestImplementation 'androidx.test.ext:junit:1.1.4'
            androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.0'
        }
    }
}