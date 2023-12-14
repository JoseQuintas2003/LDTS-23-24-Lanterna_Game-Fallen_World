package org.example.model.entities;

import org.example.model.Position;

public class Player extends Entity {
    private int health;

    private int maxHealth;
    private int score;

    private int currentBulletCount;

    private int maxBulletCount;

    private Weapon currentWeapon;

    private int maxProjectiles;

    public int SPEED = 1;

    public Player(int x, int y, int health, int score) {
        //The three boolean values are: isCollidable, isDestroyable, isStationary
        super(x, y, true, true, false);
        this.health = health;
        this.score = score;
        this.maxHealth = health;
        this.currentBulletCount = 10;
        this.maxBulletCount = 10;
        this.maxProjectiles = 1;
        this.currentWeapon = new Weapon(0, 0, 2, 10, "Pistol");
    }

    public void decreaseHealth(int damageTaken) {
        this.health = this.health - damageTaken;
    }

    public void increaseHealth(int health) { this.health = this.health + health; }

    public void increaseScore(int score) {
        this.score = this.score + score;
    }

    public int getHealth() {
        return this.health;
    }

    public int getScore() {
        return this.score;
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getCurrentBulletCount() {
        return this.currentBulletCount;
    }

    public void setCurrentBulletCount(int currentBulletCount) {
        this.currentBulletCount = currentBulletCount;
    }

    public int getMaxBulletCount() {
        return this.maxBulletCount;
    }

    public void setMaxBulletCount(int maxBulletCount) {
        this.maxBulletCount = maxBulletCount;
    }

    public Weapon getCurrentWeapon() {
        return this.currentWeapon;
    }

    public void setCurrentWeapon(Weapon currentWeapon) {
        this.currentWeapon = currentWeapon;
    }

    public int getMaxProjectiles() {
        return this.maxProjectiles;
    }

    public void setMaxProjectiles(int maxProjectiles) {
        this.maxProjectiles = maxProjectiles;
    }

    public void calculatePosition(Position position) {
        super.calculatePosition(position, SPEED);
    }
}
