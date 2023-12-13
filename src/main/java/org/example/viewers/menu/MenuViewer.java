package org.example.viewers.menu;

import org.example.gui.GUI;
import org.example.model.Menu;
import org.example.model.Position;
import org.example.viewers.Viewer;

public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu model) {
        super(model);
    }

    @Override
    protected void drawEntities(GUI gui) {
        gui.drawText(new Position(5, 5), "Menu", "#FFFFFF");

        for (int i=0; i < getModel().getNumberEntries(); i++){
            gui.drawText(
                    new Position(5, 7 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF"
            );
        }
    }
}