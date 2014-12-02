package com.nineeyes.wargrid.field;

import com.nineeyes.wargrid.entities.Actor;
import squidpony.squidcolor.SColor;

import java.awt.image.BufferedImage;

/**
 * Created by ian on 11/29/14.
 * Abstract class all tiles will derive from
 */
public abstract class Tile {
    private boolean occupied;
    private Actor occupant;
    private boolean edge;
    private SColor color;
    private FieldEffectCommand fieldEffectCommand;
    private FieldMovementCommand fieldMovementCommand;
    private BufferedImage glyph;

    public boolean getOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public Actor getOccupant() {
        return occupant;
    }

    public boolean getEdge() {
        return edge;
    }

    public void setEdge(boolean edge) {
        this.edge = edge;
    }

    public SColor getColor() {
        return color;
    }

    public void setColor(SColor color) {
        this.color = color;
    }

    public BufferedImage getGlyph() {
        return glyph;
    }

    public void setGlyph(BufferedImage glyph) {
        this.glyph = glyph;
    }

    public void addOccupant(Actor actor) {
        if (actor == null)
            throw new IllegalArgumentException("Can't add a null occupant");
        occupant = actor;
        setOccupied(true);
    }

    public void removeOccupant() {
        occupant = null;
        setOccupied(false);
    }

    public void setFieldEffectCommand(FieldEffectCommand fec) {
        fieldEffectCommand = fec;
    }

    public void setFieldMovementCommand(FieldMovementCommand fmc) {
        fieldMovementCommand = fmc;
    }

    /**
     * Executes the FieldEffectCommand and the FieldMovementCommand in that order.
     * Example: if the tile is icy poison, deal poison damage to occupant and then push occupant along path.
     */
    public void onOccupy() {
        fieldEffectCommand.execute();
        fieldMovementCommand.execute();
    }
}
