package minesweeper.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CellTest {
    @Test
    fun `Cell이 Mine인지 Block인지 판별`() {
        val board = listOf(Block(), Block(), Mine())
        assertThat(board[0].isMine()).isFalse
        assertThat(board[1].isMine()).isFalse
        assertThat(board[2].isMine()).isTrue
    }

    @Test
    fun `Cell의 open 상태 체크`() {
        // 보드 상태 : 폭탄, 블록, 블록
        val board = Board(1, 3, 1)
        board.setMinesAndBlocks(listOf(0))

        board.board[1].open()
        assertThat(board.board[0].isOpen).isFalse
        assertThat(board.board[1].isOpen).isTrue
        assertThat(board.board[2].isOpen).isFalse
    }

    @Test
    fun `Cell의 open 상태에 따른 출력 결과 테스트`() {
        // 보드 상태 : 폭탄, 블록, 블록
        val board = Board(1, 2, 1)
        when {
            board.board[0].isMine() -> {
                board.openCell(Position(0, 1))
                assertThat(board.board[0].toString()).isEqualTo("C")
                assertThat(board.board[1].toString()).isEqualTo("1")
            }
            else -> {
                board.openCell(Position(0, 0))
                assertThat(board.board[0].toString()).isEqualTo("1")
                assertThat(board.board[1].toString()).isEqualTo("C")
            }
        }
    }
}
