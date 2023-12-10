package org.example.model.entities;

import org.example.model.Position;

public class Projectile extends Entity{
    private int damage;

    private final Position finalPosition;

    public Projectile(int x, int y, int damage, Position finalPosition) {
        super(x, y, true, false, false);
        this.damage = damage;
        this.finalPosition = finalPosition;
    }

    public int getDamage() {
        return this.damage;
    }

    public Position getFinalPosition() {
        return this.finalPosition;
    }
}
