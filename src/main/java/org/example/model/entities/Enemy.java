package org.example.model.entities;

import org.example.model.Position;

public class Enemy extends Entity{
    private int health; //Talvez mude para float

    public boolean detectedPlayer;

    private int detectionRadius = 5;

    public Enemy(int x, int y, int health) {
        super(x, y, true, true, false);
        this.health = health;
        this.detectedPlayer = false;
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

    public boolean projectileHits(Position currentPos, Position finalPos) {
        int xDif = finalPos.getX() - currentPos.getX();
        int yDif = finalPos.getY() - currentPos.getY();

        if ((currentPos.getY() == this.getPosition().getY() - 1 && currentPos.getX() == this.getPosition().getX()) && (yDif > 0)) { //Coming from above
            System.out.println("Coming from above");
            return true;
        }
        else if ((currentPos.getY() == this.getPosition().getY() + 1 && currentPos.getX() == this.getPosition().getX()) && (yDif < 0)) { //Coming from below
            System.out.println("Coming from below");
            return true;
        }
        else if ((currentPos.getX() == this.getPosition().getX() - 1 && currentPos.getY() == this.getPosition().getY()) && (xDif > 0)) { //Coming from the left
            System.out.println("Coming from the left");
            return true;
        }
        else if ((currentPos.getX() == this.getPosition().getX() + 1 && currentPos.getY() == this.getPosition().getY()) && (xDif < 0)) { //Coming from the right
            System.out.println("Coming from the right");
            return true;
        }
        else {
            return false;
        }
    }
}
