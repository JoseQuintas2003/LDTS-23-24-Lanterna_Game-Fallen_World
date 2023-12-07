package org.example.viewers.entities;

import org.example.gui.GUI;
import org.example.model.entities.Enemy;

public class EnemyViewer implements EntityViewer<Enemy>{
    @Override
    public void draw(Enemy enemy, GUI gui) { gui.drawEnemy(enemy.getPosition()); }
}
