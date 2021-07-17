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