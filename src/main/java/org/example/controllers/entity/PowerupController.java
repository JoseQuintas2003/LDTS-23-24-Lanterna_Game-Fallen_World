package org.example.controllers.entity;

import org.example.Game;
import org.example.controllers.Controller;
import org.example.controllers.GameController;
import org.example.gui.GUI;
import org.example.model.Position;
import org.example.model.arena.Arena;
import org.example.model.entities.powerups.HealthRegen;
import org.example.model.entities.powerups.Powerup;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class PowerupController extends GameController {

    private int maxPowerups;
    public PowerupController(Arena arena) {
        super(arena);
        this.maxPowerups = 3;
    }

    public int getMaxPowerups() {
        return this.maxPowerups;
    }

    public void setMaxPowerups(int maxPowerups) {
        this.maxPowerups = maxPowerups;
    }

    public void createPowerup(int x, int y) {

        /* To add later
        switch (random) {
            case 0:
                getModel().addPowerup(new Powerup(new Position(x, y), Powerup.POWERUP_TYPE.HEALTH));
                break;
            case 1:
                getModel().addPowerup(new Powerup(new Position(x, y), Powerup.POWERUP_TYPE.AMMO));
                break;
            case 2:
                getModel().addPowerup(new Powerup(new Position(x, y), Powerup.POWERUP_TYPE.SPEED));
                break;
        }
         */

        HealthRegen healthRegen = new HealthRegen(x, y);
        getModel().addPowerup(healthRegen);
    }

    @Override
    public void step(Game game, GUI.GUI_ACTION action, long time) throws IOException {
        List<Powerup> powerupsToRemove = new ArrayList<>();

        for (Powerup powerup : getModel().getPowerupsList()) {
            if (powerup.getPosition().equals(getModel().getPlayer().getPosition())) {
                powerup.applyPowerup(getModel().getPlayer());
                powerupsToRemove.add(powerup);
            }
        }

        for (Powerup powerup : powerupsToRemove) {
            getModel().removePowerup(powerup);
        }

        if (getModel().getPowerupsList().size() < getMaxPowerups() && (getModel().getPlayer().getScore() % 50 == 0)) {
            int randomX = (int) (Math.random() * (getModel().getWidth() - 2)) + 1;
            int randomY = (int) (Math.random() * (getModel().getHeight() - 6)) + 5 ;

            if (getModel().isEmpty(new Position(randomX, randomY))) createPowerup(randomX, randomY);
        }
    }
}
