package org.example.model;

import org.example.model.arena.Arena;
import org.example.model.entities.Enemy;
import org.example.model.entities.Player;
import org.example.model.entities.Projectile;
import org.example.model.entities.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArenaTest {
    private Arena arena;

    @BeforeEach
    public void setArena() {
        arena = new Arena(10, 10);
    }

    @Test
    public void testIsEmpty() {
        arena.setEnemyList(Arrays.asList(new Enemy(5, 5, 100)));
        arena.setWallList(Arrays.asList(new Wall(6, 6)));
        arena.addProjectile(new Projectile(7, 7, 0, new Position(7, 7)));
        arena.setPlayer(new Player(8, 8, 100, 0));

        assertTrue(arena.isEmpty(new Position(0, 0)));

        assertFalse(arena.isEmpty(new Position(5, 5)));
        assertFalse(arena.isEmpty(new Position(6, 6)));
        assertFalse(arena.isEmpty(new Position(7, 7)));
        assertFalse(arena.isEmpty(new Position(8, 8)));

        assertTrue(arena.isEmpty(new Position(9, 9)));
    }
}
