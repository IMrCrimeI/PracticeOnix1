package com.onix.internship.ui.game

import android.util.Log
import com.onix.internship.arch.BaseViewModel

class GameViewModel: BaseViewModel() {
//    val gameBoard = Array(3) { IntArray(3) }

    val gameBoard = GameModel().gameBoard

    var winType = arrayOf(-1, -1, -1)
    private var boardFilled = 0
    private var player = 1

    fun updateGameBoard(row: Int, col: Int): Boolean {
        return if (gameBoard[row - 1][col - 1] == 0) {
            gameBoard[row - 1][col - 1] = player

            true
        } else {
            false
        }
    }

    fun computer() {
        Log.d("Cell", findEmptyCells().toString())
        if (findEmptyCells() != listOf<EmptyCell>()) {
            val emptyCell = findEmptyCells().random()
            Log.d("Cell", emptyCell.toString())
            gameBoard[emptyCell.rowIndex][emptyCell.colIndex] = 2
        } else boardFilled = 9
    }

    private fun findEmptyCells(): List<EmptyCell> {
        val emptyCells = mutableListOf<EmptyCell>()
        gameBoard.forEachIndexed { arrayIndex, arrayElement ->
            arrayElement.forEachIndexed { index, element ->
                if (element == 0) {
                    emptyCells.add(EmptyCell(arrayIndex, index))
                }
            }
        }
        return emptyCells
    }

    fun winnerCheck(): Boolean {
        var isWinner = false

        repeat(ROW_COUNT) { r ->
            if (gameBoard[r][0] == gameBoard[r][1]
                && gameBoard[r][0] == gameBoard[r][2]
                && gameBoard[r][0] != 0
            ) {
                winType = arrayOf(r, 0, 1)
                isWinner = true
            }
        }

        repeat(COL_COUNT) { c ->
            if (gameBoard[0][c] == gameBoard[1][c]
                && gameBoard[0][c] == gameBoard[2][c]
                && gameBoard[0][c] != 0
            ) {
                winType = arrayOf(0, c, 2)
                isWinner = true
            }
        }

        if (gameBoard[0][0] == gameBoard[1][1]
            && gameBoard[0][0] == gameBoard[2][2]
            && gameBoard[0][0] != 0
        ) {
            winType = arrayOf(0, 2, 3)
            isWinner = true
        }

        if (gameBoard[2][0] == gameBoard[1][1]
            && gameBoard[2][0] == gameBoard[0][2]
            && gameBoard[2][0] != 0
        ) {
            winType = arrayOf(2, 2, 4)
            isWinner = true
        }

        repeat(ROW_COUNT) { row ->
            repeat(COL_COUNT) { col ->
                if (gameBoard[row][col] != 0) {
                    boardFilled += 1
                }
            }
        }

        return if (isWinner) {
            true
        } else boardFilled == 9
    }

    fun resetGame() {
        repeat(ROW_COUNT) { row ->
            repeat(COL_COUNT) { col ->
                gameBoard[row][col] = 0
            }
        }
    }

    companion object {
        private const val ROW_COUNT = 3
        private const val COL_COUNT = 3

    }
}