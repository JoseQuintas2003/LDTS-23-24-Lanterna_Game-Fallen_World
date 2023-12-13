package org.example.model.arena;

import org.example.model.entities.Enemy;
import org.example.model.entities.Player;
import org.example.model.entities.Wall;
import org.example.model.entities.powerups.HealthRegen;
import org.example.model.entities.powerups.Powerup;

import java.util.ArrayList;
import java.util.Arrays;
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

        List<Enemy> enemies = new ArrayList<>();

        for (int i=0; i < 6; i++) {
            int randomX = rng.nextInt(width - 2) + 1;
            int randomY = rng.nextInt(height - 6) + 5;

            if (randomX == 10 && randomY == 10) {
                randomX = rng.nextInt(width - 2) + 1;
                randomY = rng.nextInt(height - 6) + 5;
            }

            enemies.add(new Enemy(randomX, randomY, 10));
        }

        return enemies;
    }

    @Override
    protected List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int i = 0; i < width; i++) {
            walls.add(new Wall(i, 3));
            walls.add(new Wall(i, height - 1));
        }

        for (int i = 3; i < height; i++) {
            walls.add(new Wall(0, i));
            walls.add(new Wall(width - 1, i));
        }

        return walls;
    }

    @Override
    protected ArrayList<Powerup> createPowerups() {
        ArrayList<Powerup> powerups = new ArrayList<>();

        powerups.add(new HealthRegen(20, 20));

        return powerups;
    }
}
