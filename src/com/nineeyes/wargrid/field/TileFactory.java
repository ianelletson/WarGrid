package com.nineeyes.wargrid.field;

/**
 * Created by ian on 11/30/14.
 * Abstract Factory to create families of tiles
 */
public interface TileFactory {
    public abstract TileFactory getFactory();
    // TODO get factories right.
}
