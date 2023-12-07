package org.example.model.entities;

public class Enemy extends Entity{
    private int health; //Talvez mude para float

    public boolean detectedPlayer = false;

    private int detectionRadius = 5;

    public Enemy(int x, int y, int health) {
        super(x, y, true, true, false);
        this.health = health;
    }

    public void setDetectionRadius(int detectionRadius) {
        this.detectionRadius = detectionRadius;
    }

    public int getDetectionRadius() {
        return this.detectionRadius;
    }

    public void decreaseHealth(int damageTaken) {
        this.health = this.health - damageTaken;
    }

    public int getHealth() {
        return this.health;
    }
}
