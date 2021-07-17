plugins {
	kotlin("multiplatform")
	id("org.jetbrains.compose")
}

group = "com.toleno"
version = "1.0"

repositories {
	mavenCentral()
	maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

kotlin {
	js(IR) {
		browser()
		binaries.executable()
	}
	sourceSets {
		named("jsMain") {
			dependencies {
				implementation(project(":common"))
				implementation(compose.web.core)
				implementation(compose.web.widgets)
				implementation(compose.runtime)
			}
		}
		named("jsTest") {
			dependencies {
				implementation(kotlin("test"))
			}
		}
	}
}