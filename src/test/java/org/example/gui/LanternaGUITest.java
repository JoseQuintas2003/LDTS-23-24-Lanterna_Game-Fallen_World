package org.example.gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;
import org.example.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;


public class LanternaGUITest {

    private Screen screen;

    private TextGraphics tg;
    private LanternaGUI gui;


    @BeforeEach
    public void setUp() {
        tg = Mockito.mock(TextGraphics.class);
        screen = Mockito.mock(Screen.class);

        Mockito.when(screen.newTextGraphics()).thenReturn(tg);

        gui = new LanternaGUI(screen);
    }

    @Test
    public void testInitialize() {
        assertNotNull(gui);
    }

    @Test
    public void testDrawHero() {
        gui.drawPlayer(new Position(1, 1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 215, 0));
    }

    @Test
    public void testDrawEnemy() {
        gui.drawEnemy(new Position(2, 2));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(211, 37, 0));
    }

    @Test
    public void testDrawWall() {
        gui.drawWall(new Position(3, 3));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(51, 51, 255));
    }

    @Test
    public void testDrawProjectile() {
        gui.drawProjectile(new Position(4, 4));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(211, 37, 0));
    }

    @Test
    public void testDrawPowerup() {
        gui.drawHealthBoost(new Position(5, 5));
        gui.drawHealthRegen(new Position(6, 6));
        gui.drawSpeedBoost(new Position(7, 7));

        Mockito.verify(tg, Mockito.times(3)).setForegroundColor(new TextColor.RGB(255, 0, 255));

    }

    @Test
    public void testDrawWeapon() {
        gui.drawWeapon(new Position(8, 8), "Assault Rifle");
        gui.drawWeapon(new Position(9, 9), "Machine Gun");
        gui.drawWeapon(new Position(10, 10), "Rocket Launcher");

        Mockito.verify(tg, Mockito.times(3)).setForegroundColor(new TextColor.RGB(71, 0, 138));
    }

    @Test
    public void testDrawText() {
        gui.drawText(new Position(11, 11), "Hello World", "#336699");

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(51, 102, 153));
    }
}
