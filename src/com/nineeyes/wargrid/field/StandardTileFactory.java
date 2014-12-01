package com.nineeyes.wargrid.field;

import com.nineeyes.wargrid.entities.Entity;
import squidpony.squidcolor.SColor;

/**
 * Created by ian on 11/30/14.
 * Creates standard tiles
 */
public class StandardTileFactory implements TileFactory {

    @Override
    public Tile makeEdgeTile(Entity entity) {
        boolean edge = true;
        SColor color;

        switch (entity) {
            case PLAYER:
                color = SColor.BLUE;
                break;
            case ENEMY:
                color = SColor.RED;
                break;
            default:
                throw new EnumConstantNotPresentException(Entity.class, entity.toString() + " is not a valid enum");
        }
        return new StandardTile(edge, color);
    }

    @Override
    public Tile makeInteriorTile(Entity entity) {
        boolean edge = false;
        SColor color;

        switch (entity) {
            case PLAYER:
                color = SColor.BLUE;
                break;
            case ENEMY:
                color = SColor.RED;
                break;
            default:
                throw new EnumConstantNotPresentException(Entity.class, entity.toString() + " is not a valid enum");
        }
        return new StandardTile(edge, color);
    }
}
