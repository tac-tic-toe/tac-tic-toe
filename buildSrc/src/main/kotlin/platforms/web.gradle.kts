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
	}
}