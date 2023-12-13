package org.example.viewers.menu;

import org.example.gui.GUI;
import org.example.model.Menu;
import org.example.model.Position;
import org.example.viewers.Viewer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.security.KeyPair;
import java.util.ArrayList;
import java.util.Scanner;

public class HighscoreMenuViewer extends Viewer<Menu> {
    public HighscoreMenuViewer(Menu model) {
        super(model);
    }

    public String getHighScore(int i) {
        try {
            FileReader reader = new FileReader("src/main/resources/highscores.txt");
            Scanner scanner = new Scanner(reader);
            ArrayList<String> highscores = new ArrayList<>();

            while (scanner.hasNextLine()) {
                highscores.add(scanner.nextLine());
            }

            if (i >= highscores.size()) return "TBD 0";

            return highscores.get(i);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return "0";
        }
    }

    @Override
    protected void drawEntities(GUI gui) {
        gui.drawText(new Position(5,5), "Highscores:", "#FFFFFF");

        for (int i = 0; i < 10; i++) {
            gui.drawText(new Position(5, 7 + i), (i + 1) + ". " + getHighScore(i), "#FFFFFF");
        }
    }
}
