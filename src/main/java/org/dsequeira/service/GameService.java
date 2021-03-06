package org.dsequeira.service;

import org.dsequeira.domain.Board;
import org.dsequeira.domain.Player;
import org.dsequeira.domain.Stock;
import org.dsequeira.domain.Tile;

import java.util.Arrays;
import java.util.Random;

public class GameService {

    private Player player1;
    private Player player2;
    private Board board;
    private Stock stock;
    private Player activePlayer;

    public GameService(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = new Board();
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Board getBoard() {
        return board;
    }

    public Stock getStock() {
        return stock;
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public void switchActivePlayer() {
        if (activePlayer.equals(player1)) {
            this.activePlayer = player2;
            return;
        }
        this.activePlayer = player1;
    }

    public Player getWinner() {
        return player1.getTiles().size() > player2.getTiles().size() ? player2 : player1;
    }

    protected void initGame() {
        // initialize stock with 28 tiles
        stock = new Stock();

        // each player draws seven tiles from the stock
        for (int i = 0; i<7; i++) {
            player1.addTile(stock.pullTile());
            player2.addTile(stock.pullTile());
        }

        // pull a random tile from the stock to start the line of play
        Tile firstTile = stock.pullTile();
        board.placeTile(firstTile);
        System.out.println("Game starting with first tile: " + firstTile.toString());

        // randomly select Player to start the game
        activePlayer = Arrays.asList(player1, player2).get(new Random().nextInt(2));
    }

    public void runGame() {
        initGame();
        while (!player1.getTiles().isEmpty() && !player2.getTiles().isEmpty()) {
            Tile tile = activePlayer.getValidTile(board);

            if (tile != null) {
                Tile boardTile = board.placeTile(tile);
                System.out.println(activePlayer.getName() + " plays " + tile.toString() + " to connect to tile " + boardTile.toString() + " on the board");
                System.out.println("Board is now: " + board.toString());

                if (activePlayer.getTiles().isEmpty()) {
                    System.out.println("Player " + activePlayer.getName() + " has won!");
                }

                switchActivePlayer();
            } else {
                Tile stockTile = stock.pullTile();

                if (stockTile == null) {
                    System.out.println(activePlayer.getName() + " can't play, no more tiles to draw");
                    System.out.println("Player " + getWinner().getName() + " has won!");
                    break;
                }
                activePlayer.addTile(stockTile);
                System.out.println(activePlayer.getName() + " can't play, drawing tile " + stockTile.toString());
            }
        }
    }
}
