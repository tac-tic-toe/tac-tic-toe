plugins {
	id("web")
}

kotlin {
	js("web", IR) {
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