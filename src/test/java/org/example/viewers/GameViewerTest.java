package org.example.viewers;

import org.example.gui.LanternaGUI;
import org.example.model.Position;
import org.example.model.arena.Arena;
import org.example.model.entities.*;
import org.example.model.entities.powerups.Powerup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

public class GameViewerTest {
    private LanternaGUI gui;

    private GameViewer gameViewer;

    private Arena arena;

    @BeforeEach
    public void setUp() throws IOException, URISyntaxException, FontFormatException {
        gui = Mockito.mock(LanternaGUI.class);
        arena = new Arena(10, 10);
        gameViewer = new GameViewer(arena);

        arena.setWallList(Arrays.asList(new Wall(1, 1), new Wall(2, 2), new Wall(3, 3)));
        arena.setEnemyList(Arrays.asList(new Enemy(4, 4, 100), new Enemy(5, 5, 100)));
        arena.setPlayer(new Player(6, 6, 100, 0));
        arena.addProjectile(new Projectile(7, 7, 0, new Position(10, 10)));
        arena.addWeapon(new Weapon(8, 8, 0, 0, "a"));
    }

    @Test
    public void drawWalls() throws IOException {
        gameViewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(1, 1));
        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(2, 2));
        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(3, 3));
        Mockito.verify(gui, Mockito.times(3)).drawWall(Mockito.any(Position.class));
    }

    @Test
    public void drawEnemies() throws IOException {
        gameViewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawEnemy(new Position(4, 4));
        Mockito.verify(gui, Mockito.times(1)).drawEnemy(new Position(5, 5));
        Mockito.verify(gui, Mockito.times(2)).drawEnemy(Mockito.any(Position.class));
    }

    @Test
    public void drawPlayer() throws IOException {
        gameViewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawPlayer(new Position(6, 6));
        Mockito.verify(gui, Mockito.times(1)).drawPlayer(Mockito.any(Position.class));
    }

    @Test
    public void drawProjectiles() throws IOException {
        gameViewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawProjectile(new Position(7, 7));
        Mockito.verify(gui, Mockito.times(1)).drawProjectile(Mockito.any(Position.class));
    }

    @Test
    public void drawWeapon() throws IOException {
        gameViewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawWeapon(new Position(8, 8), "a");
        Mockito.verify(gui, Mockito.times(1)).drawWeapon(Mockito.any(Position.class), Mockito.anyString());
    }


}
