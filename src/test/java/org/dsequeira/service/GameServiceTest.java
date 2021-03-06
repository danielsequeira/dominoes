package org.dsequeira.service;

import org.dsequeira.domain.Player;
import org.dsequeira.domain.Tile;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class GameServiceTest {

    @Mock
    Player player1Mock;
    @Mock
    Player player2Mock;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setUp() {
        when(player1Mock.getName()).thenReturn("John");
        when(player2Mock.getName()).thenReturn("Steve");
    }

    @Test
    public void createGameServiceTest() {
        GameService gameService = new GameService(player1Mock, player2Mock);

        assertEquals("John", gameService.getPlayer1().getName());
        assertEquals("Steve", gameService.getPlayer2().getName());
        assertNotNull(gameService.getBoard());
        assertEquals(0, gameService.getBoard().getTiles().size());
    }

    @Test
    public void initGameTest() {
        GameService gameService = new GameService(player1Mock, player2Mock);

        gameService.initGame();
        assertEquals(13, gameService.getStock().getTiles().size());

        verify(player1Mock, times(7)).addTile(any(Tile.class));
        verify(player2Mock, times(7)).addTile(any(Tile.class));

        assertEquals(1, gameService.getBoard().getTiles().size());
        assertNotNull(gameService.getActivePlayer());
    }

    @Test
    public void runGameTest() {
        Player player1 = new Player("John");
        Player player2 = new Player("Steve");

        GameService gameService = new GameService(player1, player2);
        gameService.runGame();

        assertNotNull(gameService.getWinner());
        assertTrue(gameService.getStock().getTiles().isEmpty() ||
                gameService.getPlayer1().getTiles().isEmpty() ||
                gameService.getPlayer2().getTiles().isEmpty());
    }
}
