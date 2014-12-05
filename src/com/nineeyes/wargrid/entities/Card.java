package com.nineeyes.wargrid.entities;

import com.nineeyes.wargrid.command.Command;

/**
 * com.nineeyes.wargrid.entities
 */
public abstract class Card {
    private int ID;
    private String name;
    private Command effect;

    protected void setID(int id) {
        ID = id;
    }

    public int getID() {
        return ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract void execute();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        return ID == card.ID && name.equals(card.name);

    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + name.hashCode();
        return result;
    }
}
