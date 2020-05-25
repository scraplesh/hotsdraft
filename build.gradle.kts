buildscript {
    repositories {
        jcenter()
        google()
    }
    dependencies {
        classpath(Deps.androidGradlePlugin)
        classpath(Deps.kotlinGradlePlugin)
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
