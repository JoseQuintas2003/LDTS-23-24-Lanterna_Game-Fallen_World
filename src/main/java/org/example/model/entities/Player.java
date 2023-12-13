package org.example.model.entities;

import org.example.model.Position;

public class Player extends Entity {
    private int health;

    private int maxHealth;
    private int score;

    public final int SPEED = 1;

    public Player(int x, int y, int health, int score) {
        //The three boolean values are: isCollidable, isDestroyable, isStationary
        super(x, y, true, true, false);
        this.health = health;
        this.score = score;
        this.maxHealth = health;
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

    public void calculatePosition(Position position) {
        super.calculatePosition(position, SPEED);
    }
}
