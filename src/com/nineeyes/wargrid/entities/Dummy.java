package com.nineeyes.wargrid.entities;

import squidpony.squidcolor.SColor;

/**
 * com.nineeyes.wargrid.entities
 */
public class Dummy extends Enemy {
    public Dummy() {
        setName("Dummy");
        setID(2);
        setHealth(10);
        setInventory(new EnemyInventory());
        setExperience(5); // TODO set Enemy exp values
        setColor(SColor.ALIZARIN); // TODO pick enemy colors
    }

    @Override
    public Hand drawHand() {
        return null;
    }
}
