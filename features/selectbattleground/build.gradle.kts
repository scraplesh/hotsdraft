plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlin-android-extensions")
}

android {
    compileSdkVersion(AndroidConfig.compileSdkVersion)

    defaultConfig {
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
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
        getByName("debug") {}
    }

    compileOptions {
        sourceCompatibility = Versions.java
        targetCompatibility = Versions.java
    }

    sourceSets.getByName("main") {
        java.srcDir("src/main/kotlin")
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(":common"))
    implementation(project(":domain"))

    implementation(Deps.androidxAppCompat)
    implementation(Deps.androidxCardView)
    implementation(Deps.androidxConstraintLayout)
    implementation(Deps.koinScope)
    implementation(Deps.kotlinStdLib)
}
