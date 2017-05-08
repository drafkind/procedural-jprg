package com.rafkind.rogue1.gamedata;

import asciiPanel.AsciiPanel;

public class GameMap {
    private final String id;
    private final Tile[] tiles;
    private final int[] tileMapData;
    private final int mapWidth;
    private final int mapHeight;

    public GameMap(
            final String id,
            final Tile[] tiles,
            final int[] tileMapData,
            final int mapWidth,
            final int mapHeight) {
        this.id = id;
        this.tiles = tiles;
        this.tileMapData = tileMapData;
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
    }

    public void draw(AsciiPanel asciiPanel, int centerX, int centerY) {
        int maxX = asciiPanel.getWidthInCharacters();
        int maxY = asciiPanel.getHeightInCharacters();
        for (int y = 0; y < maxY; y++) {
            for (int x = 0; x < maxX; x++) {
                int mapX = x + centerX - maxX/2;
                int mapY = y + centerY - maxY/2;
                Tile tile = getTileAt(mapX, mapY);
                asciiPanel.write(tile.getCharacter(), x, y, tile.getForeground(), tile.getBackground());
            }
        }
    }

    public Tile getTileAt(int x, int y) {
        if (x < 0 || x >= mapWidth || y < 0 || y >= mapWidth) {
            return tiles[0];
        } else {
            return tiles[y * mapWidth + x];
        }
    }
}
