package org.example.model.arena;

import java.util.ArrayList;
import java.util.List;

import org.example.model.entities.Enemy;
import org.example.model.entities.Player;
import org.example.model.entities.Wall;
import org.example.model.entities.powerups.Powerup;

public abstract class  ArenaBuilder {
    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());

        arena.setPlayer(createPlayer());
        arena.setEnemyList(createEnemies());
        arena.setWallList(createWalls());
        arena.setPowerupsList(createPowerups());

        return arena;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract Player createPlayer();

    protected abstract List<Enemy> createEnemies();

    protected abstract List<Wall> createWalls();

    protected abstract ArrayList<Powerup> createPowerups();

}
