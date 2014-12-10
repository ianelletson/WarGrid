package com.nineeyes.wargrid.entities;

import squidpony.squidcolor.SColor;

import java.util.LinkedList;
import java.util.List;

/**
 * com.nineeyes.wargrid.entities
 */
public class Player extends Actor implements Levelable {
    private int level, experience, expCap;
    private List<Deck> decks; // Top deck assumed active

    public Player(String name) {
        setName(name);
        setID(1); // TODO make a document with all IDs that this reads from
        setLevel(1); // TODO make a place for default levels, health, etc
        setExpCap(10); // TODO sensible exp cap
        setHealth(10);
        setInventory(new PlayerInventory());
        setColor(SColor.FOREST_GREEN); // TODO pick a player color, set it somewhere (options file?)
        setDecks(new LinkedList<Deck>()); // TODO init decks, make a starter inventory with cards, deck
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
    public void levelUp(int levels) {
        modifyLevel(levels);
        modifyExpCap(2); // TODO something relevant to growth here
    }

    @Override
    public Hand drawHand() {
        Deck deck = getActiveDeck();
        return null; // TODO implement drawing from active deck, setting hand, getting hand
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
        if (decks.isEmpty())
            throw new IllegalStateException("No decks");
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
}
