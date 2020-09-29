package org.dsequeira.domain;

public class Tile {
    private int firstSquare;
    private int secondSquare;

    public Tile(final int firstSquare, final int secondSquare) {
        this.firstSquare = firstSquare;
        this.secondSquare = secondSquare;
    }

    public int getFirstSquare() {
        return firstSquare;
    }

    public int getSecondSquare() {
        return secondSquare;
    }

    // flip tile when needed to place it correctly in the board
    public void flip() {
        int temp = firstSquare;
        this.firstSquare = secondSquare;
        this.secondSquare = temp;
    }

    public boolean hasSquare(int number) {
        return this.firstSquare == number || this.secondSquare == number;
    }

    @Override
    public String toString() {
        return "<" + firstSquare + ":" + secondSquare + ">";
    }
}
