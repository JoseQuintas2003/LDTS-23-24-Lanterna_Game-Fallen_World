package org.example.viewers.entities;

import org.example.gui.GUI;
import org.example.model.entities.Projectile;

public class ProjectileViewer implements EntityViewer<Projectile>{
    @Override
    public void draw(Projectile element, GUI gui) {
        gui.drawProjectile(element.getPosition());
    }
}
