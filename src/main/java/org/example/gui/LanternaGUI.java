package org.example.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.input.MouseAction;
import com.googlecode.lanterna.input.MouseActionType;
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
import java.util.Arrays;

public class LanternaGUI implements GUI{

    private final Screen screen;

    //Default Constructor
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
            case ArrowUp -> GUI_ACTION.UP;
            case ArrowDown -> GUI_ACTION.DOWN;
            case ArrowLeft -> GUI_ACTION.LEFT;
            case ArrowRight -> GUI_ACTION.RIGHT;

            case Character -> switch (keyStroke.getCharacter()) {
                case 'q' -> GUI_ACTION.QUIT;
                case 'f' -> GUI_ACTION.FIRE;
                case 'w' -> GUI_ACTION.UP;
                case 'a' -> GUI_ACTION.LEFT;
                case 's' -> GUI_ACTION.DOWN;
                case 'd' -> GUI_ACTION.RIGHT;
                default -> GUI_ACTION.NONE;
            };

            default -> GUI_ACTION.NONE;
        };
    }

    /* Isto não funciona, mas tratamos de meter o rato a funcionar depois

    public GUI_ACTION getMouseAction() throws IOException {
        MouseAction mouseAction = (MouseAction) screen.pollInput();

        if (mouseAction == null) return GUI_ACTION.NONE;

        return switch (mouseAction.getActionType()) {
            case CLICK_DOWN -> GUI_ACTION.FIRE;
            case CLICK_RELEASE -> GUI_ACTION.NONE;
            default -> GUI_ACTION.NONE;
        };
    }
    */

    private void drawCharacter(int x, int y, char c, String color) throws IOException {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(x, y + 1, "" + c);
        refresh();
    }

    @Override
    public void drawHero(Position position) throws IOException {
        drawCharacter(position.getX(), position.getY(), 'H', "#FFD700");
    }

    @Override
    public void drawWall(Position position) throws IOException {
        drawCharacter(position.getX(), position.getY(), '#', "#3333FF");
    }

    @Override
    public void drawEnemy(Position position) throws IOException {
        drawCharacter(position.getX(), position.getY(), '!', "#D32500");
    }

    @Override
    public void drawNPC(Position position) throws IOException {
        drawCharacter(position.getX(), position.getY(), '?', "#17BD00");
    }

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