plugins {
    id(Plugins.ANDROID_APPLICATION)
    kotlin(Plugins.Kotlin.KOTLIN_ANDROID)
    kotlin(Plugins.Kotlin.KOTLIN_ANDROID_EXTENSION)
    kotlin(Plugins.Kotlin.KOTLIN_KAPT)
}

android {

    compileSdkVersion(Config.Application.COMPILE_SDK_VERSION)

    defaultConfig {
        applicationId = Config.Application.APPLICATION_ID

        versionCode = Config.Application.VERSION_CODE
        versionName = Config.Application.VERSION_NAME

        minSdkVersion(Config.Application.MIN_SDK_VERSION)
        targetSdkVersion(Config.Application.TARGET_SDK_VERSION_)

        testInstrumentationRunner = Libs.AndroidX.Test.Junit.JUNIT_RUNNER

        kapt {
            arguments {
                arg("room.schemaLocation", "$projectDir/schemas")
            }
        }
    }

    /*signingConfigs {
        create(SigningConfigs.Debug.NAME) {
            keyAlias = SigningConfigs.Debug.KEY_ALIAS
            keyPassword = SigningConfigs.Debug.KEY_PASSWORD
            storePassword = SigningConfigs.Debug.STORE_PASSWORD
            storeFile = file(SigningConfigs.Debug.STORE_FILE)
        }

        create(Release.name) {
            keyAlias = Release.keyAlias
            keyPassword = Release.keyPassword
            storePassword = Release.storePassword
            storeFile = file(Release.storeFile)
        }
    }*/

    buildTypes {
        getByName("debug") {
            buildConfigField("String", Config.Key.API_DOMAIN, "\"${Debug.API_DOMAIN}\"")
        }
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", Config.Key.API_DOMAIN, "\"${Release.API_DOMAIN}\"")
        }
    }

    viewBinding.isEnabled = true
    dataBinding.isEnabled = true

    // To inline the bytecode built with JVM target 1.8 into
    // bytecode that is being built with JVM target 1.6. (e.g. navArgs)
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions.jvmTarget = "1.8"
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(Libs.Kotlin.KOTLIN_STD_LIB)
    implementation(Libs.MATERIAL_DESIGN)
    implementation(Libs.GSON)

    implementation(Libs.AndroidX.APP_COMPAT)
    implementation(Libs.AndroidX.CONSTRAINT_LAYOUT)
    implementation(Libs.AndroidX.ANDROIDX_CORE)
    implementation(Libs.AndroidX.PAGING_RUNTIME)
    implementation(Libs.AndroidX.WORK_RUNTIME)

    implementation(Libs.AndroidX.Navigation.NAVIGATION_FRAGMENT)
    implementation(Libs.AndroidX.Navigation.NAVIGATION_UI)

    implementation(Libs.AndroidX.Lifecycle.LIVEDATA)
    implementation(Libs.AndroidX.Lifecycle.VIEWMODEL)
    implementation(Libs.AndroidX.Lifecycle.VIEWMODEL_SAVED_STATE)
    kapt(Libs.AndroidX.Lifecycle.LIFECYCLE_COMPILER)
    implementation(Libs.AndroidX.Lifecycle.LIFECYCLE_PROCESS)
    implementation(Libs.AndroidX.Lifecycle.LIFECYCLE_COMMON)
    implementation(Libs.AndroidX.Lifecycle.LIFECYCLE_RUNTIME)
    implementation(Libs.AndroidX.Lifecycle.LIFECYCLE_EXTENSIONS)
    implementation(Libs.AndroidX.Lifecycle.LIFECYCLE_SERVICE)

    implementation(Libs.Glide.GLIDE)
    implementation(Libs.Glide.GLIDE_OKHTTP3)
    kapt(Libs.Glide.GLIDE_COMPILER)

    implementation(Libs.TIMBER)

    implementation(Libs.AndroidX.Test.ESPRESSO_CORE)
    implementation(Libs.AndroidX.Test.Junit.JUNIT)
    implementation(Libs.Test.JUNIT)

    implementation(Libs.AndroidX.Room.ROOM_RUNTIME)
    implementation(Libs.AndroidX.Room.ROOM_KTX)
    kapt(Libs.AndroidX.Room.ROOM_COMPILER)

    implementation(Libs.Coroutines.COROUTINES)
    implementation(Libs.Coroutines.COROUTINES_ANDROID)

    implementation(Libs.Okhttp.OKHTTP_LOGGING_INTERCEPTOR)
    implementation(Libs.Okhttp.OKHTTP_URL_CONNECTION)

    implementation(Libs.Retrofit.RETROFIT)
    implementation(Libs.Retrofit.RETROFIT_GSON_CONVERTER)

    implementation(Libs.Dagger.DAGGER)
    implementation(Libs.Dagger.DAGGER_ANDROID)
    implementation(Libs.Dagger.DAGGER_ANDROID_SUPPORT)
    kapt(Libs.Dagger.DAGGER_COMPILER)
    kapt(Libs.Dagger.DAGGER_PROCESSOR)
    kapt(Libs.Dagger.DAGGER2_PROCESSOR)
    compileOnly(Libs.Dagger.DAGGER2_ANNOTATIONS)
    compileOnly(Libs.JAVAX_ANNOTATION)

    implementation(Libs.Facebook.Stetho.STETHO)
    implementation(Libs.Facebook.Stetho.STETHO_OKHTTP3)
    implementation(Libs.Facebook.Flipper.FLIPPER)
    implementation(Libs.Facebook.Flipper.FLIPPER_NETWORK)
    //implementation(Libs.Facebook.Flipper.FLIPPER_NOOP)
    implementation(Libs.Facebook.SOLOADER)
}
