package com.rafkind.rogue1.gamedata.description;

import java.util.Collection;

/**
 * Created by dave on 5/6/2017.
 */
public class GameMapDescription {
    private int width;
    private int height;
    private String id;
    private Collection<GameTriggerDescription> triggers;
    private Collection<GameNpcDescription> npcs;
}
