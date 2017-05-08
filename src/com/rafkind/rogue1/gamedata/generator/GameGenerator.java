package com.rafkind.rogue1.gamedata.generator;

import com.google.common.collect.ImmutableMap;
import com.rafkind.rogue1.gamedata.GameMap;
import com.rafkind.rogue1.gamedata.GameWorld;
import com.rafkind.rogue1.gamedata.Tile;
import com.rafkind.rogue1.gamedata.description.GameDescription;

/**
 * Created by dave on 5/7/2017.
 */
public class GameGenerator {

    public GameWorld generateFrom(GameDescription gameDescription) {
        return new GameWorld(
            ImmutableMap.of(
                "start",
                new GameMap(
                    "start",
                        new Tile[]{ },
                    new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    3,
                    3
                )),
            "start");
    }
}
