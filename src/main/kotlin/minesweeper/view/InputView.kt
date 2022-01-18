package minesweeper.view

import minesweeper.domain.AskType

object InputView {
    private const val ASK_HEIGHT = "높이를 입력하세요"
    private const val ASK_WIDTH = "\n너비를 입력하세요"
    private const val ASK_MINE_COUNT = "\n지뢰는 몇 개인가요?"
    private const val ASK_OPEN_POSITION = "open: "
    private const val INVALID_BOARD_INFO_INPUT_MSG = "입력값은 숫자만 가능합니다."
    private const val INVALID_POSITION_INPUT_MSG = "좌표는 '숫자, 숫자' 형식으로 입력해 주세요."

    fun askBoardInfo(type: AskType): Int {
        when (type) {
            AskType.HEIGHT -> println(ASK_HEIGHT)
            AskType.WIDTH -> println(ASK_WIDTH)
            AskType.MINE_COUNT -> println(ASK_MINE_COUNT)
        }

        val input = readLine()?.toIntOrNull()
        require(input != null) { INVALID_BOARD_INFO_INPUT_MSG }

        return input
    }

    fun askOpenPosition(): List<Int> {
        print(ASK_OPEN_POSITION)

        val input = readLine()?.split(",")
        require(!input.isNullOrEmpty()) { INVALID_POSITION_INPUT_MSG }
        val result = mutableListOf<Int>()
        for (num in input) {
            require(num.toIntOrNull() != null) { INVALID_POSITION_INPUT_MSG }
            result.add(num.toInt())
        }
        require(result.size == 2) { INVALID_POSITION_INPUT_MSG }

        return result
    }
}
