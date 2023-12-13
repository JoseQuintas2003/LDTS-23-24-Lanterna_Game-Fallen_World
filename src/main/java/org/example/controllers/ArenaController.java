package org.example.controllers;

import org.example.Game;
import org.example.controllers.entity.EnemyController;
import org.example.controllers.entity.PlayerController;
import org.example.controllers.entity.PowerupController;
import org.example.controllers.entity.ProjectileController;
import org.example.gui.GUI;
import org.example.model.Position;
import org.example.model.arena.Arena;
import org.example.model.entities.Enemy;
import org.example.model.menu.GameoverMenu;
import org.example.model.menu.Menu;
import org.example.states.menu.GameoverMenuState;

import java.io.IOException;

public class ArenaController extends Controller<Arena>{

    private final PlayerController playerController;

    private final EnemyController enemyController;

    private final ProjectileController projectileController;

    private final PowerupController powerupController;

    private long timeLastStep;

    public ArenaController(Arena arena) {
        super(arena);
        this.playerController = new PlayerController(arena);
        this.enemyController = new EnemyController(arena);
        this.projectileController = new ProjectileController(arena);
        this.powerupController = new PowerupController(arena);

        timeLastStep = 0;
    }

    public void addEnemyToArena() {
        int randomX = (int) (Math.random() * (getModel().getWidth() - 2)) + 1;
        int randomY = (int) (Math.random() * (getModel().getHeight() - 6)) + 5 ;

        if (getModel().isEmpty(new Position(randomX, randomY)) && !getModel().getPlayer().getPosition().isNear(new Position(randomX, randomY), 4)) {
            Enemy enemy = new Enemy(randomX, randomY, 10);

            getModel().addEnemy(enemy);
        }
    }

    public static double calculateSpawnRate(int score, int FPS) {

        // Calculate the spawn rate using an exponential growth formula
        double spawnRate = 0.035 * Math.exp(score * 0.001);

        // Cap the spawn rate to a maximum value if needed
        double maxSpawnRate = 100.0;  // Adjust as needed
        spawnRate = Math.min(spawnRate, maxSpawnRate);

        if (score == 0) {
            spawnRate = 0.035;
        }

        // Calculate the number of frames per enemy
        double framesPerEnemy = 1.0 / (spawnRate / FPS);

        return framesPerEnemy;
    }

    @Override
    public void step(Game game, GUI.GUI_ACTION action, long time) throws IOException {
        if (action == GUI.GUI_ACTION.QUIT || getModel().getPlayer().getHealth() <= 0) {
            game.setState(new GameoverMenuState(new GameoverMenu(getModel().getPlayer().getScore()), getModel().getPlayer().getScore()));
        }
        else {
            playerController.step(game, action, time);
            enemyController.step(game, action, time);
            projectileController.step(game, action, time);
            powerupController.step(game, action, time);
        }

        if ((time - timeLastStep > calculateSpawnRate(getModel().getPlayer().getScore(), game.FPS)) && (getModel().getEnemiesList().size() < enemyController.getMaxEnemies())) {
            addEnemyToArena();
            timeLastStep = time;
        }
        System.out.println("Enemies: " + getModel().getEnemiesList().size());
    }
}
