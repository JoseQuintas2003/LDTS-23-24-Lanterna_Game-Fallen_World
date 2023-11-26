package org.example.gui;

import org.example.model.Position;

import java.awt.*;
import java.io.IOException;

public interface GUI {

    GUI_ACTION getKeyboardAction() throws IOException;

    //GUI_ACTION getMouseAction() throws IOException;

    void drawHero(Position position);

    void drawWall(Position position);

    void drawEnemy(Position position);

    void drawNPC(Position position);

    void clear();

    void refresh();

    void close();

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
