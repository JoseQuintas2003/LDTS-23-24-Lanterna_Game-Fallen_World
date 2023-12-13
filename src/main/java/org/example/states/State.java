package org.example.states;

import org.example.Game;
import org.example.controllers.Controller;
import org.example.gui.GUI;
import org.example.viewers.Viewer;

import java.io.IOException;

public abstract class State<T> {
    private final T model;

    private final Viewer<T> viewer;

    private final Controller<T> controller;

    public State(T model) {
        this.model = model;
        this.viewer = getViewer();
        this.controller = getController();
    }

    public State(T model, int score) {
        this.model = model;
        this.viewer = getViewer(score);
        this.controller = getController();
    }

    protected abstract Viewer<T> getViewer();

    protected abstract Viewer<T> getViewer(int score);

    protected abstract Controller<T> getController();

    public T getModel() {
        return model;
    }

    public void step(Game game, GUI gui, long time) throws IOException {
        GUI.GUI_ACTION action = gui.getKeyboardAction();
        controller.step(game, action, time);
        viewer.draw(gui);
    }
}
