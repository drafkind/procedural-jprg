package com.rafkind.rogue1.gamedata;


import asciiPanel.AsciiPanel;

import java.awt.Point;
import java.util.List;

/**
 * Created by dave on 5/7/2017.
 */
public class PlayerCharacterGroup {

    private List<PlayerCharacter> playerCharacters;

    private Point location;

    private GameMap gameMap;

    public PlayerCharacterGroup(List<PlayerCharacter> playerCharacters, Point location, GameMap gameMap) {
        this.playerCharacters = playerCharacters;
        this.location = location;
        this.gameMap = gameMap;
    }

    public List<PlayerCharacter> getPlayerCharacters() {
        return playerCharacters;
    }

    public void setPlayerCharacters(List<PlayerCharacter> playerCharacters) {
        this.playerCharacters = playerCharacters;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public void setGameMap(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    public void drawOnMap(AsciiPanel asciiPanel, int centerX, int centerY) {
        int maxX = asciiPanel.getWidthInCharacters();
        int maxY = asciiPanel.getHeightInCharacters();
        int mapX = location.x + centerX - (maxX/2);
        int mapY = location.y + centerY - (maxY/2);
        PlayerCharacter playerCharacter = playerCharacters.get(0);

        asciiPanel.write(
                playerCharacter.getCharacter(),
                mapX,
                mapY,
                playerCharacter.getForeground(),
                playerCharacter.getBackground());
    }
}
