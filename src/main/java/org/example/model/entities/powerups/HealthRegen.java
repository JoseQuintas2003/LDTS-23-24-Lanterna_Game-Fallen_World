package org.example.model.entities.powerups;

import org.example.model.entities.Entity;
import org.example.model.entities.Player;

public class HealthRegen extends Powerup{
    public HealthRegen(int x, int y) {
        super(x, y);
    }

    @Override
    public void applyPowerup(Player player) {
        int healthRegen = 100 - player.getHealth();
        player.increaseHealth(healthRegen);
    }
}
