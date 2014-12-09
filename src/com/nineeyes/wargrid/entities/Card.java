package com.nineeyes.wargrid.entities;

import com.nineeyes.wargrid.command.Command;

/**
 * com.nineeyes.wargrid.entities
 * Class that all cards will derive from
 * Every card has an effect
 */
public abstract class Card {
    private int ID;
    private String name;
    private String description; // TODO implement a way of reading card descriptions from a file
    private Command effect;

    public int getID() {
        return ID;
    }

    protected void setID(int id) {
        ID = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
