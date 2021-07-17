import org.gradle.kotlin.dsl.kotlin
import org.gradle.kotlin.dsl.maven
import org.gradle.kotlin.dsl.repositories

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
}