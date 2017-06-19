package com.rafkind.rogue1;

import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public interface Controller {
    GameStateTransition control(AsciiPanel screen, int tick, GameState gameState);

    void keyTyped(KeyEvent keyEvent, GameState gameState);

    void keyPressed(KeyEvent keyEvent, GameState gameState);

    void keyReleased(KeyEvent keyEvent, GameState gameState);
}
