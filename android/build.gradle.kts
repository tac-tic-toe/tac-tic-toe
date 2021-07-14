plugins {
    id("org.jetbrains.compose") version "0.5.0-build245"
    id("com.android.application")
    kotlin("android")
}

group = "com.toleno"
version = "1.0"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    implementation(project(":common"))
    implementation("androidx.activity:activity-compose:1.3.0-rc01")
}

android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "com.toleno.android"
        minSdkVersion(24)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}