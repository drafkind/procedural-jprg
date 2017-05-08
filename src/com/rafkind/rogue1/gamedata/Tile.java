package com.rafkind.rogue1.gamedata;

import java.awt.*;

public class Tile {
    private char character;
    private Color background;
    private Color foreground;

    public Tile(char character, Color background, Color foreground) {
        this.character = character;
        this.background = background;
        this.foreground = foreground;
    }

    public char getCharacter() {
        return character;
    }

    public Color getBackground() {
        return background;
    }

    public Color getForeground() {
        return foreground;
    }
}
