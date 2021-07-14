package com.toleno.common

import androidx.compose.runtime.*
import org.jetbrains.compose.common.material.Button
import org.jetbrains.compose.common.material.Text

@Composable
fun App() {
	var text by remember { mutableStateOf("Hello, World!") }

	Button(onClick = {
		text = "Hello, ${getPlatformName()}"
	}) {
		Text(text)
	}
}
