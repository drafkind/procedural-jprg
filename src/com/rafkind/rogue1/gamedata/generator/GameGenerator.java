package com.rafkind.rogue1.gamedata.generator;

import com.google.common.collect.ImmutableMap;
import com.rafkind.rogue1.Colors;
import com.rafkind.rogue1.gamedata.GameMap;
import com.rafkind.rogue1.gamedata.GameWorld;
import com.rafkind.rogue1.gamedata.Tile;
import com.rafkind.rogue1.gamedata.description.GameDescription;
import sun.java2d.pipe.SpanShapeRenderer;

/**
 * Created by dave on 5/7/2017.
 */
public class GameGenerator {

    public GameWorld generateFrom(GameDescription gameDescription) {

        double[] heights = new double[100*100];
        for (int j = 0; j < 100; j++) {
            for (int i = 0; i < 100; i++) {
                double x = (double)(i/100.0) - 0.5;
                double y = (double)(j/100.0) - 0.5;
                heights[j*100+i] = SimplexNoise.noise(x, y);
            }
        }

        int[] terrains = new int[100*100];
        for (int j = 0; j < 100; j++) {
            for (int i = 0; i < 100; i++) {
                int index = j*100+i;
                terrains[index] = (heights[index] < 0.5) ? 0: 1;
            }
        }

        return new GameWorld(
            ImmutableMap.of(
                "start",
                new GameMap(
                    "start",
                        new Tile[]{
                            new Tile((char) 176, Colors.COLORS[10], Colors.COLORS[2]),
                            new Tile((char) 178, Colors.COLORS[9], Colors.COLORS[1])
                        },
                    //new int[]{0, 1, 0, 1, 0, 1, 0, 1, 0},
                        terrains,
                    100, 100
                )),
            "start");
    }
}
