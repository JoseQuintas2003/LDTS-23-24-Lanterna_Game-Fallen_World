package org.example.model.entities.powerups;

import org.example.model.entities.Player;

public class HealthBoost extends Powerup{
    public HealthBoost(int x, int y) {
        super(x, y);
    }

    @Override
    public void applyPowerup(Player player) {
        player.setMaxHealth(player.getMaxHealth() + 10);
    }
}
