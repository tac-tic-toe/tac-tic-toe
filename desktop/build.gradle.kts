import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
	id("desktop")
}

repositories {
	mavenCentral()
	maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

kotlin {
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