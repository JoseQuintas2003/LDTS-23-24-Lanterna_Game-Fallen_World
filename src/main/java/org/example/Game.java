package org.example;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.example.gui.LanternaGUI;
import org.example.gui.GUI;
import org.example.model.Position;
import org.example.model.arena.Arena;
import org.example.model.arena.RandomArenaBuilder;
import org.example.model.entities.Player;
import org.example.model.entities.Wall;
import org.example.states.GameState;
import org.example.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Game {
    private final LanternaGUI GUI;

    public final int FPS = 200;

    private State state;

    public Game() throws IOException, FontFormatException, URISyntaxException {
        this.GUI = new LanternaGUI(50, 50);
        this.state = new GameState(new RandomArenaBuilder(50, 50).createArena());
    }

    public LanternaGUI getGUI(){
        return this.GUI;
    }

    //To change later
    private void start() throws IOException {
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            //Temporary code

            //End of temporary code

            long startTime = System.currentTimeMillis();

            state.step(this, GUI, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }

        GUI.close();
    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException{
        Game game = new Game();

        game.start();

        //As linhas abaixo são de caracter puramente ilustrativo, para mostrar que o código está a funcionar e devem ser removidas no futuro

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
