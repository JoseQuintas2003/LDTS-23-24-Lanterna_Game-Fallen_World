package org.example.model.entities;

public class Weapon extends Entity{

    private final int damage;

    private final int ammo;

    private final String name;

    public Weapon(int x, int y, int damage, int ammo, String name) {
        super(x, y, false, false, true);

        this.damage = damage;
        this.ammo = ammo;

        this.name = name;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getAmmo() {
        return this.ammo;
    }

    public String getName() {
        return this.name;
    }
}
