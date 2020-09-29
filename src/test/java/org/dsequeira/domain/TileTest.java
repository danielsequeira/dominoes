package org.dsequeira.domain;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TileTest {

    @Test
    public void createTileTest() {
        Tile tile = new Tile(0,1);
        assertEquals(0, tile.getFirstSquare());
        assertEquals(1, tile.getSecondSquare());
    }

    @Test
    public void flipTileTest() {
        Tile tile = new Tile(0,1);
        tile.flip();
        assertEquals(1, tile.getFirstSquare());
        assertEquals(0, tile.getSecondSquare());
    }

    @Test
    public void tileHasSquareTest() {
        Tile tile = new Tile(0,1);
        assertTrue(tile.hasSquare(0));
        assertTrue(tile.hasSquare(1));
    }

    @Test
    public void convertTileToStringTest() {
        Tile tile = new Tile(0,1);
        assertEquals("<0:1>", tile.toString());
    }
}
