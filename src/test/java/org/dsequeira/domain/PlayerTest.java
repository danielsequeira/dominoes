package org.dsequeira.domain;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PlayerTest {

    @Mock
    private Board boardMock;
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void createPlayerTest() {
        Player player = new Player("John");
        assertEquals("John", player.getName());
        assertNotNull(player.getTiles());
        assertEquals(0, player.getTiles().size());
    }

    @Test
    public void addTileToPlayerTest() {
        Player player = new Player("John");
        Tile tile = new Tile(0,1);
        player.addTile(tile);

        assertEquals(1, player.getTiles().size());
        assertEquals(0, player.getTiles().get(0).getFirstSquare());
        assertEquals(1, player.getTiles().get(0).getSecondSquare());
    }

    @Test
    public void getValidTileFromPlayerTest() {
        Player player = new Player("John");
        Tile tile1 = new Tile(0,1);
        Tile tile2 = new Tile(0,2);
        player.addTile(tile1);
        player.addTile(tile2);

        when(boardMock.getLeadingSquare()).thenReturn(2);
        when(boardMock.getTrailingSquare()).thenReturn(3);

        Tile connectingTile = player.getValidTile(boardMock);
        assertNotNull(connectingTile);
        assertEquals(0, connectingTile.getFirstSquare());
        assertEquals(2, connectingTile.getSecondSquare());
        assertEquals(1, player.getTiles().size());
    }

    @Test
    public void playerHasNoValidTileTest() {
        Player player = new Player("John");
        Tile tile1 = new Tile(0,1);
        Tile tile2 = new Tile(0,2);
        player.addTile(tile1);
        player.addTile(tile2);

        when(boardMock.getLeadingSquare()).thenReturn(4);
        when(boardMock.getTrailingSquare()).thenReturn(3);

        Tile connectingTile = player.getValidTile(boardMock);
        assertNull(connectingTile);
        assertEquals(2, player.getTiles().size());
    }
}
