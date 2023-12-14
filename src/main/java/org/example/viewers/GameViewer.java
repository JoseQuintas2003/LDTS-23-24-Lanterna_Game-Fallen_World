package org.example.viewers;

import org.example.gui.GUI;
import org.example.model.arena.Arena;
import org.example.model.entities.Entity;
import org.example.viewers.entities.*;
import org.example.viewers.entities.powerups.PowerupViewer;

import java.util.List;

public class GameViewer extends Viewer<Arena> {
    public GameViewer(Arena arena) {
        super(arena);
    }

    @Override
    protected void drawEntities(GUI gui) {
        drawEntities(gui, getModel().getWallList(), new WallViewer());
        drawEntities(gui, getModel().getEnemiesList(), new EnemyViewer());
        drawEntity(gui, getModel().getPlayer(), new PlayerViewer());
        drawEntities(gui, getModel().getProjectileList(), new ProjectileViewer());
        drawEntities(gui, getModel().getPowerupsList(), new PowerupViewer());
        drawEntities(gui, getModel().getWeaponsList(), new WeaponViewer());
    }

    public <T extends Entity> void drawEntities(GUI gui, List<T> entities, EntityViewer<T> viewer) {
        if (entities != null) {
            for (T entity : entities)
                drawEntity(gui, entity, viewer);
        }
    }

    public <T extends Entity> void drawEntity(GUI gui, T entity, EntityViewer<T> viewer) {
        viewer.draw(entity, gui);
    }
}
