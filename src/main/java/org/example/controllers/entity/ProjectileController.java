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
        this.lastMovement = GUI.GUI_ACTION.ARROW_DOWN;
        this.maxProjectiles = 1;
        this.timeLastMovement = 0;
    }

    public boolean setLastMovement(GUI.GUI_ACTION action) {
        if (action == GUI.GUI_ACTION.ARROW_UP || action == GUI.GUI_ACTION.ARROW_DOWN || action == GUI.GUI_ACTION.ARROW_LEFT || action == GUI.GUI_ACTION.ARROW_RIGHT) {
            this.lastMovement = action;
            return true;
        }
        return false;
    }

    public void setMaxProjectiles(int maxProjectiles) {
        this.maxProjectiles = maxProjectiles;
    }

    public void createProjectile(GUI.GUI_ACTION action) {
        int playerPosX = getModel().getPlayer().getPosition().getX();
        int playerPosY = getModel().getPlayer().getPosition().getY();

        //Add damage specification here after multiple weapons are implemented

        switch (action) {
            case ARROW_UP -> {
                Projectile projectile = new Projectile(playerPosX, playerPosY - 1, 100, new Position(playerPosX, playerPosY - 25));
                getModel().addProjectile(projectile);
            }
            case ARROW_DOWN -> {
                Projectile projectile = new Projectile(playerPosX, playerPosY + 1, 100, new Position(playerPosX, playerPosY + 25));
                getModel().addProjectile(projectile);
            }
            case ARROW_LEFT -> {
                Projectile projectile = new Projectile(playerPosX - 1, playerPosY, 100, new Position(playerPosX - 25, playerPosY));
                getModel().addProjectile(projectile);
            }
            case ARROW_RIGHT -> {
                Projectile projectile = new Projectile(playerPosX + 1, playerPosY, 100, new Position(playerPosX + 25, playerPosY));
                getModel().addProjectile(projectile);
            }
        }

    }

    @Override
    public void step(Game game, GUI.GUI_ACTION action, long time){
        List<Projectile> projectileToRemove = new ArrayList<>();

        for (Projectile projectile : getModel().getProjectileList()) {
            if (projectile.getPosition().equals(projectile.getFinalPosition())) {
                projectileToRemove.add(projectile);
            }
            else if (getModel().isEnemy(projectile.getPosition())){
                projectileToRemove.add(projectile);
            }
            else if (time - timeLastMovement > game.FPS / 10){
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

        if (setLastMovement(action) && getModel().countProjectiles() < this.maxProjectiles && getModel().getPlayer().getCurrentBulletCount() > 0) {
            createProjectile(lastMovement);
            getModel().getPlayer().setCurrentBulletCount(getModel().getPlayer().getCurrentBulletCount() - 1);
        }
    }
}
