package org.example.model;

import java.util.Objects;

public class Position {
    private final int x;
    private final int y;

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
