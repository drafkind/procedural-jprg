package com.rafkind.rogue1.gamedata;


import asciiPanel.AsciiPanel;
import com.rafkind.rogue1.Camera;

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

    public void drawOnMap(AsciiPanel asciiPanel, Camera camera) {
        PlayerCharacter playerCharacter = playerCharacters.get(0);

        asciiPanel.write(
                playerCharacter.getCharacter(),
                location.x - camera.getUpperLeft().x,
                location.y - camera.getUpperLeft().y,
                playerCharacter.getForeground(),
                playerCharacter.getBackground());
    }
}
