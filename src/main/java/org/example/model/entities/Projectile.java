package org.example.model.entities;

public class Projectile extends Entity{
    private int damage;

    public Projectile(int x, int y, int damage) {
        super(x, y, true, false, false);
        this.damage = damage;
    }

    public int getDamage() {
        return this.damage;
    }
}
