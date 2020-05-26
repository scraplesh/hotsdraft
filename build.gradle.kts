buildscript {
    repositories {
        jcenter()
        google()
    }
    dependencies {
        classpath(Deps.androidGradlePlugin)
        classpath(Deps.kotlinGradlePlugin)
        classpath(Deps.googleServicesPlugin)
    }
}
allprojects {
    repositories {
        jcenter()
        google()
    }
}

task("clean") {
    delete(rootProject.buildDir)
}
