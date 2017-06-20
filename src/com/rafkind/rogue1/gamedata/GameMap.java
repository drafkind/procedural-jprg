package com.rafkind.rogue1.gamedata;

import asciiPanel.AsciiPanel;
import com.rafkind.rogue1.Camera;

import java.awt.*;

public class GameMap {
    private final String id;
    private final Tile[] tiles;
    private final int[] tileMapData;
    private final int mapWidth;
    private final int mapHeight;

    private final Point startLocation;

    public GameMap(
            final String id,
            final Tile[] tiles,
            final int[] tileMapData,
            final int mapWidth,
            final int mapHeight,
            final Point startLocation) {
        this.id = id;
        this.tiles = tiles;
        this.tileMapData = tileMapData;
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.startLocation = startLocation;
    }

    public void draw(AsciiPanel asciiPanel, Camera camera) {
        int maxX = asciiPanel.getWidthInCharacters();
        int maxY = asciiPanel.getHeightInCharacters();
        for (int y = 0; y < maxY; y++) {
            for (int x = 0; x < maxX; x++) {
                int mapX = x + camera.getUpperLeft().x;
                int mapY = y + camera.getUpperLeft().y;
                Tile tile = getTileAt(mapX, mapY);
                asciiPanel.write(tile.getCharacter(), x, y, tile.getForeground(), tile.getBackground());
            }
        }
    }

    public Tile getTileAt(int x, int y) {
        if (x < 0 || x >= mapWidth || y < 0 || y >= mapWidth) {
            return tiles[0];
        } else {
            return tiles[tileMapData[(y * mapWidth) + x]];
        }
    }

    public int getMapWidth() {
        return mapWidth;
    }

    public int getMapHeight() {
        return mapHeight;
    }

    public Point getStartLocation() {
        return startLocation;
    }
}
