package com.rafkind.rogue1;

import com.rafkind.rogue1.gamedata.PlayerCharacterGroup;

public class GameState {
    private PlayerCharacterGroup playerCharacterGroup;

    public GameState(PlayerCharacterGroup playerCharacterGroup) {
        this.playerCharacterGroup = playerCharacterGroup;
    }

    public PlayerCharacterGroup getPlayerCharacterGroup() {
        return playerCharacterGroup;
    }
}
