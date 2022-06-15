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
import kotlin.math.ceil

class TicTacToeBoard(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    private val size = 0.2f
    private var winningLine = false
    private val paint = Paint()
    private var cellSize = width / 3
    private val game = GameViewModel()


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
            game.computer()
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
            val col = ceil(x / cellSize).toInt()

            if (!winningLine) {

                if (game.updateGameBoard(row, col)) {
                    invalidate()
                    game.computer()
                    invalidate()
                    if (game.winnerCheck()) {
                        winningLine = true
                        invalidate()
                    }
//                    if (game.player % 2 == 0) {
//                        game.player = game.player - 1
//                    } else {
//                        game.player = game.player + 1
//                    }
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

        for (c in 1..2) {
            canvas.drawLine(
                cellSize * c.toFloat(),
                0f,
                cellSize * c.toFloat(),
                canvas.width.toFloat(),
                paint
            )
        }

        for (r in 1..2) {
            canvas.drawLine(
                0f,
                cellSize * r.toFloat(),
                canvas.width.toFloat(),
                cellSize * r.toFloat(),
                paint
            )
        }
    }

    private fun drawMarkers(canvas: Canvas) {
        for (r in 0..2) {
            for (c in 0..2) {
                if (game.gameBoard[r][c] != 0) {
                    if (game.gameBoard[r][c] == 1) {
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
            (col + 1) * cellSize - cellSize * size,
            row * cellSize + cellSize * size,
            col * cellSize + cellSize * size,
            (row + 1) * cellSize - cellSize * size,
            paint
        )
        canvas.drawLine(
            col * cellSize + cellSize * size,
            row * cellSize + cellSize * size,
            (col + 1) * cellSize - cellSize * size,
            (row + 1) * cellSize - cellSize * size,
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
        val row = game.winType[0]
        val col = game.winType[1]

        when (game.winType[2]) {
            1 -> drawHorizontalLine(canvas, row, col)
            2 -> drawVerticalLine(canvas, row, col)
            3 -> drawDiagonalLineNeg(canvas)
            4 -> drawDiagonalLinePos(canvas)
        }
    }

    fun resetGame() {
        game.resetGame()
    }
}