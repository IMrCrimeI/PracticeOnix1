package com.onix.internship.ui.game

import androidx.lifecycle.MutableLiveData
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent
import com.onix.internship.ui.game.entities.CellState
import com.onix.internship.ui.game.entities.EmptyCell
import com.onix.internship.ui.game.entities.WinInfo
import com.onix.internship.ui.game.entities.WinType

class GameViewModel : BaseViewModel() {
    var text = MutableLiveData("")
    var sell = MutableLiveData(true)

    val initEvent = SingleLiveEvent<Boolean>()

    val model = GameModel()
    val gameBoard = model.boardArrayIndexes
    var winInfo = WinInfo()
    private var boardFilled = 0

    fun playAgainOrGoHome(player: Boolean) {
        initEvent.value = player
    }

    fun updateGameBoard(row: Int, col: Int): Boolean {
        return if (isCellEmpty(row, col)) {
            gameBoard[row][col] = CellState.CROSS
            true
        } else {
            false
        }
    }

    private fun isCellEmpty(row: Int, col: Int): Boolean {
        return gameBoard[row][col] == CellState.EMPTY
    }

    fun computer() {
        if (findEmptyCells() != listOf<EmptyCell>()) {
            val emptyCell = findEmptyCells().random()
            gameBoard[emptyCell.rowIndex][emptyCell.colIndex] = CellState.ZERO
        } else boardFilled = 9
    }

    private fun findEmptyCells(): List<EmptyCell> {
        val emptyCells = mutableListOf<EmptyCell>()
        gameBoard.forEachIndexed { arrayIndex, arrayElement ->
            arrayElement.forEachIndexed { index, element ->
                if (element == CellState.EMPTY) {
                    emptyCells.add(EmptyCell(arrayIndex, index))
                }
            }
        }
        return emptyCells
    }

    fun winnerCheck(): Boolean {
        var isWinner = false
        boardFilled = 0
        repeat(ROW_COUNT) { r ->
            if (gameBoard[r][0] == gameBoard[r][1]
                && gameBoard[r][0] == gameBoard[r][2]
                && gameBoard[r][0] != CellState.EMPTY
            ) {
                winInfo.apply {
                    row = r
                    col = 0
                    type = WinType.HORIZONTAL
                }
                isWinner = true
            }
        }

        repeat(COL_COUNT) { c ->
            if (gameBoard[0][c] == gameBoard[1][c]
                && gameBoard[0][c] == gameBoard[2][c]
                && gameBoard[0][c] != CellState.EMPTY
            ) {
                winInfo.apply {
                    row = 0
                    col = c
                    type = WinType.VERTICAL
                }
                isWinner = true
            }
        }

        if (gameBoard[0][0] == gameBoard[1][1]
            && gameBoard[0][0] == gameBoard[2][2]
            && gameBoard[0][0] != CellState.EMPTY
        ) {
            winInfo.apply {
                row = 0
                col = 2
                type = WinType.DIAGONAL_LTR
            }
            isWinner = true
        }
        if (gameBoard[2][0] == gameBoard[1][1]
            && gameBoard[2][0] == gameBoard[0][2]
            && gameBoard[2][0] != CellState.EMPTY
        ) {
            winInfo.apply {
                row = 2
                col = 2
                type = WinType.DIAGONAL_RTL
            }
            isWinner = true
        }

        repeat(ROW_COUNT) { row ->
            repeat(COL_COUNT) { col ->
                if (gameBoard[row][col] != CellState.EMPTY) {
                    boardFilled += 1
                }
            }
        }
        if (isWinner) {
            text.value = "Есть победитель"
            sell.value = false
            return true
        } else if (boardFilled == 9) {
            text.value = "Ничья, попробуйте еще раз"
            sell.value = false
            return true
        }
        return false
    }

    companion object {
        private const val ROW_COUNT = 3
        private const val COL_COUNT = 3

    }
}