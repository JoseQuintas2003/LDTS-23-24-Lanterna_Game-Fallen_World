package org.example.states.menu;

import org.example.controllers.Controller;
import org.example.controllers.menu.GameoverMenuController;
import org.example.model.menu.GameoverMenu;
import org.example.model.menu.Menu;
import org.example.states.State;
import org.example.viewers.Viewer;
import org.example.viewers.menu.GameoverMenuViewer;

public class GameoverMenuState extends State<GameoverMenu> {
    public GameoverMenuState(GameoverMenu model, int score) {
        super(model, score);
    }

    @Override
    protected Viewer<GameoverMenu> getViewer() {
        return null;
    }

    @Override
    protected Viewer<GameoverMenu> getViewer(int score) {
        return new GameoverMenuViewer(getModel(), score);
    }

    @Override
    protected Controller<GameoverMenu> getController() {
        return new GameoverMenuController(getModel());
    }
}
