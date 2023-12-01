package org.example.viewers.entities;

import org.example.gui.GUI;
import org.example.model.entities.Player;

public class PlayerViewer implements EntityViewer<Player> {
    @Override
    public void draw(Player player, GUI gui) {
        gui.drawHero(player.getPosition());
    }
}
