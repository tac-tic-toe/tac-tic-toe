plugins {
    id("base")
    id("org.jetbrains.compose")
    id("com.android.application")
    kotlin("android")
}

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    implementation(project(":common:client"))
    implementation("androidx.activity:activity-compose:1.3.0-rc01")
}

android {
    compileSdkVersion(Versions.Android.Sdk.compile)
    defaultConfig {
        applicationId = "com.toleno.android"
        minSdkVersion(Versions.Android.Sdk.min)
        targetSdkVersion(Versions.Android.Sdk.target)
        versionCode = Versions.Android.Version.code
        versionName = Versions.Android.Version.name
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}