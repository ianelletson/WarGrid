package com.nineeyes.wargrid.field;

import com.nineeyes.wargrid.entities.Entity;
import squidpony.squidcolor.SColor;

/**
 * Created by ian on 11/30/14.
 * Creates standard tiles
 */
public class StandardTileFactory implements TileFactory {
    private SColor playerColor = SColor.BLUE;
    private SColor enemyColor = SColor.RED;

    public StandardTileFactory() {
    }

    @Override
    public Tile makeEdgeTile(Entity entity) {
        SColor color;

        switch (entity) {
            case PLAYER:
                color = playerColor;
                break;
            case ENEMY:
                color = enemyColor;
                break;
            default:
                throw new EnumConstantNotPresentException(Entity.class, entity.toString() + " is not a valid enum");
        }
        return new StandardTile(true, color);
    }

    @Override
    public Tile makeInteriorTile(Entity entity) {
        SColor color;

        switch (entity) {
            case PLAYER:
                color = playerColor;
                break;
            case ENEMY:
                color = enemyColor;
                break;
            default:
                throw new EnumConstantNotPresentException(Entity.class, entity.toString() + " is not a valid enum");
        }
        return new StandardTile(false, color);
    }
}
