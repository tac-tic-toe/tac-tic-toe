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
	js("web", IR) {
		browser()
		binaries.executable()
	}
	sourceSets {
		named("webMain") {
			dependencies {
				implementation(project(":common:client"))
				implementation(compose.web.core)
				implementation(compose.web.widgets)
				implementation(compose.runtime)
			}
		}
		named("webTest") {
			dependencies {
				implementation(kotlin("test"))
			}
		}
	}
}