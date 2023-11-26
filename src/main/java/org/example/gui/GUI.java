package org.example.gui;

import org.example.model.Position;

import java.awt.*;
import java.io.IOException;

public interface GUI {

    GUI_ACTION getKeyboardAction() throws IOException;

    //GUI_ACTION getMouseAction() throws IOException;

    void drawHero(Position position) throws IOException;

    void drawWall(Position position) throws IOException;

    void drawEnemy(Position position) throws IOException;

    void drawNPC(Position position) throws IOException;

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum GUI_ACTION {
        UP,
        RIGHT,
        DOWN,
        LEFT,
        NONE,
        FIRE,
        QUIT,
        //To be expanded later
    }

}
