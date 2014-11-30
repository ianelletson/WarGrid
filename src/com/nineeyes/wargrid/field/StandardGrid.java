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
    // TODO probably need a way of displaying something around tiles, might not


    @Override
    public void addActor(Actor actor, Location location) {
        actors.put(actor, location);
    }

    @Override
    public void addActors(Map<Actor, Location> actors) {

    }

    @Override
    public void removeActor(Actor actor) {

    }

    @Override
    public void removeActors(Collection<Actor> actors) {

    }

    @Override
    public void removeAllActors() {

    }

    @Override
    public void setTiles(Collection<Tile> tiles) {

    }

    @Override
    public void changeTile(Location location, Tile tile) {

    }
}
