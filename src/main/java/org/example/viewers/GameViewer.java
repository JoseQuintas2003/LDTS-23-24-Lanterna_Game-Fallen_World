package org.example.viewers;

import org.example.gui.GUI;
import org.example.model.arena.Arena;
import org.example.model.entities.Entity;
import org.example.viewers.entities.EnemyViewer;
import org.example.viewers.entities.EntityViewer;
import org.example.viewers.entities.PlayerViewer;
import org.example.viewers.entities.WallViewer;

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
    }

    public <T extends Entity> void drawEntities(GUI gui, List<T> entities, EntityViewer<T> viewer) {
        for (T entity : entities)
            drawEntity(gui, entity, viewer);
    }

    public <T extends Entity> void drawEntity(GUI gui, T entity, EntityViewer<T> viewer) {
        viewer.draw(entity, gui);
    }
}
