package org.example.viewers.entities.powerups;

import org.example.gui.GUI;
import org.example.model.entities.powerups.HealthRegen;
import org.example.model.entities.powerups.Powerup;
import org.example.viewers.entities.EntityViewer;

public class PowerupViewer implements EntityViewer<Powerup> {
    @Override
    public void draw(Powerup element, GUI gui) {
        if (element.getClass() == HealthRegen.class) gui.drawHealthRegen(element.getPosition());
    }
}
