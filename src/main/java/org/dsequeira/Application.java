package org.dsequeira;

import org.dsequeira.domain.*;
import org.dsequeira.service.GameService;

public class Application {
    public static void main( String[] args ) {
        Player player1 = new Player("Daniel");
        Player player2 = new Player("Sarah");
        GameService gameService = new GameService(player1, player2);

        gameService.runGame();
    }
}
