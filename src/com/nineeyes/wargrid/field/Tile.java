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

    public Actor getOccupant() {
        return occupant;
    }

    public boolean getEdge() {
        return edge;
    }

    public SColor getColor() {
        return color;
    }

    public BufferedImage getGlyph() {
        return glyph;
    }

    public void setOccupied(boolean occupied) {
//        if ((occupant) && (!occupied))
        // TODO implement exception
        this.occupied = occupied;
    }

    public void addOccupant(Actor actor) {
//        if ((actor == null) || (occupant != null))
        // TODO throw exception
        occupant = actor;
    }

    public void removeOccupant() {
        occupant = null;
    }

    public void setEdge(boolean edge) {
        this.edge = edge;
    }

    public void setColor(SColor color) {
        this.color = color;
    }

    public void setGlyph(BufferedImage glyph) {
        this.glyph = glyph;
    }

    public void setFieldEffectCommand(FieldEffectCommand fec) {
        fieldEffectCommand = fec;
    }


    public void setFieldMovementCommand(FieldMovementCommand fmc) {
        fieldMovementCommand = fmc;
    }

    public void onOccupy() {
        fieldEffectCommand.execute();
        fieldMovementCommand.execute();
    }
}
