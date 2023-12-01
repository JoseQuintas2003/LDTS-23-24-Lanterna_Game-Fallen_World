package org.example.controllers;

import org.example.Game;
import org.example.gui.GUI;

import java.io.IOException;

public abstract class Controller<T> {
    private final T model;

    public Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void step(Game game, GUI.GUI_ACTION action, long time) throws IOException;
}
