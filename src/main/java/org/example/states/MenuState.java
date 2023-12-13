package org.example.states;

import org.example.controllers.Controller;
import org.example.controllers.MenuController;
import org.example.viewers.MenuViewer;
import org.example.model.Menu;
import org.example.viewers.Viewer;

import java.awt.*;

public class MenuState extends State<Menu>{
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}
