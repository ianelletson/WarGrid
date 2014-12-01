package com.nineeyes.wargrid.field;

import com.nineeyes.wargrid.entities.Actor;

import java.util.Collection;
import java.util.Map;

/**
 * Created by ian on 11/30/14.
 * Abstract class for Grids
 */
public abstract class Grid {
    public abstract void addActor(Actor actor, Location location);
    public abstract void addActors(Map<Actor, Location> actors);
    public abstract void removeActor(Actor actor);
    public abstract void removeActors(Collection<Actor> actors);
    public abstract void removeAllActors();
    public abstract void setTiles(Tile[][] tiles);
    public abstract void changeTile(Location location, Tile tile);
//    public abstract void draw(); // TODO might not need this
}
