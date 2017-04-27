package com.rafkind.rogue1;

import asciiPanel.AsciiPanel;

import java.awt.event.KeyListener;

public interface Controller extends KeyListener {
    GameStateTransition control(AsciiPanel screen, int tick, GameState gameState);
}
