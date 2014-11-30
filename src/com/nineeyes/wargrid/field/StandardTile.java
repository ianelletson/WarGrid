package com.nineeyes.wargrid.field;

import com.nineeyes.wargrid.entities.Actor;
import squidpony.squidcolor.SColor;

import java.awt.image.BufferedImage;

/**
 * Created by ian on 11/30/14.
 * The default tile. Has no special effects.
 */
public class StandardTile extends Tile {
    private boolean occupied;
    private Actor occupant;
    private boolean edge;
    private SColor color;
    private FieldEffectCommand fieldEffectCommand;
    private FieldMovementCommand fieldMovementCommand;
    private BufferedImage glyph;

    public StandardTile(boolean edge, SColor color) {
        this.edge = edge;
        this.color = color;
        occupied = false;
        occupant = null;
        fieldEffectCommand = null;
        fieldMovementCommand = null;
        glyph = null; // TODO set standard glyphs
    }

    @Override
    public boolean getOccupied() {
        return occupied;
    }

    @Override
    public Actor getOccupant() {
        return occupant;
    }

    @Override
    public boolean getEdge() {
        return edge;
    }

    @Override
    public SColor getColor() {
        return color;
    }

    @Override
    public BufferedImage getGlyph() {
        return glyph;
    }

    @Override
    public void setOccupied(boolean occupied) {
//        if ((occupant) && (!occupied))
            // TODO implement exception
        this.occupied = occupied;
    }

    @Override
    public void addOccupant(Actor actor) {
//        if ((actor == null) || (occupant != null))
            // TODO throw exception
        occupant = actor;
    }

    @Override
    public void removeOccupant() {
        if (occupant != null)
            occupant = null;
    }

    @Override
    public void setEdge(boolean edge) {
        this.edge = edge;
    }

    @Override
    public void setColor(SColor color) {
        this.color = color;
    }

    @Override
    public void setGlyph(BufferedImage glyph) {
        this.glyph = glyph;
    }

    @Override
    public void setFieldEffectCommand(FieldEffectCommand fec) {
        fieldEffectCommand = fec;
    }

    @Override
    public void setFieldMovementCommand(FieldMovementCommand fmc) {
        fieldMovementCommand = fmc;
    }

    @Override
    public void onOccupy() {
        fieldEffectCommand.execute();
        fieldMovementCommand.execute();
    }
}
