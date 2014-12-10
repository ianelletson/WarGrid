package com.nineeyes.wargrid.entities;

import squidpony.squidcolor.SColor;

import java.util.Collection;
import java.util.List;

/**
 * Created by ian on 11/30/14.
 * Actor class is abstract super class of all acting entities in the game e.g. player and enemy
 */
public abstract class Actor implements Levelable{
    private int ID;
    private int health, level, experience, expCap;
    private Inventory inventory;
    private List<Deck> decks;
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

    @Override
    public int getExpCap() {
        return expCap;
    }

    @Override
    public void setExpCap(int expCap) {
        if (expCap < 1)
            throw new IllegalArgumentException("Can't have exp cap less than 1");
        this.expCap = expCap;
    }

    @Override
    public void modifyExpCap(int expCap) {
        setExpCap(experience + expCap);
        if (experience > this.expCap)
            levelUp(experience % this.expCap);
    }

    @Override
    public int getExperience() {
        return experience;
    }

    @Override
    public void setExperience(int experience) {
        this.experience = experience;
        if (this.experience > expCap)
            levelUp(this.experience % expCap);
    }

    @Override
    public void modifyExperience(int experience) {
        this.experience += experience;
        if (this.experience < 0)
            setExperience(0);
        if (this.experience > expCap)
            levelUp(this.experience % expCap);
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void setLevel(int level) {
        if (level < 1)
            level = 1;
        this.level = level;
    }

    @Override
    public void modifyLevel(int level) {
        setLevel(this.level + level);
    }

    @Override
    public abstract void levelUp(int levels);

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        if (decks == null)
            throw new IllegalArgumentException("Inventory cannot be null");
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

    public List<Deck> getDecks() {
        if (decks.isEmpty())
            throw new IllegalStateException("No decks");
        return decks;
    }

    public void setDecks(List<Deck> decks) {
        if (decks == null)
            throw new IllegalArgumentException("Cannot set decks to null");
        this.decks = decks;
    }

    public Deck getActiveDeck() {
        return decks.get(0);
    }

    public void setActiveDeck(Deck deck) {
        if (deck == null)
            throw new IllegalArgumentException("Deck cannot be null");
        decks.add(0, deck);
    }

    public void clearDecks() {
        decks.clear();
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        if (hand == null)
            throw new IllegalArgumentException("Hand cannot be null");
        this.hand = hand;
    }

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
