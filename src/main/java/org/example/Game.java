package org.example;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.example.gui.LanternaGUI;
import org.example.gui.GUI;
import org.example.model.Position;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Game {
    private final LanternaGUI GUI;

    public Game() throws IOException, FontFormatException, URISyntaxException {
        this.GUI = new LanternaGUI(40, 40);
    }

    public LanternaGUI getGUI(){
        return this.GUI;
    }
    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException{
        Game game = new Game();

        //As linhas abaixo são de caracter puramente ilustrativo, para mostrar que o código está a funcionar

        game.getGUI().drawWall(new Position(10, 10));
        game.getGUI().drawHero(new Position(15, 10));
        game.getGUI().drawEnemy(new Position(20, 10));
        game.getGUI().drawNPC(new Position(25, 10));

        org.example.gui.GUI.GUI_ACTION keyboardAction;

        while (true) {
            keyboardAction = game.getGUI().getKeyboardAction();

            if (keyboardAction == org.example.gui.GUI.GUI_ACTION.UP) {
                System.out.println("UP");
            }
            if (keyboardAction == org.example.gui.GUI.GUI_ACTION.DOWN) {
                System.out.println("DOWN");
            }
            if (keyboardAction == org.example.gui.GUI.GUI_ACTION.LEFT) {
                System.out.println("LEFT");
            }
            if (keyboardAction == org.example.gui.GUI.GUI_ACTION.RIGHT) {
                System.out.println("RIGHT");
            }
            if (keyboardAction == org.example.gui.GUI.GUI_ACTION.FIRE) {
                System.out.println("FIRE");
            }
            if (keyboardAction == org.example.gui.GUI.GUI_ACTION.QUIT) {
                System.out.println("QUIT");
                break;
            }
        }
        game.getGUI().close();
    }
}
