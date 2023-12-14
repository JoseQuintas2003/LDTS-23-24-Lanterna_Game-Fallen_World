package org.example.controllers.menu;

import org.example.Game;
import org.example.controllers.Controller;
import org.example.gui.GUI;
import org.example.model.menu.GameoverMenu;
import org.example.model.menu.Menu;
import org.example.states.menu.MenuState;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class GameoverMenuController extends Controller<GameoverMenu> {

    public GameoverMenuController(GameoverMenu model) {
        super(model);
    }

    public String getPlayerName(List<Character> name) {
        StringBuilder str = new StringBuilder();

        for (Character c : name) {
            str.append(c);
        }

        return str.toString();
    }

    public void updateHighScores(String playerName, int playerScore) {
        try {
            FileReader file = new FileReader("src/main/resources/highscores.txt");
            Scanner scanner = new Scanner(file);

            TreeMap<Integer, String> highScoresMap = new TreeMap<>(Comparator.reverseOrder());
            boolean playerFound = false;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    int score = Integer.parseInt(parts[1]);
                    highScoresMap.put(score, parts[0]);
                }
            }

            if (!playerFound) {
                highScoresMap.put(playerScore, playerName);
            }

            while (highScoresMap.size() > 10) {
                highScoresMap.pollLastEntry();
            }

            FileWriter writer = new FileWriter("src/main/resources/highscores.txt");
            for (Map.Entry<Integer, String> entry : highScoresMap.entrySet()) {
                writer.write(entry.getValue() + " " + entry.getKey() + "\n");
            }
            writer.close();

        } catch (IOException e) {
            System.out.println("Error updating high scores: " + e.getMessage());
        }
    }

    @Override
    public void step(Game game, GUI.GUI_ACTION action, long time) throws IOException {
        if (action == GUI.GUI_ACTION.QUIT) {
            game.setState(new MenuState(new Menu()));
        }

        switch (action) {
            case ARROW_UP -> {
                getModel().nextLetter();
            }
            case ARROW_DOWN -> {
                getModel().prevLetter();
            }
            case ARROW_LEFT -> {
                getModel().prevChar();
            }
            case ARROW_RIGHT -> {
                getModel().nextChar();
            }
            case SELECT-> {
                updateHighScores(getPlayerName(getModel().getName()), getModel().getScore());
                game.setState(new MenuState(new Menu()));
            }
        }
    }
}
