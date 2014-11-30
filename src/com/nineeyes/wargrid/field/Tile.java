package com.nineeyes.wargrid.field;

import com.nineeyes.wargrid.entities.Actor;
import squidpony.squidcolor.SColor;

import java.awt.image.BufferedImage;

/**
 * Created by ian on 11/29/14.
 * Abstract class all tiles will derive from
 */
public abstract class Tile {
    public abstract boolean getOccupied();
    public abstract Actor getOccupant();
    public abstract boolean getEdge();
    public abstract SColor getColor();
    public abstract BufferedImage getGlyph();
    public abstract void setOccupied(boolean occupied);
    public abstract void addOccupant(Actor actor);
    public abstract void removeOccupant();
    public abstract void setEdge(boolean edge);
    public abstract void setColor(SColor color);
    public abstract void setGlyph(BufferedImage glyph);
    public abstract void setFieldEffectCommand(FieldEffectCommand fec);
    public abstract void setFieldMovementCommand(FieldMovementCommand fmc);
    public abstract void onOccupy();
}
