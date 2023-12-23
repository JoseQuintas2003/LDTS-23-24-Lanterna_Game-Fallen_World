package org.example.controllers;

import org.example.controllers.entity.PlayerController;
import org.example.model.Position;
import org.example.model.arena.Arena;
import org.example.model.entities.Enemy;
import org.example.model.entities.Player;
import org.example.model.entities.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerControllerTest {

    private PlayerController controller;

    private Player player;

    private Arena arena;

    @BeforeEach
    public void setUp() {
        arena = new Arena(10, 10);

        player = new Player(5, 5, 100, 0);

        arena.setPlayer(player);

        arena.setWallList(Arrays.asList());
        arena.setEnemyList(Arrays.asList());

        controller = new PlayerController(arena);
    }

    @Test
    public void testMovePlayerEmpty() {
        controller.movePlayerRight();
        assertEquals(new Position(6, 5), player.getPosition());

        player.setPosition(new Position(5, 5));

        controller.movePlayerLeft();
        assertEquals(new Position(4, 5), player.getPosition());

        player.setPosition(new Position(5, 5));

        controller.movePlayerUp();
        assertEquals(new Position(5, 4), player.getPosition());

        player.setPosition(new Position(5, 5));

        controller.movePlayerDown();
        assertEquals(new Position(5, 6), player.getPosition());
    }

    @Test
    public void testPlayerCollideWalls() {
        arena.setWallList(Arrays.asList(new Wall(6, 5), new Wall(4, 5), new Wall(5, 4), new Wall(5, 6)));

        controller.movePlayerRight();
        assertEquals(new Position(5, 5), player.getPosition());

        controller.movePlayerLeft();
        assertEquals(new Position(5, 5), player.getPosition());

        controller.movePlayerUp();
        assertEquals(new Position(5, 5), player.getPosition());

        controller.movePlayerDown();
        assertEquals(new Position(5, 5), player.getPosition());
    }

    @Test
    public void testPlayerCollideEnemies() {
        arena.setEnemyList(Arrays.asList(new Enemy(6, 5, 10), new Enemy(4, 5, 10), new Enemy(5, 4, 10), new Enemy(5, 6, 10)));

        controller.movePlayerRight();
        assertEquals(new Position(5, 5), player.getPosition());


        controller.movePlayerLeft();
        assertEquals(new Position(5, 5), player.getPosition());

        controller.movePlayerUp();
        assertEquals(new Position(5, 5), player.getPosition());

        controller.movePlayerDown();
        assertEquals(new Position(5, 5), player.getPosition());
    }
}
