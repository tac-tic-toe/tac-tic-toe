package com.toleno.common

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import next

class Game(dimensions: Int = 1, size: Int = 3) {
	var board = Board(dimensions, size)
	var next by mutableStateOf(Player.X)

	fun move() {


		next = next.next()
	}
}