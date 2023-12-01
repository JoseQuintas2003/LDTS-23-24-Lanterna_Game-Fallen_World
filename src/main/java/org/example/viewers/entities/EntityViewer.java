package org.example.viewers.entities;

import org.example.gui.GUI;
import org.example.model.entities.Entity;

public interface EntityViewer<T extends Entity> {

    public void draw(T element, GUI gui);
}
