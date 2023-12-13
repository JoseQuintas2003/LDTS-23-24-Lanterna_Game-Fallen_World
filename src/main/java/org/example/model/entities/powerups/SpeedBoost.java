package org.example.model.entities.powerups;

import org.example.model.entities.Player;

public class SpeedBoost extends Powerup{
    public SpeedBoost(int x, int y) {
        super(x, y);
    }

    @Override
    public void applyPowerup(Player player) {
        player.SPEED += 1;
    }
}
