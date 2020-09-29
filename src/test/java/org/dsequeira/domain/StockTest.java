package org.dsequeira.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class StockTest {

    @Test
    public void createStockTest() {
        Stock stock = new Stock();
        assertEquals(28, stock.getTiles().size());
    }

    @Test
    public void pullTileFromStockTest() {
        Stock stock = new Stock();
        Tile tile = stock.pullTile();

        assertNotNull(tile);
        assertEquals(27, stock.getTiles().size());
    }
}
