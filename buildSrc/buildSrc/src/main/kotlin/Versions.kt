object Versions {
	object JetBrains {
		object Kotlin : GradlePlugin {
			const val version = "1.5.10"
			override val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
		}
		object Compose : GradlePlugin {
			const val version = "0.5.0-build245"
			override val gradlePlugin = "org.jetbrains.compose:compose-gradle-plugin:$version"
		}
	}

	object Android {
		object Version {
			const val code = Project.Version.code
			const val name = Project.Version.name
		}

		object Sdk {
			const val compile = 30
			const val target = 30
			const val min = 24
		}

		object Tools {
			object Build : GradlePlugin {
				const val version = "4.1.2"
				override val gradlePlugin = "com.android.tools.build:gradle:$version"
			}
		}
	}
}