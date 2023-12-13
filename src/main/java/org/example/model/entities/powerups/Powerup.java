package org.example.model.entities.powerups;

import org.example.model.entities.Entity;
import org.example.model.entities.Player;

public abstract class Powerup extends Entity {
    public Powerup(int x, int y) {
        super(x, y, false, false, true);
    }

    public abstract void applyPowerup(Player player);
}
