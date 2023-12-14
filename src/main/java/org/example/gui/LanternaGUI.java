package org.example.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import org.example.model.Position;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class LanternaGUI implements GUI{

    private final Screen screen;

    public LanternaGUI(Screen screen) {
        this.screen = screen;
    }

    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfiguration) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height + 1);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfiguration);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private AWTTerminalFontConfiguration loadFont() throws URISyntaxException, FontFormatException, IOException { //Adicionar depois
        URL resource = getClass().getClassLoader().getResource("fonts/square.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 25);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }

    public LanternaGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        AWTTerminalFontConfiguration fontConfig = loadFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        this.screen = createScreen(terminal);
    }
    public GUI_ACTION getKeyboardAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();

        if (keyStroke == null) return GUI_ACTION.NONE;

        return switch (keyStroke.getKeyType()) {
            case ArrowUp -> GUI_ACTION.ARROW_UP;
            case ArrowDown -> GUI_ACTION.ARROW_DOWN;
            case ArrowLeft -> GUI_ACTION.ARROW_LEFT;
            case ArrowRight -> GUI_ACTION.ARROW_RIGHT;
            case Enter -> GUI_ACTION.SELECT;

            case Character -> switch (keyStroke.getCharacter()) {
                case 'q' -> GUI_ACTION.QUIT;
                case 'f' -> GUI_ACTION.FIRE;
                case 'r' -> GUI_ACTION.RELOAD;
                case 'w' -> GUI_ACTION.UP;
                case 'a' -> GUI_ACTION.LEFT;
                case 's' -> GUI_ACTION.DOWN;
                case 'd' -> GUI_ACTION.RIGHT;
                default -> GUI_ACTION.NONE;
            };

            default -> GUI_ACTION.NONE;
        };
    }

    private void drawCharacter(int x, int y, char c, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(x, y + 1, "" + c);
    }

    @Override
    public void drawPlayer(Position position) {
        drawCharacter(position.getX(), position.getY(), '@', "#FFD700");
    }

    @Override
    public void drawHeroHealth(int health) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString("#FF0000"));
        tg.putString(0, 1, "HP");
        tg.setForegroundColor(TextColor.Factory.fromString("#FF0000"));
        tg.putString(2, 1, ":" + health);
    }

    @Override
    public void drawHeroScore(int score) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString("#FF0000"));
        tg.putString(0, 3, "Score");
        tg.setForegroundColor(TextColor.Factory.fromString("#FF0000"));
        tg.putString(5, 3, ":" + score);
    }

    @Override
    public void drawBullets(int currentBullets, int maxBullets) {
        String numBullets = currentBullets + "/" + maxBullets;

        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString("#FF0000"));
        tg.putString(46 - numBullets.length() , 1, "Bullets:");
        tg.setForegroundColor(TextColor.Factory.fromString("#FF0000"));
        tg.putString(54 - numBullets.length(), 1, numBullets);
    }

    @Override
    public void drawCurrentWeapon(String currentWeapon) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString("#FF0000"));
        tg.putString(47 - currentWeapon.length(), 3, "Weapon");
        tg.setForegroundColor(TextColor.Factory.fromString("#FF0000"));
        tg.putString(53 - currentWeapon.length(), 3, ":" + currentWeapon);
    }

    public void drawWeapon(Position position, String weapon) {
        if (weapon.equals("Assault Rifle")) drawCharacter(position.getX(), position.getY(), 'A', "#47008A");
        else if (weapon.equals("Machine Gun")) drawCharacter(position.getX(), position.getY(), 'M', "#47008A");
        else if (weapon.equals("Rocket Launcher")) drawCharacter(position.getX(), position.getY(), 'R', "#47008A");
    }

    @Override
    public void drawWall(Position position) {
        drawCharacter(position.getX(), position.getY(), '#', "#3333FF");
    }

    @Override
    public void drawEnemy(Position position) {
        drawCharacter(position.getX(), position.getY(), '!', "#D32500");
    }

    @Override
    public void drawProjectile(Position position) {
        drawCharacter(position.getX(), position.getY(), '*', "#D32500");
    }

    public void drawText(Position position, String menu, String s) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(s));
        tg.putString(position.getX(), position.getY() + 1, menu);
    }

    @Override
    public void drawHealthRegen(Position position) {
        drawCharacter(position.getX(), position.getY(), '+', "#FF00FF");
    }

    @Override
    public void drawHealthBoost(Position position) { drawCharacter(position.getX(), position.getY(), 'H', "#FF00FF"); }

    @Override
    public void drawSpeedBoost(Position position) { drawCharacter(position.getX(), position.getY(), 'S', "#FF00FF"); }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }
}
