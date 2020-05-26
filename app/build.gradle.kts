//import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android-extensions")
    id("com.google.gms.google-services")
}

android {
    compileSdkVersion(AndroidConfig.compileSdkVersion)

    defaultConfig {
        applicationId = AndroidConfig.applicationId
        minSdkVersion(AndroidConfig.minSdkVersion)
        targetSdkVersion(AndroidConfig.targetSdkVersion)
        versionCode = AndroidConfig.versionCode
        versionName = AndroidConfig.versionName

        androidExtensions {
            isExperimental = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
        getByName("debug") {
            applicationIdSuffix = ".debug"
        }
    }

    compileOptions {
        sourceCompatibility = Versions.java
        targetCompatibility = Versions.java
    }

    sourceSets.getByName("main") {
        java.srcDir("src/main/kotlin")
    }
}

dependencies {
    implementation(project(":common"))
    implementation(project(":domain"))

    implementation(project(":feature-draft"))
    implementation(project(":feature-lot"))
    implementation(project(":feature-selectbattleground"))
    implementation(project(":feature-heroproposal"))

    implementation(Deps.androidxAppCompat)
    implementation(Deps.cicerone)
    implementation(Deps.firebaseAnalytics)
    implementation(Deps.koinCore)
    implementation(Deps.koinScope)
    implementation(Deps.kotlinStdLib)
}

//tasks.withType(org.jetbrains.kotlin.gradle.dsl.KotlinCompile::class).all {
//    kotlinOptions {
//        freeCompilerArgs = freeCompilerArgs + listOf(
//            "-Xuse-experimental=kotlinx.coroutines.ExperimentalCoroutinesApi",
//            "-Xuse-experimental=kotlinx.coroutines.ObsoleteCoroutinesApi"
//        )
//    }
//}
