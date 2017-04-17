package com.rafkind.rogue1;

import asciiPanel.AsciiPanel;

public interface Controller {
    GameStateTransition control(AsciiPanel screen, int tick, GameState gameState);
}
