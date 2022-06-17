package com.onix.internship.ui.game

import com.onix.internship.ui.game.entities.CellState

data class GameModel(
    var boardArrayIndexes: Array<Array<CellState>> = Array(3) { Array(3){ CellState.EMPTY}}
)



