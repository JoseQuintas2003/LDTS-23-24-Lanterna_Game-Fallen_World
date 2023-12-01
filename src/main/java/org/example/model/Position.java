package org.example.model;

import java.util.Objects;

public class Position {
    private final int x;
    private final int y;

    // Used later to compare positions (mostly in the Enemy, Player and Projectile classes)
    public enum Quadrant {
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT

    }

    public Position(int x, int y) {
        this.x = x; // 1
        this.y = y; // 2
    }

    public Position getLeft() {
        return new Position(x - 1, y); // 3
    }

    public Position getRight() {
        return new Position(x + 1, y); // 4
    }

    public Position getUp() {
        return new Position(x, y - 1); // 5
    }

    public Position getDown() {
        return new Position(x, y + 1); // 6
    }

    public int getX() {
        return x; // 12
    }

    public int getY() {
        return y; // 13
    }

    // Returns the quadrant of a given position relative to the current position.
    //TODO: Refactor
    public Quadrant getQuadrant(Position position) {
        //True if the given position is to the right of the entity. False if to the left.
        boolean x_dif_positive = (position.getX() - this.x) > 0;

        //True if the given position is above the entity. False if below.
        boolean y_dif_positive = (position.getY() - this.y) > 0;

        if (x_dif_positive) { //X is positive

            if (y_dif_positive) { //Y is positive
                return Quadrant.TOP_RIGHT;
            } else if (!(y_dif_positive)) { //Y is negative
                return Quadrant.BOTTOM_RIGHT;
            }

        } else if (!(x_dif_positive)) { //X is negative

            if (y_dif_positive) { //Y is positive
                return Quadrant.TOP_LEFT;
            } else if (!(y_dif_positive)) { //Y is negative
                return Quadrant.BOTTOM_LEFT;
            }

        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // 14
        if (o == null || getClass() != o.getClass()) return false; // 15
        Position position = (Position) o; // 16
        return x == position.x && y == position.y; // 17
    }

    /*
    @Override
    public int hashCode() {
        return Objects.hash(x, y); // 18
    }
    */
}
