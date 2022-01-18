package minesweeper.view

import minesweeper.domain.Board

object ResultView {
    private const val START_GAME = "\n지뢰찾기 게임 시작"
    private const val ALREADY_OPENED = "이미 열려있는 Cell 입니다.\n"
    private const val LOSE_GAME = "Lose Game."
    private const val WIN_GAME = "Win Game."

    fun startGame() {
        println(START_GAME)
    }

    fun showBoard(board: Board) {
        for (i in 0 until board.height) {
            val now = i * board.width
            val eachRow = board.board.subList(now, now + board.width)
            println(eachRow.joinToString(" "))
        }
        println()
    }

    fun showAlreadyOpened() {
        println(ALREADY_OPENED)
    }

    fun showLoseGame() {
        println(LOSE_GAME)
    }

    fun showWinGame() {
        println(WIN_GAME)
    }
}
