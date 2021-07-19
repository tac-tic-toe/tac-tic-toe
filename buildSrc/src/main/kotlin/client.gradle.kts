import gradle.kotlin.dsl.accessors._7a28de8fd55aaf24a75c93b47577aa9d.kotlin
import gradle.kotlin.dsl.accessors._7a28de8fd55aaf24a75c93b47577aa9d.sourceSets
import org.gradle.kotlin.dsl.getting
import org.jetbrains.compose.compose

plugins {
	id("all")
}

kotlin {
	sourceSets {
		val commonMain by getting {
			dependencies {
				api(compose.web.widgets)
			}
		}
		val jvmMain by getting {
			dependencies {
				api(compose.foundation)
				api(compose.material)
			}
		}
	}
}