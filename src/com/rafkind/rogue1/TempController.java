package com.rafkind.rogue1;

import asciiPanel.AsciiPanel;

public class TempController implements Controller {
    @Override
    public GameStateTransition control(AsciiPanel screen, int tick, GameState gameState) {
        for (int j = 0; j < 25; j++) {
            for (int i = 0; i < 40; i++) {
                float h = (i + j) / 80f;
                char c = (char) (((tick + i + (j * 80)) & 255));
                screen.write(c, i, j, Colors.COLORS[(int) (c & 15)], Colors.COLORS[(int) ((c >> 4) & 15)]);
                //asciiPanel.write(c, i, j, Color.getHSBColor(h, 0.5f, 1.0f), Color.BLACK);
            }
        }

        return null;
    }
}
