package com.nineeyes.wargrid.entities;

import squidpony.squidcolor.SColor;

import javax.smartcardio.Card;
import java.util.Collection;
import java.util.List;

/**
 * Created by ian on 11/30/14.
 * Actor class is abstract super class of all acting entities in the game e.g. player and enemy
 */
public abstract class Actor {
    private int health, level;
    private Inventory inventory;
    private List<Deck> decks;
    private Hand hand;
    private SColor color;

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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if (level < 1)
            throw new IllegalArgumentException("Level cannot be less than 1");
        this.level = level;
    }

    public void addLevel(int level) {
        if (level < 0)
            throw new IllegalArgumentException("Cannot add negative level");
        this.level += level;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        if (decks == null)
            throw new IllegalArgumentException("Inventory cannot be null");
        this.inventory = inventory;
    }

    public void addToInventory(Card card) {
        // TODO add card to inventory
    }

    public void addToInventory(Collection<Card> cards) {
        // TODO add cards to inventory
    }

    public void removeFromInventory(Card card) {
        // TODO remove card from inventory
    }

    public void removeFromInventory(Collection<Card> cards) {
        // TODO remove cards from inventory
    }

    public void clearInventory() {
        // TODO clear inventory
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
}
