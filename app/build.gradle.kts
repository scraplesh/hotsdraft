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

    signingConfigs {
        getByName("debug") {
            storeFile = file("../signing/debug.jks")
            storePassword = "android"
            keyAlias = "androiddebugkey"
            keyPassword = "android"
        }
        create("release") {
            storeFile = file("../signing/release.jks")
            val hotsDraftStorePassword: String by project
            storePassword = hotsDraftStorePassword
            val hotsDraftReleaseKeyAliasFromSettings: String by project
            keyAlias = hotsDraftReleaseKeyAliasFromSettings
            val hotsDraftReleaseKeyPasswordFromSettings: String by project
            keyPassword = hotsDraftReleaseKeyPasswordFromSettings
        }
    }

    buildTypes {
        getByName("release") {
            signingConfig = signingConfigs.getByName("release")
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
        getByName("debug") {
            signingConfig = signingConfigs.getByName("debug")
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
    implementation(project(":mviflow"))

    implementation(project(":feature-draft"))
    implementation(project(":feature-lot"))
    implementation(project(":feature-selectbattleground"))

    implementation(Deps.androidxAppCompat)
    implementation(Deps.cicerone)
    implementation(Deps.coroutinesCore)
    implementation(Deps.firebaseAnalytics)
    implementation(Deps.koinCore)
    implementation(Deps.koinScope)
    implementation(Deps.koinViewModel)
    implementation(Deps.kotlinStdLib)
    implementation(Deps.material)
}
