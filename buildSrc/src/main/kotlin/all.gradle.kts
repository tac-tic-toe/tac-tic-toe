import org.jetbrains.compose.compose

plugins {
	id("base")
	kotlin("multiplatform")
	id("org.jetbrains.compose")
	id("com.android.library")
}

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
			}
		}
		val commonTest by getting {
			dependencies {
				implementation(kotlin("test"))
			}
		}

		// * Android & Desktop

		val jvmMain by creating
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
	compileSdkVersion(Versions.Android.Sdk.compile)
	sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
	defaultConfig {
		minSdkVersion(Versions.Android.Sdk.min)
		targetSdkVersion(Versions.Android.Sdk.target)
	}
}