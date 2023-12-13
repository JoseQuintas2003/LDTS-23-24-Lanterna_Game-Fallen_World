package org.example.controllers.entity;

import org.example.Game;
import org.example.controllers.GameController;
import org.example.gui.GUI;
import org.example.model.Position;
import org.example.model.arena.Arena;
import org.example.model.entities.Enemy;
import org.example.model.entities.Player;
import org.example.model.entities.Projectile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EnemyController extends GameController{

    private long timeLastMovement;
    public EnemyController(Arena arena) {
        super(arena);
        this.timeLastMovement = 0;
    }

    public boolean detectsPlayer(Enemy enemy){
        Position playerPos = getModel().getPlayer().getPosition();

        return enemy.getPosition().isNear(playerPos, enemy.getDetectionRadius());
    }

    public void damageEnemies() {
        for (Enemy enemy : getModel().getEnemiesList()) {
            for (Projectile projectile : getModel().getProjectileList()) {
                if (enemy.projectileHits(projectile.getPosition(), projectile.getFinalPosition())) {
                    enemy.decreaseHealth(projectile.getDamage());
                    System.out.printf("Enemy Health: %d\n", enemy.getHealth());
                }
                if (projectile.getPosition().equals(enemy.getPosition())) {
                    enemy.decreaseHealth(projectile.getDamage());
                    System.out.printf("Enemy Health: %d\n", enemy.getHealth());
                }
            }
        }
    }

    public void removeDeadEnemies() {
        List<Enemy> enemiesToRemove = new ArrayList<>();

        for (Enemy enemy : getModel().getEnemiesList()) {
            if (enemy.getHealth() <= 0) {
                enemiesToRemove.add(enemy);
            }
        }

        for (Enemy enemy : enemiesToRemove) {
            getModel().removeEnemy(enemy);
            getModel().getPlayer().increaseScore(10);
        }
    }

    public void moveEnemy(Enemy enemy, Position position) {
       Position newPosition = enemy.calculatePosition(position, 1);

       if (!newPosition.equals(position) && getModel().isEmpty(newPosition)) {
          enemy.setPosition(newPosition);
       }
    }

    public void damagePlayer(Enemy enemy, int damage) {
        Player player = getModel().getPlayer();

        if (player.getPosition().isNear(enemy.getPosition(), 1)) {
            player.decreaseHealth(damage);
        }
    }

    @Override
    public void step(Game game, GUI.GUI_ACTION action, long time) throws IOException {
        if (time - timeLastMovement > game.FPS / 0.2 ) {
            for (Enemy enemy : getModel().getEnemiesList()){

                //Enemy Detection of Player and Movement
                enemy.detectedPlayer = detectsPlayer(enemy);

                if (enemy.detectedPlayer) {

                    Position playerPos = getModel().getPlayer().getPosition();

                    moveEnemy(enemy, playerPos);

                    damagePlayer(enemy, 5); //mudar valor de dano
                }
                else {
                    Position enemyPos = enemy.getPosition();

                    int randomX = (int) (Math.random() * 3) - 1;
                    int randomY = (int) (Math.random() * 3) - 1;

                    Position newPosition = new Position(enemyPos.getX() + randomX, enemyPos.getY() + randomY);

                    moveEnemy(enemy, newPosition);
                }
            }
            this.timeLastMovement = time;
        }
        damageEnemies();
        removeDeadEnemies();
    }
}
