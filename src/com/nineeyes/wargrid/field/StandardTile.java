package com.nineeyes.wargrid.field;

import squidpony.squidcolor.SColor;

/**
 * Created by ian on 11/30/14.
 * The default tile. Has no special effects.
 */
public class StandardTile extends Tile {

    public StandardTile(boolean edge, SColor color) {
        setEdge(edge);
        setColor(color);
        setOccupied(false);
        addOccupant(null);
        setFieldEffectCommand(null); // TODO standard commands
        setFieldMovementCommand(null);
        setGlyph(null); // TODO set standard glyphs
    }

}
