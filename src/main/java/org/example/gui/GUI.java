package org.example.gui;

import org.example.model.Position;

import java.io.IOException;

public interface GUI {

    GUI_ACTION getKeyboardAction() throws IOException;

    //GUI_ACTION getMouseAction() throws IOException;

    void drawPlayer(Position position);

    void drawHeroHealth(Position position, int health);
    void drawHeroScore(Position position, int score);

    void drawWall(Position position);

    void drawEnemy(Position position);

    void drawNPC(Position position);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    void drawProjectile(Position position);

    void drawText(Position position, String menu, String s);

    void drawHealthRegen(Position position);

    enum GUI_ACTION {
        UP,
        RIGHT,
        DOWN,
        LEFT,
        NONE,
        FIRE,
        QUIT,
        ARROW_LEFT,
        ARROW_RIGHT,
        ARROW_DOWN,
        ARROW_UP,
        SELECT
        //To be expanded later
    }

}
