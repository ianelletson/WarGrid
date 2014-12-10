package com.nineeyes.wargrid.entities;

import squidpony.squidcolor.SColor;

import java.util.LinkedList;

/**
 * com.nineeyes.wargrid.entities
 */
public class Player extends Actor {
    public Player(String name) {
        setName(name);
        setID(1); // TODO make a document with all IDs that this reads from
        setLevel(1); // TODO make a place for default levels, health, etc
        setExpCap(10); // TODO sensible exp cap
        setHealth(10);
        setInventory(new PlayerInventory());
        setColor(SColor.FOREST_GREEN); // TODO pick a player color, set it somewhere (options file?)
        setHand(null);
        setDecks(new LinkedList<Deck>());
    }

    @Override
    public void levelUp(int levels) {
        modifyLevel(levels);
        modifyExpCap(2); // TODO something relevant to growth here
    }
}
