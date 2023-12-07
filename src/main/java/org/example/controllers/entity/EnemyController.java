package org.example.controllers.entity;

import org.example.Game;
import org.example.controllers.GameController;
import org.example.gui.GUI;
import org.example.model.Position;
import org.example.model.arena.Arena;
import org.example.model.entities.Enemy;

import java.io.IOException;

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

    public void moveEnemy(Enemy enemy, Position position) {
       Position newPosition = enemy.calculatePosition(position, 1);

       if (!newPosition.equals(position) && getModel().isEmpty(newPosition)) {
          enemy.setPosition(newPosition);
       }
    }

    @Override
    public void step(Game game, GUI.GUI_ACTION action, long time) throws IOException {
        if (time - timeLastMovement > 500) {
            for (Enemy enemy : getModel().getEnemiesList()){
                enemy.detectedPlayer = detectsPlayer(enemy);

                if (enemy.detectedPlayer){

                    System.out.println("Enemy detected player!");

                    Position playerPos = getModel().getPlayer().getPosition();

                    moveEnemy(enemy, playerPos);
                }
            }
            this.timeLastMovement = time;
        }
    }
}
