package org.example.viewers.entities;

import org.example.gui.GUI;
import org.example.model.entities.Weapon;
import org.example.viewers.Viewer;

public class WeaponViewer implements EntityViewer<Weapon> {
    @Override
    public void draw(Weapon element, GUI gui) {
        gui.drawWeapon(element.getPosition(), element.getName());
    }
}
