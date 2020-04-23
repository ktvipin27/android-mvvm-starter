object Plugins {
    const val ANDROID_APPLICATION = "com.android.application"
    const val FABRIC = "io.fabric"
    const val GOOGLE_SERVICES = "com.google.gms.google-services"
    const val FIREBASE_PREF = "com.google.firebase:perf-plugin:1.3.1"

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
    const val MATERIAL_DESIGN = "com.google.android.material:material:1.1.0"
    const val GSON = "com.google.code.gson:gson:2.8.5"
    const val TIMBER = "com.jakewharton.timber:timber:4.7.1"


    object AndroidX {
        const val APP_COMPAT = "androidx.appcompat:appcompat:1.1.0"
        const val ANDROIDX_CORE = "androidx.core:core-ktx:1.2.0"
        const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:1.1.3"
        const val PAGING_RUNTIME = "androidx.paging:paging-runtime-ktx:2.1.2"
        const val WORK_RUNTIME = "androidx.work:work-runtime-ktx:2.3.4"

        object Navigation {
            private const val version = "2.2.2"
            const val NAVIGATION_FRAGMENT = "androidx.navigation:navigation-fragment-ktx:$version"
            const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:$version"
        }

        object Lifecycle {
            private const val version = "2.2.0"
            const val VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
            const val LIVEDATA = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
            const val VIEWMODEL_SAVED_STATE =
                "androidx.lifecycle:lifecycle-viewmodel-savedstate:$version"
            const val LIFECYCLE_EXTENSIONS = "androidx.lifecycle:lifecycle-extensions:$version"
            const val LIFECYCLE_COMPILER = "androidx.lifecycle:lifecycle-compiler:$version"
            const val LIFECYCLE_SERVICE = "androidx.lifecycle:lifecycle-service:$version"
            const val LIFECYCLE_PROCESS = "androidx.lifecycle:lifecycle-process:$version"
        }

        object Room {
            private const val version = "2.2.5"
            const val ROOM_RUNTIME = "androidx.room:room-runtime:$version"
            const val ROOM_KTX = "androidx.room:room-ktx:$version"
            const val ROOM_COMPILER = "androidx.room:room-compiler:$version"
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

    object Coroutines {
        private const val version = "1.3.5"
        const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
    }

    object Okhttp {
        private const val version = "4.4.0"
        const val OKHTTP_LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:$version"
        const val OKHTTP_URL_CONNECTION = "com.squareup.okhttp3:okhttp-urlconnection:$version"
    }

    object Retrofit {
        private const val version = "2.6.0"
        const val RETROFIT = "com.squareup.retrofit2:retrofit:$version"
        const val RETROFIT_GSON_CONVERTER = "com.squareup.retrofit2:converter-gson:$version"
    }

    object Glide {
        private const val version = "4.11.0"
        const val GLIDE = "com.github.bumptech.glide:glide:$version"
        const val GLIDE_COMPILER = "com.github.bumptech.glide:compiler:$version"
        const val GLIDE_OKHTTP3 = "com.github.bumptech.glide:okhttp3-integration:$version"
    }

    object Apache {
        const val APACHE_COMMONS_IO = "commons-io:commons-io:20030203.000550"
        const val APACHE_COMMONS_NET = "commons-net:commons-net:20030805.205232"
    }


    object DEEPLINK {
        const val DEEPLINK_DISPATCH = "com.airbnb:deeplinkdispatch:4.1.0"
        const val DEEPLINK_DISPATCH_PROCESSOR = "com.airbnb:deeplinkdispatch-processor:4.1.0"
    }

    object Firebase {
        const val FIREBASE_CORE = "com.google.firebase:firebase-core:17.2.2"
        const val FIREBASE_AUTH = "com.google.firebase:firebase-auth:19.3.0"
        const val FIREBASE_MESSAGING = "com.google.firebase:firebase-messaging:20.1.0"
        const val FIREBASE_ANALYTICS = "com.google.firebase:firebase-analytics:17.2.2"
        const val FIREBASE_DYNAMIC_LINKS = "com.google.firebase:firebase-dynamic-links:19.1.0"
        const val FIREBASE_PERF = "com.google.firebase:firebase-perf:19.0.5"
        const val FIREBASE_CONFIG = "com.google.firebase:firebase-config:19.1.1"
        const val FIREBASE_CRASHLYTICS = "com.crashlytics.sdk.android:crashlytics:2.10.1"
    }

    object Google {
        private const val version = "17.0.0"
        const val GOOGLE_MAPS = "com.google.android.gms:play-services-maps:$version"
        const val GOOGLE_LOCATION = "com.google.android.gms:play-services-location:$version"
        const val GOOGLE_PLACES = "com.google.android.gms:play-services-places:$version"
        const val GOOGLE_AUTH = "com.google.android.gms:play-services-auth:$version"
    }

    object Facebook {
        const val FACEBOOK_LOGIN = "com.facebook.android:facebook-login:5.15.3"
        const val CONNECTION_CLASS = "com.facebook.network.connectionclass:connectionclass:1.0.1"
        const val SOLOADER = "com.facebook.soloader:soloader:0.8.2}"

        object Stetho {
            private const val version = "1.5.1"
            const val STETHO = "com.facebook.stetho:stetho:$version"
            const val STETHO_OKHTTP3 = "com.facebook.stetho:stetho-okhttp3:$version"
        }

        object Flipper {
            private const val version = "0.33.1"
            const val FLIPPER = "com.facebook.flipper:flipper:$version"
            const val FLIPPER_NETWORK = "com.facebook.flipper:flipper-network-plugin:$version"
            const val FLIPPER_NOOP = "com.facebook.flipper:flipper-noop:$version"
        }
    }

    object Test {
        const val JUNIT = "junit:junit:4.12"
    }
}