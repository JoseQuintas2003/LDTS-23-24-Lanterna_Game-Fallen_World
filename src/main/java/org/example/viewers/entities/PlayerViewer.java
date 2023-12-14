package org.example.viewers.entities;

import org.example.gui.GUI;
import org.example.model.Position;
import org.example.model.entities.Player;

public class PlayerViewer implements EntityViewer<Player> {
    @Override
    public void draw(Player player, GUI gui) {
        gui.drawPlayer(player.getPosition());
        gui.drawHeroHealth(player.getHealth());
        gui.drawHeroScore(player.getScore());
        gui.drawBullets(player.getCurrentBulletCount(), player.getMaxBulletCount());
        gui.drawCurrentWeapon(player.getCurrentWeapon().getName());
    }
}
