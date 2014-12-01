package com.nineeyes.wargrid.field;

import com.nineeyes.wargrid.entities.Actor;

import java.util.Collection;
import java.util.Map;

/**
 * Created by ian on 11/30/14.
 * Standard grid implementation
 */
public class StandardGrid extends Grid {
    private Tile[][] tiles;
    private Map<Actor, Location> actors;
    private int xSize, ySize;
    // TODO probably need a way of displaying something around tiles, might not



    @Override
    public void addActor(Actor actor, Location location) {
        actors.put(actor, location);
    }

    @Override
    public void addActors(Map<Actor, Location> actors) {
        this.actors.putAll(actors);
    }

    @Override
    public void removeActor(Actor actor) {
        actors.remove(actor);
    }

    @Override
    public void removeActors(Collection<Actor> actors) {
        for (Actor actor : actors)
            this.actors.remove(actor);
    }

    @Override
    public void removeAllActors() {
        actors.clear();
    }

    @Override
    public void setTiles(Tile[][] tiles) {
        if ((tiles.length != xSize) || tiles.length != ySize)
            throw new IllegalArgumentException("supplied tiles array does not have correct size");
        this.tiles = tiles;
    }

    @Override
    public void changeTile(Location location, Tile tile) {
        tiles[location.x][location.y] = tile;
    }
}
