package org.dsequeira.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private List<Tile> tiles;

    public Player(String name) {
        this.name = name;
        this.tiles = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    public void addTile(Tile tile) {
        this.tiles.add(tile);
    }

    // get a valid tile from player to place in the board
    public Tile getValidTile(Board board) {
        int leadingSquare = board.getLeadingSquare();
        int trailingSquare = board.getTrailingSquare();

        for (Tile tile : this.tiles) {
            if (tile.hasSquare(leadingSquare) || tile.hasSquare(trailingSquare)) {
                this.tiles.remove(tile);
                return tile;
            }
        }
        return null;
    }
}
