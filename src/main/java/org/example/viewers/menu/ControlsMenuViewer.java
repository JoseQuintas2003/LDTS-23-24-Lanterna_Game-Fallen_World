package org.example.viewers.menu;

import org.example.gui.GUI;
import org.example.model.menu.Menu;
import org.example.model.Position;
import org.example.viewers.Viewer;


public class ControlsMenuViewer extends Viewer<Menu> {
    public ControlsMenuViewer(Menu model) {
        super(model);
    }

    @Override
    protected void drawEntities(GUI gui) {
        gui.drawText(new Position(5, 3), "Movement:", "#FFFFFF");
        gui.drawText(new Position(5,5), "W/A/S/D - Move Player (Up, Left, Down, Right)", "#FFFFFF");

        gui.drawText(new Position(5, 8), "Shooting:", "#FFFFFF");
        gui.drawText(new Position(5, 10), "Up/Down Arrow - Fire bullet up/down", "#FFFFFF");
        gui.drawText(new Position(5, 11), "Left/Right Arrow - Fire bullet left/right", "#FFFFFF");
        gui.drawText(new Position(5, 12), "R - Reload", "#FFFFFF");

        gui.drawText(new Position(5, 15), "Other:", "#FFFFFF");
        gui.drawText(new Position(5, 17), "Q - Quit Game", "#FFFFFF");

        gui.drawText(new Position(5, 20), "Press Enter to return to Main Menu", "#FFFFFF");
    }
}
