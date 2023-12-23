package org.example.controllers;

import org.example.controllers.entity.EnemyController;
import org.example.controllers.entity.PlayerController;
import org.example.model.Position;
import org.example.model.arena.Arena;
import org.example.model.entities.Enemy;
import org.example.model.entities.Player;
import org.example.model.entities.Projectile;
import org.example.model.entities.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class EnemyControllerTest {

    private EnemyController controller;

    private Player player;

    private Enemy enemy;

    private Arena arena;

    @BeforeEach
    public void setUp() {
        arena = new Arena(10, 10);

        player = new Player(6, 5, 100, 0);

        arena.setPlayer(player);

        enemy = new Enemy(5, 5, 100);

        arena.setEnemyList(Arrays.asList(enemy));

        controller = new EnemyController(arena);
    }

    @Test
    public void testMoveEnemy() {
        controller.moveEnemy(enemy, new Position(6, 6));

        assertNotEquals(new Position(5, 5), enemy.getPosition());
    }

    @Test
    public void testEnemyCollideWall() {
        arena.setWallList(Arrays.asList(new Wall(6, 5), new Wall(5, 6), new Wall(4, 5), new Wall(5, 4)));

        controller.moveEnemy(enemy, new Position(6, 5));
        assertEquals(new Position(5, 5), enemy.getPosition());

        controller.moveEnemy(enemy, new Position(5, 6));
        assertEquals(new Position(5, 5), enemy.getPosition());

        controller.moveEnemy(enemy, new Position(4, 5));
        assertEquals(new Position(5, 5), enemy.getPosition());

        controller.moveEnemy(enemy, new Position(5, 4));
        assertEquals(new Position(5, 5), enemy.getPosition());
    }

    @Test
    public void testEnemyCollideEnemy() {
        Enemy enemy2 = new Enemy(6, 5, 100);
        Enemy enemy3 = new Enemy(5, 6, 100);
        Enemy enemy4 = new Enemy(4, 5, 100);
        Enemy enemy5 = new Enemy(5, 4, 100);

        arena.setEnemyList(Arrays.asList(enemy, enemy2, enemy3, enemy4, enemy5));

        controller.moveEnemy(enemy, new Position(6, 5));
        assertEquals(new Position(5, 5), enemy.getPosition());

        controller.moveEnemy(enemy, new Position(5, 6));
        assertEquals(new Position(5, 5), enemy.getPosition());

        controller.moveEnemy(enemy, new Position(4, 5));
        assertEquals(new Position(5, 5), enemy.getPosition());

        controller.moveEnemy(enemy, new Position(5, 4));
        assertEquals(new Position(5, 5), enemy.getPosition());
    }

    @Test
    public void testEnemyCollidePlayer() {
        controller.moveEnemy(enemy, new Position(6, 5));
        assertEquals(new Position(5, 5), enemy.getPosition());

        player.setPosition(new Position(5, 6));
        controller.moveEnemy(enemy, new Position(5, 6));
        assertEquals(new Position(5, 5), enemy.getPosition());

        player.setPosition(new Position(4, 5));
        controller.moveEnemy(enemy, new Position(4, 5));
        assertEquals(new Position(5, 5), enemy.getPosition());

        player.setPosition(new Position(5, 4));
        controller.moveEnemy(enemy, new Position(5, 4));
        assertEquals(new Position(5, 5), enemy.getPosition());
    }

    @Test
    public void testEnemyDetectsPlayer() {
        enemy = new Enemy(10, 10, 100);

        arena.setEnemyList(Arrays.asList(enemy));


        //Player positions within a 5 block radius of the enemy

        player.setPosition(new Position(10, 11));
        assertTrue(controller.detectsPlayer(enemy));

        player.setPosition(new Position(8, 10));
        assertTrue(controller.detectsPlayer(enemy));

        player.setPosition(new Position(10, 7));
        assertTrue(controller.detectsPlayer(enemy));

        player.setPosition(new Position(6, 10));
        assertTrue(controller.detectsPlayer(enemy));


        //Player positions outside a 5 block radius of the enemy

        player.setPosition(new Position(4, 10));
        assertFalse(controller.detectsPlayer(enemy));

        player.setPosition(new Position(10, 3));
        assertFalse(controller.detectsPlayer(enemy));

        player.setPosition(new Position(16, 10));
        assertFalse(controller.detectsPlayer(enemy));

        player.setPosition(new Position(10, 17));
        assertFalse(controller.detectsPlayer(enemy));
    }

    @Test
    public void testDamageEnemy() {
        int newEnemyHealth;

        enemy = new Enemy(10, 10, 100);

        arena.setEnemyList(Arrays.asList(enemy));

        Projectile projectile1 = new Projectile(10, 10, 10, new Position(10, 10));
        Projectile projectile2 = new Projectile(10, 10, 10, new Position(9, 10));
        Projectile projectile3 = new Projectile(10, 10, 10, new Position(10, 9));
        Projectile projectile4 = new Projectile(10, 10, 10, new Position(11, 10));
        Projectile projectile5 = new Projectile(10, 10, 10, new Position(10, 11));

        arena.addProjectile(projectile1);
        newEnemyHealth = enemy.getHealth() - projectile1.getDamage();
        controller.damageEnemies();
        arena.removeProjectile(projectile1);
        assertEquals(newEnemyHealth, enemy.getHealth());

        arena.addProjectile(projectile2);
        newEnemyHealth = newEnemyHealth - projectile2.getDamage();
        controller.damageEnemies();
        arena.removeProjectile(projectile2);
        assertEquals(newEnemyHealth, enemy.getHealth());

        arena.addProjectile(projectile3);
        newEnemyHealth = newEnemyHealth - projectile3.getDamage();
        controller.damageEnemies();
        arena.removeProjectile(projectile3);
        assertEquals(newEnemyHealth, enemy.getHealth());

        arena.addProjectile(projectile4);
        newEnemyHealth = newEnemyHealth - projectile4.getDamage();
        controller.damageEnemies();
        arena.removeProjectile(projectile4);
        assertEquals(newEnemyHealth, enemy.getHealth());

        arena.addProjectile(projectile5);
        newEnemyHealth = newEnemyHealth - projectile5.getDamage();
        controller.damageEnemies();
        arena.removeProjectile(projectile5);
        assertEquals(newEnemyHealth, enemy.getHealth());
    }

    @Test
    public void testDamagePlayer() {
        int newPlayerHealth;

        enemy = new Enemy(7, 5, 100);

        arena.setEnemyList(Arrays.asList(enemy));

        newPlayerHealth = player.getHealth() - 10;

        controller.damagePlayer(enemy, 10);

        assertEquals(newPlayerHealth, player.getHealth());
    }
}
