package org.example.viewers.entities;

import org.example.gui.GUI;
import org.example.model.entities.Wall;

import java.io.IOException;

public class WallViewer implements EntityViewer<Wall> {
    @Override
    public void draw(Wall wall, GUI gui) {
        gui.drawWall(wall.getPosition());
    }
}
