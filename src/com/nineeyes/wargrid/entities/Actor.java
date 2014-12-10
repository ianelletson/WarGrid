package com.nineeyes.wargrid.entities;

import squidpony.squidcolor.SColor;

import java.util.Collection;

/**
 * Created by ian on 11/30/14.
 * Actor class is abstract super class of all acting entities in the game e.g. player and enemy
 */
public abstract class Actor {
    private int ID;
    private int health, experience;
    private Inventory inventory;
    private Hand hand;
    private SColor color;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getID() {
        return ID;
    }

    protected void setID(int id) {
        ID = id;
    }

    public SColor getColor() {
        return color;
    }

    public void setColor(SColor color) {
        this.color = color;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0)
            throw new IllegalArgumentException("health cannot be negative");
        this.health = health;
    }

    public void addHealth(int health) {
        this.health += health;
    }

    public void subtractHealth(int health) {
        if (this.health - health > 0)
            this.health -= health;
        else
            this.health = 0;
    }

    public abstract int getExperience();

    public abstract void setExperience(int experience);


    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        if (inventory == null)
            throw new IllegalArgumentException("Cannot set inventory to be null");
        this.inventory = inventory;
    }

    public void addToInventory(Card card) {
        inventory.addCard(card);
    }

    public void addToInventory(Collection<Card> cards) {
        inventory.addCards(cards);
    }

    public void removeFromInventory(Card card) {
        inventory.removeCard(card);
    }

    public void removeFromInventory(Collection<Card> cards) {
        inventory.removeCards(cards);
    }

    public void clearInventory() {
        inventory.clearInventory();
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        if (hand == null)
            throw new IllegalArgumentException("Hand cannot be null");
        this.hand = hand;
    }

    public abstract Hand drawHand();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Actor actor = (Actor) o;

        if (ID != actor.ID) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return ID;
    }
}
