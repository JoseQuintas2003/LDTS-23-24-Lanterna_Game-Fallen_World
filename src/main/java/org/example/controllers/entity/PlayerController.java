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

    public void stayInPlace() {
        movePlayer(getModel().getPlayer().getPosition());
    }

    @Override
    public void step(Game game, GUI.GUI_ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                movePlayerUp();
                break;
            case DOWN:
                movePlayerDown();
                break;
            case LEFT:
                movePlayerLeft();
                break;
            case RIGHT:
                movePlayerRight();
                break;
            case NONE:
                stayInPlace();
                break;
            case QUIT:
                game.getGUI().close();
                break;
        }
    }
}
