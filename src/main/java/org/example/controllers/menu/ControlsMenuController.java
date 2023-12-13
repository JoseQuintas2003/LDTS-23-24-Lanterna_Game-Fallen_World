package org.example.controllers.menu;

import org.example.Game;
import org.example.controllers.Controller;
import org.example.gui.GUI;
import org.example.model.menu.Menu;
import org.example.states.menu.MenuState;

import java.io.IOException;

public class ControlsMenuController extends Controller<Menu> {
    public ControlsMenuController(Menu model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.GUI_ACTION action, long time) throws IOException {
        if (action == GUI.GUI_ACTION.SELECT) {
            game.setState(new MenuState(new Menu()));
        }
    }
}
