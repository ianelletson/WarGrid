package com.nineeyes.wargrid.field;

import com.nineeyes.wargrid.entities.Actor;

import java.util.Collection;
import java.util.Map;

/**
 * Created by ian on 11/30/14.
 * Abstract class for Grids
 */
public abstract class Grid {
    protected int xSize, ySize;
    private Tile[][] tiles;
    private Map<Actor, Location> allies;
    private Map<Actor, Location> enemies;
    private int xPlayerSize, yPlayerSize;
    // TODO probably need a way of displaying something around tiles, might not
    // TODO might need a way of displaying in general, could call display on all tiles

    public void addAlly(Actor actor, Location location) {
        if (allies.size() + 1 > (xPlayerSize * yPlayerSize))
            throw new IllegalArgumentException("too many actors for grid size");
        allies.put(actor, location);
        tiles[location.x][location.y].addOccupant(actor);
    }

    public void addAllies(Map<Actor, Location> actors) {
        if (actors.size() + allies.size() > (xPlayerSize * yPlayerSize))
            throw new IllegalArgumentException("too many actors for grid size");
        allies.putAll(actors);
    }

    public void removeAlly(Actor actor) {
        allies.remove(actor);
    }

    public void removeAllies(Collection<Actor> actors) {
        for (Actor actor : actors)
            allies.remove(actor);
    }

    public void addEnemy(Actor actor, Location location) {
        if (this.enemies.size() + 1 > (getxEnemySize() * getyEnemySize()))
            throw new IllegalArgumentException("too many actors for grid size");
        enemies.put(actor, location);
    }

    public void addEnemies(Map<Actor, Location> actors) {
        if (actors.size() + enemies.size() > (getxEnemySize() * getyEnemySize()))
            throw new IllegalArgumentException("too many actors for grid size");
        enemies.putAll(actors);
    }

    public void removeEnemy(Actor actor) {
        enemies.remove(actor);
    }

    public void removeEnemies(Collection<Actor> actors) {
        for (Actor actor : actors)
            enemies.remove(actor);
    }

    public void removeAllActors() {
        removeAllAllies();
        removeAllEnemies();
    }

    public void removeAllAllies() {
        allies.clear();
    }

    public void removeAllEnemies() {
        enemies.clear();
    }

    public void setTiles(Tile[][] tiles) {
        if ((tiles.length != xSize) || tiles.length != ySize)
            throw new IllegalArgumentException("supplied tiles array does not have correct size");
        this.tiles = tiles;
    }

    /**
     * Changes the current Tile at a Location to the given Tile
     *
     * @param location the Location of the interested Tile
     * @param tile     the Tile to replace the current Tile
     */
    public void changeTile(Location location, Tile tile) {
        tiles[location.x][location.y] = tile;
    }

    public int getxSize() {
        return xSize;
    }

    public int getySize() {
        return ySize;
    }

    public int getxPlayerSize() {
        return xPlayerSize;
    }

    public int getyPlayerSize() {
        return yPlayerSize;
    }

    public int getxEnemySize() {
        return xSize - xPlayerSize;
    }

    public int getyEnemySize() {
        return ySize - yPlayerSize;
    }

    public void setPlayerXSize(int x) {
        if (x < 1)
            throw new IllegalArgumentException("can't have size less than 1");
        xPlayerSize = x;
    }

    public void setPlayerYSize(int y) {
        if (y < 1)
            throw new IllegalArgumentException("can't have size less than 1");
        yPlayerSize = y;
    }
}