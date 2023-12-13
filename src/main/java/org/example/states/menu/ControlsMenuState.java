package org.example.states.menu;

import org.example.controllers.Controller;
import org.example.controllers.menu.ControlsMenuController;
import org.example.model.Menu;
import org.example.states.State;
import org.example.viewers.Viewer;
import org.example.viewers.menu.ControlsMenuViewer;

public class ControlsMenuState extends State<Menu> {

    public ControlsMenuState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new ControlsMenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new ControlsMenuController(getModel());
    }
}
