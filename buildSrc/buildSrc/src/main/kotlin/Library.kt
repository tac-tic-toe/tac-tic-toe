import org.gradle.api.artifacts.dsl.DependencyHandler

interface Library {
	val library: DependencyNotation
}

fun DependencyHandler.library(library: Library, open: Boolean = false) =
	add(if (open) "api" else "implementation", library.library)