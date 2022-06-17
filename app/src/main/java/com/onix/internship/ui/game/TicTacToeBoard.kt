package com.onix.internship.ui.game

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.onix.internship.R
import com.onix.internship.ui.game.entities.CellState
import com.onix.internship.ui.game.entities.WinType
import kotlin.math.ceil

class TicTacToeBoard(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    private val size = 0.2f
    private var winningLine = false
    private val paint = Paint()
    private var cellSize = width / 3
    private var gameViewModel: GameViewModel? = null


    private val typedArray: TypedArray = context.theme.obtainStyledAttributes(
        attrs, R.styleable.TicTacToeBoard, 0, 0
    )
    private val boardColor = typedArray.getColor(R.styleable.TicTacToeBoard_boardColor, 0)
    private val xColor = typedArray.getColor(R.styleable.TicTacToeBoard_XColor, 0)
    private val oColor = typedArray.getColor(R.styleable.TicTacToeBoard_OColor, 0)
    private val winningLineColor =
        typedArray.getColor(R.styleable.TicTacToeBoard_WinningLineColor, 0)

    fun setPlayer(player: Boolean) {
        if (player) {
            gameViewModel?.computer()
        }
    }

    override fun onMeasure(width: Int, height: Int) {
        super.onMeasure(width, height)

        val dimension = measuredWidth.coerceAtMost(measuredHeight)
        cellSize = dimension / 3

        setMeasuredDimension(dimension, dimension)
    }

    override fun onDraw(canvas: Canvas) {
        paint.style = Paint.Style.STROKE
        paint.isAntiAlias = true

        drawGameBoard(canvas)
        drawMarkers(canvas)

        if (winningLine) {
            paint.color = winningLineColor
            drawWinningLine(canvas)
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x = event.x
        val y = event.y

        val action = event.action

        if (action == MotionEvent.ACTION_DOWN) {
            val row = ceil(y / cellSize).toInt()
            val rowIndex = row.dec()
            val col = ceil(x / cellSize).toInt()
            val colIndex = col.dec()

            if (!winningLine) {
                if (gameViewModel?.updateGameBoard(rowIndex, colIndex) == true) {
                    invalidate()
                    if (gameViewModel?.winnerCheck() == true) {
                        winningLine = true
                        invalidate()
                    } else {
                        gameViewModel?.computer()
                        if (gameViewModel?.winnerCheck() == true) {
                            winningLine = true
                            invalidate()
                        }
                    }
                }
            }
            invalidate()
            return true
        }
        return false
    }

    private fun drawGameBoard(canvas: Canvas) {
        paint.color = boardColor
        paint.strokeWidth = 16f

        repeat(VERTICAL_DELIMITERS_COUNT) { c ->
            canvas.drawLine(
                cellSize * c.inc().toFloat(),
                0f,
                cellSize * c.inc().toFloat(),
                canvas.width.toFloat(),
                paint
            )
        }

        repeat(HORIZONTAL_DELIMITERS_COUNT) { r ->
            canvas.drawLine(
                0f,
                cellSize * r.inc().toFloat(),
                canvas.width.toFloat(),
                cellSize * r.inc().toFloat(),
                paint
            )
        }
    }

    private fun drawMarkers(canvas: Canvas) {
        repeat(ROW) { r ->
            repeat(COL) { c ->
                if (gameViewModel?.gameBoard?.get(r)?.get(c) != CellState.EMPTY) {
                    if (gameViewModel?.gameBoard?.get(r)?.get(c) == CellState.CROSS) {
                        drawX(canvas, r, c)
                    } else {
                        drawO(canvas, r, c)
                    }
                }
            }
        }
    }

    private fun drawX(canvas: Canvas, row: Int, col: Int) {
        paint.color = xColor


        canvas.drawLine(
            col.inc() * cellSize - cellSize * size,
            row * cellSize + cellSize * size,
            col * cellSize + cellSize * size,
            row.inc() * cellSize - cellSize * size,
            paint
        )
        canvas.drawLine(
            col * cellSize + cellSize * size,
            row * cellSize + cellSize * size,
            col.inc() * cellSize - cellSize * size,
            row.inc() * cellSize - cellSize * size,
            paint
        )
    }

    private fun drawO(canvas: Canvas, row: Int, col: Int) {
        paint.color = oColor

        canvas.drawOval(
            col * cellSize + cellSize * size,
            row * cellSize + cellSize * size,
            (col * cellSize + cellSize) - cellSize * size,
            (row * cellSize + cellSize) - cellSize * size,
            paint
        )
    }

    private fun drawHorizontalLine(canvas: Canvas, row: Int, col: Int) {
        canvas.drawLine(
            col.toFloat(), row * cellSize + cellSize / 2f,
            cellSize * 3f, row * cellSize + cellSize / 2f,
            paint
        )
    }

    private fun drawVerticalLine(canvas: Canvas, row: Int, col: Int) {
        canvas.drawLine(
            col * cellSize + cellSize / 2f,
            row.toFloat(),
            col * cellSize + cellSize / 2f,
            cellSize * 3f,
            paint
        )
    }

    private fun drawDiagonalLinePos(canvas: Canvas) {
        canvas.drawLine(
            0f, cellSize * 3f,
            cellSize * 3f, 0f, paint
        )
    }

    private fun drawDiagonalLineNeg(canvas: Canvas) {
        canvas.drawLine(
            0f, 0f,
            cellSize * 3f, cellSize * 3f, paint
        )
    }

    private fun drawWinningLine(canvas: Canvas) {
        val row = gameViewModel?.winInfo?.row ?: 0
        val col = gameViewModel?.winInfo?.col ?: 0

        when (gameViewModel?.winInfo?.type) {
            WinType.HORIZONTAL -> drawHorizontalLine(canvas, row, col)
            WinType.VERTICAL-> drawVerticalLine(canvas, row, col)
            WinType.DIAGONAL_LTR -> drawDiagonalLineNeg(canvas)
            WinType.DIAGONAL_RTL -> drawDiagonalLinePos(canvas)
            else -> {}
        }
    }

    fun setGame(game: GameViewModel){
        gameViewModel = game
    }
    companion object {
        const val HORIZONTAL_DELIMITERS_COUNT = 2
        const val VERTICAL_DELIMITERS_COUNT = 2
        const val ROW = 3
        const val COL = 3
    }
}