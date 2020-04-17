object Plugins {
    const val ANDROID_APPLICATION = "com.android.application"
    const val FABRIC = "io.fabric"
    const val GOOGLE_SERVICES = "com.google.gms.google-services"

    object Kotlin {
        const val KOTLIN_ANDROID = "android"
        const val KOTLIN_ANDROID_EXTENSION = "android.extensions"
        const val KOTLIN_KAPT = "kapt"
    }

    object Gradle {
        const val GRADLE_ANDROID = "com.android.tools.build:gradle:3.6.2"
        const val GRADLE_KOTLIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.72"
        const val GRADLE_FABRIC = "io.fabric.tools:gradle:1.28.1"
        const val GRADLE_GOOGLE_SERVICE = "com.google.gms:google-services:4.2.0"
    }
}

object Libs {
    object AndroidX {
        const val APP_COMPAT = "androidx.appcompat:appcompat:1.1.0"
        const val ANDROIDX_CORE = "androidx.core:core-ktx:1.2.0"
        const val MATERIAL_DESIGN = "com.google.android.material:material:1.1.0"
        const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:1.1.3"

        object Navigation {
            private const val version = "2.2.2"
            const val NAVIGATION_FRAGMENT = "androidx.navigation:navigation-fragment-ktx:$version"
            const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:$version"
        }

        object Lifecycle {
            private const val version = "2.1.0"
            const val LIFECYCLE_EXTENSIONS = "androidx.lifecycle:lifecycle-extensions:$version"
        }

        object Test {
            const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:3.2.0"

            object Junit {
                const val JUNIT = "androidx.test.ext:junit:1.1.1"
                const val JUNIT_RUNNER = "androidx.test.runner.AndroidJUnitRunner"
            }
        }
    }

    object Kotlin {
        private const val version = "1.3.72"
        const val KOTLIN_STD_LIB = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
    }

    object Test {
        const val JUNIT = "junit:junit:4.12"
    }
}