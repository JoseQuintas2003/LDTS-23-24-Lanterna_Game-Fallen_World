package org.example.controllers.entity;

import org.example.Game;
import org.example.controllers.GameController;
import org.example.gui.GUI;
import org.example.model.Position;
import org.example.model.arena.Arena;

import java.io.IOException;

public class PlayerController extends GameController {

    private long timeLastMovement;

    private GUI.GUI_ACTION lastAction;
    public PlayerController(Arena arena) {
        super(arena);
        this.timeLastMovement = 0;
        this.lastAction = GUI.GUI_ACTION.NONE;
    }

    public void movePlayer(Position position) {
        if (!getModel().isEnemy(position) && !getModel().isWall(position)) {
            getModel().getPlayer().setPosition(position);
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
        if (action == GUI.GUI_ACTION.RELOAD) getModel().getPlayer().setCurrentBulletCount(getModel().getPlayer().getMaxBulletCount());

        if (time - timeLastMovement < (game.FPS / (getModel().getPlayer().SPEED * 0.5))) {
            switch (action) {
                case UP -> {
                    this.lastAction = GUI.GUI_ACTION.UP;
                }
                case DOWN -> {
                    this.lastAction = GUI.GUI_ACTION.DOWN;
                }
                case LEFT -> {
                    this.lastAction = GUI.GUI_ACTION.LEFT;
                }
                case RIGHT -> {
                    this.lastAction = GUI.GUI_ACTION.RIGHT;
                }
            }
        }
        else {
            switch (this.lastAction) {
                case UP -> {
                    movePlayerUp();
                }
                case DOWN -> {
                    movePlayerDown();
                }
                case LEFT -> {
                    movePlayerLeft();
                }
                case RIGHT -> {
                    movePlayerRight();
                }
            }
            this.lastAction = GUI.GUI_ACTION.NONE;
            this.timeLastMovement = time;
        }
    }
}
