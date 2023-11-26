package org.example.model.arena;

import org.example.model.entities.Enemy;
import org.example.model.entities.Player;
import org.example.model.entities.Wall;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomArenaBuilder extends ArenaBuilder{

    private final Random rng;
    private final int width;
    private final int height;

    public RandomArenaBuilder(int width, int height) {
        this.rng = new Random();
        this.width = width;
        this.height = height;
    }

    @Override
    protected int getWidth() {
        return this.width;
    }

    @Override
    protected int getHeight() {
        return this.height;
    }

    @Override
    protected Player createPlayer() {
        return new Player(10, 10, 100, 0);
    }

    @Override
    protected List<Enemy> createEnemies() {
        return null;
    }

    @Override
    protected List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int i = 0; i < width; i++) {
            walls.add(new Wall(i, 0));
            walls.add(new Wall(i, height - 1));
        }

        for (int i = 0; i < height; i++) {
            walls.add(new Wall(0, i));
            walls.add(new Wall(width - 1, i));
        }

        return walls;
    }
}
