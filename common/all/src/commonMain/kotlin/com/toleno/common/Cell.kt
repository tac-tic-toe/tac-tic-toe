package com.toleno.common

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

open class Cell {
	var player: Player? by mutableStateOf(null)
}