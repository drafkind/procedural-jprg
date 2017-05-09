package com.rafkind.rogue1;

import asciiPanel.AsciiPanel;
import com.rafkind.rogue1.gamedata.GameMap;

import java.awt.event.KeyEvent;

/**
 * Created by dave on 5/8/2017.
 */
public class MapController implements Controller {

    private GameMap currentMap;

    private int cameraX;
    private int cameraY;

    public void setCurrentMap(GameMap currentMap) {
        this.currentMap = currentMap;
        cameraX = currentMap.getMapWidth() / 2;
        cameraY = currentMap.getMapHeight() / 2;
    }

    @Override
    public GameStateTransition control(AsciiPanel screen, int tick, GameState gameState) {
        currentMap.draw(screen, cameraX, cameraY);
        return null;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("keyTyped " + e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("keyPressed " + e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("keyReleased " + e);
    }
}
