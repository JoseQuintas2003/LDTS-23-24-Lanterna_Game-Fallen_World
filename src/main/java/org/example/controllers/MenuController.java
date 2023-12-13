package org.example.controllers;

import org.example.Game;
import org.example.gui.GUI;
import org.example.model.Menu;
import org.example.model.arena.RandomArenaBuilder;
import org.example.states.GameState;

import java.io.IOException;

public class MenuController extends Controller<Menu>{
    public MenuController(Menu model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.GUI_ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedControls());
                if (getModel().isSelectedHighscores());
                if (getModel().isSelectedStart()) game.setState(new GameState(new RandomArenaBuilder(50,27).createArena()));

        }
    }
}
