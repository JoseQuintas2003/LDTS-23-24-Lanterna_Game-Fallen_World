package org.example.viewers.menu;

import org.example.gui.GUI;
import org.example.model.menu.GameoverMenu;
import org.example.model.menu.Menu;
import org.example.model.Position;
import org.example.viewers.Viewer;

import java.util.List;


public class GameoverMenuViewer extends Viewer<GameoverMenu> {

    private int score;
    public GameoverMenuViewer(GameoverMenu model, int score) {
        super(model);
        this.score = score;
    }

    @Override
    protected void drawEntities(GUI gui) {
        gui.drawText(new Position(5, 5), "Game Over", "#FFFFFF");

        gui.drawText(new Position(5, 8), "Your score: " + score, "#FFFFFF");

        gui.drawText(new Position(5, 11), "Please, enter your name:", "#FFFFFF");

        for (int i=0; i < getModel().getName().size(); i++){
            char c = getModel().getName().get(i);

            if (i == getModel().getCurrentChar()) {
                gui.drawText(new Position(5 + i, 13), "" + c, "#FFD700");
            }
            else gui.drawText(new Position(5 + i, 13), "" + c, "#FFFFFF");

        }

        gui.drawText(new Position(5, 16), "Press the Up/Down Arrows to change letter", "#FFFFFF");

        gui.drawText(new Position(5, 18), "Press the Left/Right Arrows to change position", "#FFFFFF");

        gui.drawText(new Position(5, 20), "Press Enter to save your score", "#FFFFFF");

        gui.drawText(new Position(5, 23), "Press Q to return to the main menu", "#FFFFFF");
        gui.drawText(new Position(5, 24), "Note: This will not save your score", "#FFFFFF");
    }
}
