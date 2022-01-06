package minesweeper.domain

sealed class Cell {
    fun isMine(): Boolean {
        return when (this) {
            is Mine -> true
            is Block -> false
        }
    }
}

class Mine : Cell() {
    override fun toString(): String {
        return MARK
    }

    companion object {
        private const val MARK = "*"
    }
}

data class Block(private val aroundMineCount: Int = 0) : Cell() {
    override fun toString(): String {
        return aroundMineCount.toString()
    }
}
