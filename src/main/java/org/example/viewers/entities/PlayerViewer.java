package org.example.viewers.entities;

import org.example.gui.GUI;
import org.example.model.Position;
import org.example.model.entities.Player;

public class PlayerViewer implements EntityViewer<Player> {
    @Override
    public void draw(Player player, GUI gui) {
        gui.drawPlayer(player.getPosition());
        gui.drawHeroHealth(new Position(0,0), player.getHealth());
        gui.drawHeroScore(new Position(0,1), player.getScore());
    }
}
