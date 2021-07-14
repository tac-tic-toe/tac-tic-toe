import org.jetbrains.compose.compose

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose") version "0.5.0-build245"
    id("com.android.library")
}

group = "com.toleno"
version = "1.0"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

kotlin {
    android()
    jvm("desktop") {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    js("web", IR) {
        browser()
//        binaries.executable()
    }
    /*iosX64 {
        binaries {
            framework {
                baseName = "common"
            }
        }
    }*/
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(compose.runtime)
                api(compose.web.widgets)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        // * Android & Desktop

        val jvmMain by creating {
            dependencies {
                api(compose.foundation)
                api(compose.material)
            }
        }
        val jvmTest by creating

        val androidMain by getting {
            dependsOn(jvmMain)
            dependencies {
                api("androidx.appcompat:appcompat:1.3.0")
                api("androidx.core:core-ktx:1.6.0")
            }
        }
        val androidTest by getting {
            dependsOn(jvmTest)
            dependencies {
                implementation("junit:junit:4.13")
            }
        }
        val desktopMain by getting {
            dependsOn(jvmMain)
        }
        val desktopTest by getting {
            dependsOn(jvmTest)
        }
        val webMain by getting {
            dependencies {
                api(compose.web.core)
            }
        }
        val webTest by getting
        /*val iosX64Main by getting
        val iosX64Test by getting*/
    }
}

android {
    compileSdkVersion(30)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(24)
        targetSdkVersion(30)
    }
}