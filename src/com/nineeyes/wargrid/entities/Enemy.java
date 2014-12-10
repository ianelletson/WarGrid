package com.nineeyes.wargrid.entities;

/**
 * com.nineeyes.wargrid.entities
 * The enemy class from which all enemies will derive
 */
public abstract class Enemy extends Actor {
    private int experience;

    @Override
    public int getExperience() {
        return experience;
    }

    @Override
    public void setExperience(int experience) {
        this.experience = experience;
    }
}
