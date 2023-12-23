package org.example.model;

import org.example.model.entities.Entity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntityTest {
    private Entity entity;

    @BeforeEach
    public void setUp() {
        entity = new Entity(0, 0, true, true, true);
    }

    @Test
    public void testCalculatePosition() {
        entity.setPosition(entity.calculatePosition(new Position(1, 1), 1));

        assertEquals(entity.getPosition().getX(), 1);


        entity.setPosition(entity.calculatePosition(new Position(1, 1), 1));

        assertEquals(entity.getPosition().getY(), 1);
    }
}
