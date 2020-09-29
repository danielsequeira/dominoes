package org.dsequeira.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void createBoardTest() {
        Board board = new Board();

        assertEquals(-1, board.getLeadingSquare());
        assertEquals(-1, board.getTrailingSquare());
        assertNotNull(board.getTiles());
        assertTrue(board.getTiles().isEmpty());
    }

    @Test
    public void placeTileOnEmptyBoardTest() {
        Board board = new Board();
        Tile tile = new Tile(0,1);

        board.placeTile(tile);
        assertEquals(0, board.getLeadingSquare());
        assertEquals(1, board.getTrailingSquare());
        assertEquals(1, board.getTiles().size());
    }

    @Test
    public void placeTileOnNonEmptyBoardTest() {
        Board board = new Board();
        Tile initialTile = new Tile(0,1);

        board.placeTile(initialTile);
        assertEquals(0, board.getLeadingSquare());
        assertEquals(1, board.getTrailingSquare());
        assertEquals(1, board.getTiles().size());

        Tile secondTile = new Tile(1,2);
        board.placeTile(secondTile);
        assertEquals(0, board.getLeadingSquare());
        assertEquals(2, board.getTrailingSquare());
        assertEquals(2, board.getTiles().size());
    }
}
