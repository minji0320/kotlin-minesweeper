package minesweeper.domain

sealed class Cell(var isOpen: Boolean) {
    fun isMine(): Boolean {
        return when (this) {
            is Mine -> true
            is Block -> false
        }
    }

    fun open() {
        isOpen = true
    }

    companion object {
        const val MARK = "C"
    }
}

class Mine : Cell(false) {
    override fun toString(): String {
        return MARK
    }
}

data class Block(val aroundMineCount: Int = 0) : Cell(false) {
    override fun toString(): String {
        return if (isOpen) {
            aroundMineCount.toString()
        } else {
            MARK
        }
    }
}
