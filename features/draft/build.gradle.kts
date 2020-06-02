plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdkVersion(AndroidConfig.compileSdkVersion)

    defaultConfig {
        minSdkVersion(AndroidConfig.minSdkVersion)
        targetSdkVersion(AndroidConfig.targetSdkVersion)
        versionCode = AndroidConfig.versionCode
        versionName = AndroidConfig.versionName
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

    implementation(Deps.adapterDelegatesKotlinDsl)
    implementation(Deps.androidxAppCompat)
    implementation(Deps.androidxConstraintLayout)
    implementation(Deps.androidxCoordinatorLayout)
    implementation(Deps.androidxLifecycleRuntimeKtx)
    implementation(Deps.androidxLifecycleViewModelKtx)
    implementation(Deps.androidxRecyclerView)
    implementation(Deps.coroutinesCore)
    implementation(Deps.coroutinesAndroid)
    implementation(Deps.koinScope)
    implementation(Deps.koinViewModel)
    implementation(Deps.kotlinStdLib)
    implementation(Deps.material)
}
