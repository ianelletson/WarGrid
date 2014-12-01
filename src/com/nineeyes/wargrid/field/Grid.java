package com.nineeyes.wargrid.field;

import com.nineeyes.wargrid.entities.Actor;

import java.util.Collection;
import java.util.Map;

/**
 * Created by ian on 11/30/14.
 * Abstract class for Grids
 */
public abstract class Grid {
    private Tile[][] tiles;
    private Map<Actor, Location> actors;
    protected int xSize, ySize;
    // TODO probably need a way of displaying something around tiles, might not
    // TODO might need a way of displaying in general, could call display on all tiles

    public void addActor(Actor actor, Location location) {
        actors.put(actor, location);
    }

    public void addActors(Map<Actor, Location> actors) {
        this.actors.putAll(actors);
    }

    public void removeActor(Actor actor) {
        actors.remove(actor);
    }

    public void removeActors(Collection<Actor> actors) {
        for (Actor actor : actors)
            this.actors.remove(actor);
    }

    public void removeAllActors() {
        actors.clear();
    }

    public void setTiles(Tile[][] tiles) {
        if ((tiles.length != xSize) || tiles.length != ySize)
            throw new IllegalArgumentException("supplied tiles array does not have correct size");
        this.tiles = tiles;
    }

    public void changeTile(Location location, Tile tile) {
        tiles[location.x][location.y] = tile;
    }
}
