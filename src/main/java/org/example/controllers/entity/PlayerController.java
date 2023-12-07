package org.example.controllers.entity;

import org.example.Game;
import org.example.controllers.GameController;
import org.example.gui.GUI;
import org.example.model.Position;
import org.example.model.arena.Arena;

import java.io.IOException;

public class PlayerController extends GameController {
    public PlayerController(Arena arena) {
        super(arena);
    }

    public void movePlayer(Position position) {
        if (getModel().isEmpty(position)){
            getModel().getPlayer().moveToPosition(position, getModel().getPlayer().SPEED);
        }
    }

    public void movePlayerUp() {
        int newX = getModel().getPlayer().getPosition().getX();
        int newY = getModel().getPlayer().getPosition().getY() - 1;

        movePlayer(new Position(newX, newY));
    }

    public void movePlayerDown() {
        int newX = getModel().getPlayer().getPosition().getX();
        int newY = getModel().getPlayer().getPosition().getY() + 1;

        movePlayer(new Position(newX, newY));
    }

    public void movePlayerLeft() {
        int newX = getModel().getPlayer().getPosition().getX() - 1;
        int newY = getModel().getPlayer().getPosition().getY();

        movePlayer(new Position(newX, newY));
    }

    public void movePlayerRight() {
        int newX = getModel().getPlayer().getPosition().getX() + 1;
        int newY = getModel().getPlayer().getPosition().getY();

        movePlayer(new Position(newX, newY));
    }

    @Override
    public void step(Game game, GUI.GUI_ACTION action, long time) throws IOException {
        if (action == GUI.GUI_ACTION.UP) movePlayerUp();
        if (action == GUI.GUI_ACTION.RIGHT) movePlayerRight();
        if (action == GUI.GUI_ACTION.DOWN) movePlayerDown();
        if (action == GUI.GUI_ACTION.LEFT) movePlayerLeft();
        if (action == GUI.GUI_ACTION.QUIT) game.getGUI().close();
    }
}
