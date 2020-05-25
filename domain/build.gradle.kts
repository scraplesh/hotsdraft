plugins {
    id("java-library")
    id("kotlin")
}

java.sourceCompatibility = JavaVersion.VERSION_1_8
java.targetCompatibility = JavaVersion.VERSION_1_8

dependencies {
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinGradlePlugin}")
}
