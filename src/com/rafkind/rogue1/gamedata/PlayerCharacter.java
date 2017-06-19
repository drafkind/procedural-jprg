package com.rafkind.rogue1.gamedata;

import java.awt.*;

/**
 * Created by dave on 5/7/2017.
 */
public class PlayerCharacter {
    private Character character;
    private Color foreground;
    private Color background;

    public PlayerCharacter(Character character, Color foreground, Color background) {
        this.character = character;
        this.foreground = foreground;
        this.background = background;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Color getForeground() {
        return foreground;
    }

    public void setForeground(Color foreground) {
        this.foreground = foreground;
    }

    public Color getBackground() {
        return background;
    }

    public void setBackground(Color background) {
        this.background = background;
    }
}
