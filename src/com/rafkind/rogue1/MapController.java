package com.rafkind.rogue1;

import asciiPanel.AsciiPanel;
import com.rafkind.rogue1.gamedata.GameMap;
import com.rafkind.rogue1.gamedata.PlayerCharacterGroup;

import java.awt.event.KeyEvent;

/**
 * Created by dave on 5/8/2017.
 */
public class MapController implements Controller {

    @Override
    public GameStateTransition control(AsciiPanel screen, int tick, GameState gameState) {
        PlayerCharacterGroup pcg = gameState.getPlayerCharacterGroup();
        GameMap currentMap = pcg.getGameMap();
        int cameraX = pcg.getLocation().x;
        int cameraY = pcg.getLocation().y;
        currentMap.draw(screen, cameraX, cameraY);
        pcg.drawOnMap(screen, cameraX, cameraY);
        return null;
    }

    @Override
    public void keyTyped(KeyEvent e, GameState gameState) {
    }

    @Override
    public void keyPressed(KeyEvent e, GameState gameState) {
        PlayerCharacterGroup pcg = gameState.getPlayerCharacterGroup();
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP: pcg.getLocation().translate(0, -1); break;
            case KeyEvent.VK_DOWN: pcg.getLocation().translate(0, 1); break;
            case KeyEvent.VK_LEFT: pcg.getLocation().translate(-1, 0); break;
            case KeyEvent.VK_RIGHT: pcg.getLocation().translate(1, 0); break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e, GameState gameState) {
    }
}
