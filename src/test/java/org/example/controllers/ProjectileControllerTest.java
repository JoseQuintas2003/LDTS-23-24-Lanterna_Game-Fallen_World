package org.example.controllers;

import org.example.controllers.entity.ProjectileController;
import org.example.gui.GUI;
import org.example.model.arena.Arena;
import org.example.model.entities.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ProjectileControllerTest {
    private ProjectileController controller;

    private Arena arena;

    private Player player;

    @BeforeEach
    public void setUp() {
        arena = new Arena(10, 10);

        player = new Player(5, 5, 100, 0);
        arena.setPlayer(player);

        arena.setWallList(Arrays.asList());
        arena.setEnemyList(Arrays.asList());

        controller = new ProjectileController(arena);
    }

    @Test
    public void testCreateProjectile() {
        controller.createProjectile(GUI.GUI_ACTION.ARROW_DOWN);

        assertEquals(1, arena.getProjectileList().size());


        controller.createProjectile(GUI.GUI_ACTION.ARROW_UP);

        assertEquals(2, arena.getProjectileList().size());


        controller.createProjectile(GUI.GUI_ACTION.ARROW_LEFT);

        assertEquals(3, arena.getProjectileList().size());


        controller.createProjectile(GUI.GUI_ACTION.ARROW_RIGHT);

        assertEquals(4, arena.getProjectileList().size());
    }
}
