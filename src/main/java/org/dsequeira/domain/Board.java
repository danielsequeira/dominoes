package org.dsequeira.domain;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Tile> tiles;
    private int leadingSquare;
    private int trailingSquare;

    public Board() {
        this.tiles = new ArrayList<>(19);
        this.leadingSquare = -1;
        this.trailingSquare = -1;
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    public int getLeadingSquare() {
        return leadingSquare;
    }

    public void setLeadingSquare(int leadingSquare) {
        this.leadingSquare = leadingSquare;
    }

    public int getTrailingSquare() {
        return trailingSquare;
    }

    public void setTrailingSquare(int trailingSquare) {
        this.trailingSquare = trailingSquare;
    }

    public Tile placeTile(Tile tile) {
        Tile connectingTile = null;
        if (tiles.isEmpty()) {
            tiles.add(tile);
            setLeadingSquare(tile.getFirstSquare());
            setTrailingSquare(tile.getSecondSquare());
            connectingTile = tile;
        } else {
            if (tile.hasSquare(trailingSquare)) {
                connectingTile = tiles.get(tiles.size()-1);

                if (trailingSquare == tile.getSecondSquare()) {
                    tile.flip();
                }

                tiles.add(tile);
                setTrailingSquare(tile.getSecondSquare());
            } else if (tile.hasSquare(leadingSquare)) {
                connectingTile = tiles.get(0);

                if (leadingSquare == tile.getFirstSquare()) {
                    tile.flip();
                }

                tiles.add(0, tile);
                setLeadingSquare(tile.getFirstSquare());
            }
        }
        return connectingTile;
    }

    public void reset() {
        this.tiles.clear();
        this.leadingSquare = -1;
        this.trailingSquare = -1;
    }

    @Override
    public String toString() {
        StringBuilder board = new StringBuilder();
        for (Tile tile : tiles) {
            board.append(tile.toString());
        }
        return board.toString();
    }
}
