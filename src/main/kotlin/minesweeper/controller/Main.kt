package minesweeper.controller

import minesweeper.domain.AskType
import minesweeper.domain.Board
import minesweeper.view.InputView
import minesweeper.view.ResultView

fun main() {
    val board = Board(
        InputView.askBoardInfo(AskType.HEIGHT),
        InputView.askBoardInfo(AskType.WIDTH),
        InputView.askBoardInfo(AskType.MINE_COUNT)
    )

    ResultView.startGame()
    while (true) {
        val pos = InputView.askOpenPosition()
        if (board.isAlreadyOpened(pos)) {
            ResultView.showAlreadyOpened()
            continue
        }

        if (board.openCell(pos)) {
            ResultView.showBoard(board)
            if (board.isWin()) {
                ResultView.showWinGame()
                break
            }
        } else {
            ResultView.showLoseGame()
            break
        }
    }
}
