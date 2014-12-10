package com.nineeyes.wargrid.entities;

/**
 * com.nineeyes.wargrid.entities
 */
public class Dummy extends Enemy {
    public Dummy() {
        setName("Dummy");
        setID(2);
        setHealth(10);
        setExperience(5); // TODO set Enemy exp values
    }

    @Override
    public Hand drawHand() {
        return null;
    }
}
