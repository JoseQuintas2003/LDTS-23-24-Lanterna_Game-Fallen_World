package org.example;

import org.example.gui.LanternaGUI;
import org.example.model.Menu;
import org.example.states.menu.MenuState;
import org.example.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final LanternaGUI GUI;

    public final int FPS = 100;

    private State state;

    public Game() throws IOException, FontFormatException, URISyntaxException {
        this.GUI = new LanternaGUI(54, 27);
        this.state = new MenuState(new Menu());
        //this.state = new GameState(new RandomArenaBuilder(50, 50).createArena());
    }

    public LanternaGUI getGUI(){
        return this.GUI;
    }

    public void setState(State state) {
        this.state = state;
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

        game.getGUI().close();
    }
}
