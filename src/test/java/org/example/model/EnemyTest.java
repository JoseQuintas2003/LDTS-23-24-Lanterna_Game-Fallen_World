package org.example.model;

import org.example.model.entities.Enemy;
import org.example.model.entities.Projectile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EnemyTest {
    private Enemy enemy;

    @BeforeEach
    public void setUp() {
        enemy = new Enemy(5, 5, 100);
    }

    @Test
    public void testProjectileHits() {
        Projectile projectile = new Projectile(4, 5, 0, new Position(10, 5));

        assertTrue(enemy.projectileHits(projectile.getPosition(), projectile.getFinalPosition()));
    }
}
