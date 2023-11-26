package org.example.model.entities;

import org.example.model.Position;

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
}
