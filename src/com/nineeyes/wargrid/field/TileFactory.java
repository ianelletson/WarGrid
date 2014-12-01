package com.nineeyes.wargrid.field;

import com.nineeyes.wargrid.entities.Entity;

/**
 * Created by ian on 11/30/14.
 * Abstract Factory to create families of tiles
 */
public interface TileFactory {
    public Tile makeEdgeTile(Entity entity);
    public Tile makeInteriorTile(Entity entity);
}
