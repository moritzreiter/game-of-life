package com.anothernode.gameoflife;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class BoardTests {

    @Test
    public void cellsCanBeAddedToBoard() {

        Cell cell1 = new Cell(-15, -33);
        Cell cell2 = new Cell(5, 18);
        Board board = new Board();

        board.add(cell1);
        board.add(cell2);

        assertThat(board.size()).isEqualTo(2);
    }

    @Test
    public void neighborsAreCountedCorrectly() {

        Cell cell1 = new Cell(0, 0);
        Cell cell2 = new Cell(0, 1);

    }
}
