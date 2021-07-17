import org.gradle.api.artifacts.dsl.DependencyHandler

interface GradlePlugin {
	val gradlePlugin: DependencyNotation
}

fun DependencyHandler.gradlePlugin(gradlePlugin: GradlePlugin) =
	add("implementation", gradlePlugin.gradlePlugin)