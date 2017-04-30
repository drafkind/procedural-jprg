package com.rafkind.rogue1;

import asciiPanel.AsciiPanel;

public class GameMap {
    private Tile[] tiles;
    private int[] tileMapData;
    private int mapWidth;
    private int mapHeight;

    public GameMap() {
        //tiles = Arrays.of();
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
