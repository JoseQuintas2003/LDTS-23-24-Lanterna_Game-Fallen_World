package org.example.gui;

import org.example.model.Position;

import java.io.IOException;

public interface GUI {

    GUI_ACTION getKeyboardAction() throws IOException;

    void drawPlayer(Position position);

    void drawHeroHealth(int health);

    void drawHeroScore(int score);

    void drawBullets(int currentBullets, int maxBullets);

    void drawCurrentWeapon(String currentWeapon);

    void drawWeapon(Position position, String weapon);

    void drawWall(Position position);

    void drawEnemy(Position position);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    void drawProjectile(Position position);

    void drawText(Position position, String menu, String s);

    void drawHealthRegen(Position position);

    void drawHealthBoost(Position position);

    void drawSpeedBoost(Position position);

    enum GUI_ACTION {
        UP,
        RIGHT,
        DOWN,
        LEFT,
        NONE,
        FIRE,
        RELOAD,
        QUIT,
        ARROW_LEFT,
        ARROW_RIGHT,
        ARROW_DOWN,
        ARROW_UP,
        SELECT
    }

}
