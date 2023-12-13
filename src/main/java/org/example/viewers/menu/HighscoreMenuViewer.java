package org.example.viewers.menu;

import org.example.gui.GUI;
import org.example.model.Menu;
import org.example.model.Position;
import org.example.viewers.Viewer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.security.KeyPair;
import java.util.ArrayList;

public class HighscoreMenuViewer extends Viewer<Menu> {
    public HighscoreMenuViewer(Menu model) {
        super(model);
    }

    @Override
    protected void drawEntities(GUI gui) {
        gui.drawText(new Position(5,5), "Highscores:", "#FFFFFF");

        //TODO: Read highscores from file
    }
}
