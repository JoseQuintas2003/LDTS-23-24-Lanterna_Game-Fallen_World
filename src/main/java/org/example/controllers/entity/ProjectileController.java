package org.example.controllers.entity;

import org.example.Game;
import org.example.controllers.GameController;
import org.example.gui.GUI;
import org.example.model.Position;
import org.example.model.arena.Arena;
import org.example.model.entities.Projectile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProjectileController extends GameController {

    private GUI.GUI_ACTION lastMovement;
    private long timeLastMovement;

    private int maxProjectiles;

    Boolean canMove = true;

    public ProjectileController(Arena arena) {
        super(arena);
        this.lastMovement = GUI.GUI_ACTION.DOWN;
        this.maxProjectiles = 1;
        this.timeLastMovement = 0;
    }

    public void setLastMovement(GUI.GUI_ACTION action) {
        if (action == GUI.GUI_ACTION.UP || action == GUI.GUI_ACTION.DOWN || action == GUI.GUI_ACTION.LEFT || action == GUI.GUI_ACTION.RIGHT) {
            this.lastMovement = action;
        }
    }

    public void setMaxProjectiles(int maxProjectiles) {
        this.maxProjectiles = maxProjectiles;
    }

    public void createProjectile(GUI.GUI_ACTION action) {
        int playerPosX = getModel().getPlayer().getPosition().getX();
        int playerPosY = getModel().getPlayer().getPosition().getY();

        //Add damage specification here after multiple weapons are implemented

        switch (action) {
            case UP -> {
                Projectile projectile = new Projectile(playerPosX, playerPosY - 1, 5, new Position(playerPosX, playerPosY - 25));
                getModel().addProjectile(projectile);
            }
            case DOWN -> {
                Projectile projectile = new Projectile(playerPosX, playerPosY + 1, 5, new Position(playerPosX, playerPosY + 25));
                getModel().addProjectile(projectile);
            }
            case LEFT -> {
                Projectile projectile = new Projectile(playerPosX - 1, playerPosY, 5, new Position(playerPosX - 25, playerPosY));
                getModel().addProjectile(projectile);
            }
            case RIGHT -> {
                Projectile projectile = new Projectile(playerPosX + 1, playerPosY, 5, new Position(playerPosX + 25, playerPosY));
                getModel().addProjectile(projectile);
            }
        }

    }

    @Override
    public void step(Game game, GUI.GUI_ACTION action, long time){
        List<Projectile> projectileToRemove = new ArrayList<>();

        setLastMovement(action);

        if (action == GUI.GUI_ACTION.FIRE && getModel().countProjectiles() < this.maxProjectiles) {
            createProjectile(lastMovement);
        }

        for (Projectile projectile : getModel().getProjectileList()) {
            if (projectile.getPosition().equals(projectile.getFinalPosition())) {
                projectileToRemove.add(projectile);
            } else if (time - timeLastMovement > game.FPS / 10){
                canMove = false;
                Position nextPosition = projectile.calculatePosition(projectile.getFinalPosition(), 1);

                if (!getModel().isEmpty(nextPosition)) projectileToRemove.add(projectile);
                else projectile.setPosition(nextPosition);
            }
        }
        if (!canMove) {
            timeLastMovement = time;
            canMove = true;
        }


        for (Projectile projectile : projectileToRemove) {
            getModel().removeProjectile(projectile);
        }
    }
}
