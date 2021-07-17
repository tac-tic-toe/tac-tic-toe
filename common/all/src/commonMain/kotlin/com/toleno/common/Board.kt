package com.toleno.common

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList

data class Board(val dimensions: Int = 1, val size: Int = 3) : Cell() {
	/**
	 * Two dimensional list
	 */
	val cells = mutableStateListOf<SnapshotStateList<Cell>>()

	init {
		(0..size).forEach { x ->
			cells[x] = mutableStateListOf()
			(0..size).forEach { y ->
				cells[x][y] =
					if (dimensions == 1) Cell()
					else Board(dimensions - 1, size)
			}
		}
	}
}