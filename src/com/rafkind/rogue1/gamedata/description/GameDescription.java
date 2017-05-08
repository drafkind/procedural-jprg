package com.rafkind.rogue1.gamedata.description;

import java.util.Collection;

/**
 * kill miniboss1 -> talk to king -> build bridge -> talk to pirate -> gith pirates -> get ship
 *
 * king dialog:
 *  if (miniboss dead) then
 *    at end of dialog tree, trigger bridge building
 *  else
 *    normal
 *
 * pirate dialog:
 *   at end of dialog tree, trigger pirate fight
 * if (pirates lose fight) then
 *   give boat
 *
 * zone
 *   place
 *
 *
 */
public class GameDescription {
    private Collection<GameMapDescription> mapDescriptions;
}
