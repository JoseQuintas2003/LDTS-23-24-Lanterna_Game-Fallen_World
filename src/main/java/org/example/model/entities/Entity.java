package org.example.model.entities;

import org.example.gui.GUI;
import org.example.model.Position;

import java.io.IOException;

public class Entity {
    private Position position;
    private boolean collidable, destroyable, stationary;

    public Entity(int x, int y, boolean collidable, boolean destroyable, boolean stationary) {
        this.position = new Position(x, y);
        this.collidable = collidable;
        this.destroyable = destroyable;
        this.stationary = stationary;
    }

    public boolean isCollidable() { return this.collidable;}
    public boolean isDestroyable() {
        return this.destroyable;
    }
    public boolean isStationary() { return this.stationary; }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
    public void moveToPosition(Position position, int speed) {

        switch (this.position.getQuadrant(position)) {
            case TOP_RIGHT:
                while (!this.position.equals(position)) {
                    if (this.position.getX() < position.getX()) {
                        setPosition(new Position(this.position.getX() + speed, this.position.getY()));
                    }

                    if (this.position.getY() < position.getY()) {
                        setPosition(new Position(this.position.getX(), this.position.getY() + speed));
                    }
                }
                break;
            case TOP_LEFT:
                while (!this.position.equals(position)) {
                    if (this.position.getX() > position.getX()) {
                        setPosition(new Position(this.position.getX() - speed, this.position.getY()));
                    }

                    if (this.position.getY() < position.getY()) {
                        setPosition(new Position(this.position.getX(), this.position.getY() + speed));
                    }
                }
                break;
            case BOTTOM_RIGHT:
                while (!this.position.equals(position)) {
                    if (this.position.getX() < position.getX()) {
                        setPosition(new Position(this.position.getX() + speed, this.position.getY()));
                    }

                    if (this.position.getY() > position.getY()) {
                       setPosition(new Position(this.position.getX(), this.position.getY() - speed));
                    }
                }
                break;

            case BOTTOM_LEFT:
                while (!this.position.equals(position)) {
                    if (this.position.getX() > position.getX()) {
                        setPosition(new Position(this.position.getX() - speed, this.position.getY()));
                    }

                    if (this.position.getY() > position.getY()) {
                        setPosition(new Position(this.position.getX(), this.position.getY() - speed));
                    }
                }
                break;
        }
    }
}
