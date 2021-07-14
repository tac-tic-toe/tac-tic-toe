plugins {
	kotlin("js")
	id("org.jetbrains.compose") version "0.5.0-build245"
}

group = "com.toleno"
version = "1.0"

repositories {
	mavenCentral()
	maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
//	implementation(project(":common"))
	implementation(compose.web.core)
//	implementation(compose.web.widgets)
	implementation(compose.runtime)
	testImplementation(kotlin("test"))
}

kotlin {
	js(IR) {
		browser()
		binaries.executable()
	}
}