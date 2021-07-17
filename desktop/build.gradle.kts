import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
	id("base")
	kotlin("multiplatform")
	id("org.jetbrains.compose")
}

repositories {
	mavenCentral()
	maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

kotlin {
	jvm("desktop") {
		compilations.all {
			kotlinOptions.jvmTarget = "1.8"
		}
		testRuns["test"].executionTask.configure {
			useJUnitPlatform()
		}
	}
	sourceSets {
		named("desktopMain") {
			dependencies {
				implementation(project(":common:client"))
				implementation(compose.desktop.currentOs)
			}
		}
		named("desktopTest") {
			dependencies {
				implementation(kotlin("test"))
			}
		}
	}
}

compose.desktop {
	application {
		mainClass = "MainKt"
		nativeDistributions {
			targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
			packageName = "jvm"
			packageVersion = "1.0.0"
		}
	}
}