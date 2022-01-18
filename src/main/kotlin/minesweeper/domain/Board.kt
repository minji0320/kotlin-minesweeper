package minesweeper.domain

data class Board(val height: Int, val width: Int, val mineCount: Int) {
    private val positionRange = 0 until height * width
    val board: List<Cell> = init()

    private fun init(): List<Cell> {
        require(height > 0 && width > 0 && mineCount >= 0) { INVALID_BOARD_INFO }
        return setMinesAndBlocks(getMinesPosition())
    }

    fun getMinesPosition(): List<Int> {
        return positionRange.shuffled().take(mineCount)
    }

    fun setMinesAndBlocks(minesPosition: List<Int>): List<Cell> {
        require(minesPosition.size == mineCount) { INVALID_MINE_COUNT }
        val board = mutableListOf<Cell>()
        for (position in positionRange) {
            if (minesPosition.contains(position)) {
                board.add(Mine())
            } else {
                board.add(Block(getAroundMineCount(position, minesPosition)))
            }
        }
        return board
    }

    fun getAroundMineCount(position: Int, minesPosition: List<Int>): Int {
        val aroundPosition = getAroundPosition(position)
        return aroundPosition.count { minesPosition.contains(it) }
    }

    private fun getAroundPosition(position: Int): List<Int> {
        val cellsPosition = mutableListOf<Int>()
        val x = position / width
        val y = position % width
        for (i in dx.indices) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            if (isWithinBoundary(nx, ny)) {
                cellsPosition.add(nx * width + ny)
            }
        }

        return cellsPosition
    }

    private fun isWithinBoundary(x: Int, y: Int): Boolean {
        return x in 0 until height && y in 0 until width
    }

    override fun toString(): String {
        return board.toString()
    }

    fun openCell(position: Position): Boolean {
        return when (val cell = getCell(position)) {
            is Mine -> false
            is Block -> {
                cell.open()
                openAround(cell, position)
                true
            }
        }
    }

    private fun getCell(position: Position): Cell {
        require(position.x in 0 until height && position.y in 0 until width) { INVALID_OPEN_POSITION }
        return board[(position.x) * height + (position.y)]
    }

    private fun openAround(cell: Block, position: Position) {
        if (cell.aroundMineCount > 0) {
            return
        }
        for (i in dx.indices) {
            val nx = position.x + dx[i]
            val ny = position.y + dy[i]
            val newPosition = Position(nx, ny)
            if (isWithinBoundary(nx, ny)) {
                val aroundCell = getCell(newPosition)
                if (aroundCell is Block && !aroundCell.isOpen) {
                    aroundCell.open()
                    openAround(aroundCell, newPosition)
                }
            }
        }
    }

    fun isAlreadyOpened(position: Position): Boolean {
        return getCell(position).isOpen
    }

    fun isWin(): Boolean {
        return board.count { !it.isOpen } == mineCount
    }

    companion object {
        private const val INVALID_BOARD_INFO = "높이, 너비는 모두 양의 정수이어야 하며, 지뢰의 개수는 0개 이상이어야 합니다."
        private const val INVALID_MINE_COUNT = "설치할 지뢰 개수가 맞지 않습니다."
        private const val INVALID_OPEN_POSITION = "open 좌표는 보드 크기 내의 값이어야 합니다."
        private val dx = listOf(-1, -1, -1, 0, 0, 1, 1, 1)
        private val dy = listOf(-1, 0, 1, -1, 1, -1, 0, 1)
    }
}
