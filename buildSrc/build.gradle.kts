plugins {
	id("base")
	`kotlin-dsl`
}

repositories {
	mavenLocal()
	google()
	mavenCentral()
	maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
	gradlePluginPortal()
}

dependencies {
	gradlePlugin(Versions.JetBrains.Compose)
	gradlePlugin(Versions.JetBrains.Kotlin)
	gradlePlugin(Versions.Android.Tools.Build)
}

kotlin {
	// Add Deps to compilation, so it will become available in main project
	sourceSets.getByName("main").kotlin.srcDir("buildSrc/src/main/kotlin")
}