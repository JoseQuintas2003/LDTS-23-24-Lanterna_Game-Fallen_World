package org.example.states.menu;

import org.example.controllers.Controller;
import org.example.controllers.menu.MenuController;
import org.example.states.State;
import org.example.viewers.menu.MenuViewer;
import org.example.model.menu.Menu;
import org.example.viewers.Viewer;

public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Viewer<Menu> getViewer(int score) {
        return null;
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}
