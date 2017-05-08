package com.rafkind.rogue1.gamedata;

import java.util.Map;

/**
 * Created by dave on 4/22/17.
 */
public class GameWorld {
    private final Map<String, GameMap> maps;
    private final String startMap;

    public GameWorld(
            final Map<String, GameMap> maps,
            final String startMap) {
        this.maps = maps;
        this.startMap = startMap;
    }

    public GameMap getMap(final String id) {
        return maps.get(id);
    }

    public String getStartMap() {
        return startMap;
    }
}
