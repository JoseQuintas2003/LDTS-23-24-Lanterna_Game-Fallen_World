package org.example.controllers.entity;

import org.example.Game;
import org.example.controllers.GameController;
import org.example.gui.GUI;
import org.example.model.Position;
import org.example.model.arena.Arena;
import org.example.model.entities.Enemy;

import java.io.IOException;

public class EnemyController extends GameController{
    public EnemyController(Arena arena) {
        super(arena);
    }

    public boolean detectsPlayer(Enemy enemy){
        Position playerPos = getModel().getPlayer().getPosition();

        return enemy.getPosition().isNear(playerPos, enemy.getDetectionRadius());
    }

    public void moveEnemy(Enemy enemy, Position position) {
        if (getModel().isEmpty(position)){
            enemy.setPosition(position);
        }
    }

    @Override
    public void step(Game game, GUI.GUI_ACTION action, long time) throws IOException {
        for (Enemy enemy : getModel().getEnemiesList()){
            enemy.detectedPlayer = detectsPlayer(enemy);

            if (enemy.detectedPlayer){

                System.out.println();

                Position playerPos = getModel().getPlayer().getPosition();

                moveEnemy(enemy, playerPos);
            }
        }
    }
}
