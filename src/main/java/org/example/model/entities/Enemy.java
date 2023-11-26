package org.example.model.entities;

public class Enemy extends Entity{
    private int health; //Talvez mude para float

    public Enemy(int x, int y, int health) {
        super(x, y, true, true, false);
        this.health = health;
    }
    public void decreaseHealth(int damageTaken) {
        this.health = this.health - damageTaken;
    }

    public int getHealth() {
        return this.health;
    }
}
