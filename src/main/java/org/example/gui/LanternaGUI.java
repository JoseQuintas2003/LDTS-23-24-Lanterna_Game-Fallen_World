package org.example.gui;

import com.googlecode.lanterna.TerminalSize;
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
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

public class LanternaGUI implements GUI{

    private final Screen screen;

    //Default Constructor
    public LanternaGUI(Screen screen) {
        this.screen = screen;
    }

    private Terminal createTerminal(int width, int height) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height + 1);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
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
        return null;
    }

    public LanternaGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        //AWTTerminalFontConfiguration fontConfig = loadSquareFont(); Adicionar depois
        Terminal terminal = createTerminal(width, height);
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

    @Override
    public void drawHero(Position position) {

    }

    @Override
    public void drawWall(Position position) {

    }

    @Override
    public void drawEnemy(Position position) {

    }

    @Override
    public void drawNPC(Position position) {

    }

    @Override
    public void clear() {

    }

    @Override
    public void refresh() {

    }

    @Override
    public void close() {

    }
}
