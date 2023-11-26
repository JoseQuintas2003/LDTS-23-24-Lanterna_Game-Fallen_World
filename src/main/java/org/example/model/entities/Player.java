package org.example.model.entities;

public class Player extends Entity {
    private int health;
    private int score;

    public Player(int x, int y, int health, int score) {
        super(x, y, true, true, false);
        this.health = health;
        this.score = score;
    }

    public void decreaseHealth(int damageTaken) {
        this.health = this.health - damageTaken;
    }

    public void increaseScore(int score) {
        this.score = this.score + score;
    }

    public int getHealth() {
        return this.health;
    }

    public int getScore() {
        return this.score;
    }
}
