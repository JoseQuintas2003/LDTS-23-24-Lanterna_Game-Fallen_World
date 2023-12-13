package org.example.model.menu;

import java.util.Arrays;
import java.util.List;

public class GameoverMenu {

    private List<Character> name;

    private int currentChar = 0;

    private int score;

    public GameoverMenu(int score) {
        this.currentChar = 0;
        this.name = Arrays.asList('A', 'A', 'A');
        this.score = score;
    }

    public List<Character> getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getCurrentChar() {
        return currentChar;
    }

    public void nextChar() {
        if (currentChar < name.size() - 1){
            currentChar++;
        }
        else {
            currentChar = 0;
        }
    }

    public void prevChar() {
        if (currentChar > 0){
            currentChar--;
        }
        else {
            currentChar = name.size() - 1;
        }
    }

    public void nextLetter() {
        if (name.get(currentChar) < 'Z'){
            name.set(currentChar, (char) (name.get(currentChar) + 1));
        }
        else {
            name.set(currentChar, 'A');
        }
    }

    public void prevLetter() {
        if (name.get(currentChar) > 'A'){
            name.set(currentChar, (char) (name.get(currentChar) - 1));
        }
        else {
            name.set(currentChar, 'Z');
        }
    }
}
