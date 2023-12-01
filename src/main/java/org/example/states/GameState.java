package org.example.states;

import org.example.controllers.ArenaController;
import org.example.controllers.Controller;
import org.example.model.arena.Arena;
import org.example.viewers.GameViewer;
import org.example.viewers.Viewer;

public class GameState extends State<Arena>{
    public GameState(Arena arena) {
        super(arena);
    }

    @Override
    protected Viewer<Arena> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Arena> getController() {
        return new ArenaController(getModel());
    }
}
