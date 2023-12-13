package org.example.states.menu;

import org.example.controllers.Controller;
import org.example.controllers.menu.HighscoreMenuController;
import org.example.model.Menu;
import org.example.states.State;
import org.example.viewers.Viewer;
import org.example.viewers.menu.HighscoreMenuViewer;

public class HighscoreMenuState extends State<Menu> {
    public HighscoreMenuState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new HighscoreMenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new HighscoreMenuController(getModel());
    }
}
