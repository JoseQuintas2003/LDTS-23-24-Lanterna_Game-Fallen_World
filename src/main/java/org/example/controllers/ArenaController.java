package org.example.controllers;

import org.example.Game;
import org.example.controllers.entity.EnemyController;
import org.example.controllers.entity.PlayerController;
import org.example.gui.GUI;
import org.example.model.arena.Arena;

import java.io.IOException;

public class ArenaController extends Controller<Arena>{

    private final PlayerController playerController;

    private final EnemyController enemyController;

    public ArenaController(Arena arena) {
        super(arena);
        this.playerController = new PlayerController(arena);
        this.enemyController = new EnemyController(arena);
    }

    @Override
    public void step(Game game, GUI.GUI_ACTION action, long time) throws IOException {
        if (action == GUI.GUI_ACTION.QUIT || getModel().getPlayer().getHealth() <= 0)
            game.getGUI().close();
        else {
            playerController.step(game, action, time);
            enemyController.step(game, action, time);
        }
    }
}
