plugins {
    id(Plugins.ANDROID_APPLICATION)
    kotlin(Plugins.Kotlin.KOTLIN_ANDROID)
    kotlin(Plugins.Kotlin.KOTLIN_ANDROID_EXTENSION)
    kotlin(Plugins.Kotlin.KOTLIN_KAPT)
}

android {
    compileSdkVersion(Versions.Build.COMPILE_SDK_VERSION)

    defaultConfig {
        applicationId = "com.ktvipin27.mvvmstarter"

        minSdkVersion(Versions.Build.MIN_SDK_VERSION)
        targetSdkVersion(Versions.Build.TARGET_SDK_VERSION)

        versionCode = Versions.VERSION_CODE
        versionName = Versions.VERSION_NAME

        testInstrumentationRunner = Libs.AndroidX.Test.Junit.JUNIT_RUNNER
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

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
    implementation(Libs.AndroidX.APP_COMPAT)
    implementation(Libs.AndroidX.CONSTRAINT_LAYOUT)
    implementation(Libs.AndroidX.ANDROIDX_CORE)
    implementation(Libs.AndroidX.MATERIAL_DESIGN)
    implementation(Libs.AndroidX.Navigation.NAVIGATION_FRAGMENT)
    implementation(Libs.AndroidX.Navigation.NAVIGATION_UI)
    implementation(Libs.AndroidX.Test.ESPRESSO_CORE)
    implementation(Libs.AndroidX.Test.Junit.JUNIT)
    implementation(Libs.Test.JUNIT)
}
