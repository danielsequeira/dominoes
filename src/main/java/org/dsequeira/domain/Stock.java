package org.dsequeira.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Stock {

    private List<Tile> tiles;

    public Stock() {
        this.tiles = new ArrayList<>();
        // initialize stock with 28 domino tiles
        for (int i = 0; i < 7; i++) {
            for (int j = i; j < 7; j++) {
                Tile tile = new Tile(i, j);
                this.tiles.add(tile);
            }
        }
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    public Tile pullTile() {
        if (tiles.isEmpty()) {
            return null;
        }

        // pull random tile from stock
        int randomIndex = new Random().nextInt(tiles.size());
        Tile tile = tiles.get(randomIndex);
        tiles.remove(randomIndex);

        return tile;
    }
}
