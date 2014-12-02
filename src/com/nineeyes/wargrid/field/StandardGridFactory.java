package com.nineeyes.wargrid.field;

import com.nineeyes.wargrid.entities.Actor;
import com.nineeyes.wargrid.entities.Entity;

/**
 * com.nineeyes.wargrid.field
 * Factory which returns a standard implementation of a grid, fully initialized with tiles in standard location.
 * Optionally adds two actors in default locations to grid.
 */
public class StandardGridFactory implements GridFactory {
    Location defaultPlayerPosition;
    Location defaultEnemyPosition;
    TileFactory tileFactory;

    StandardGridFactory(TileFactory tileFactory) {
        defaultPlayerPosition = new Location(0, 1);
        defaultEnemyPosition = new Location(5, 1);
        this.tileFactory = tileFactory;
    }

    /**
     * Used when you want a standard, no frills grid with tiles set to default colors, and edges set by default.
     *
     * @return Grid with proper edges/center tiles and default ally/enemy coloring
     */
    @Override
    public Grid createGrid() {
        Grid grid = new StandardGrid();
        int x = grid.getxSize();
        int y = grid.getySize();
        Tile[][] tiles = new Tile[x][y];
        for (int i = 0; i < grid.getxSize(); ++i)
            for (int j = 0; j < grid.getySize(); ++j) {
                Tile tile;
                if ((i < grid.getxPlayerSize() || (j < grid.getyPlayerSize())))
                    if ((i == 0) || (i == x - 1) || (j == 0) || (j == y - 1))
                        tile = tileFactory.makeEdgeTile(Entity.PLAYER);
                    else
                        tile = tileFactory.makeInteriorTile(Entity.PLAYER);
                else if ((i == 0) || (i == x - 1) || (j == 0) || (j == y - 1))
                    tile = tileFactory.makeEdgeTile(Entity.ENEMY);
                else
                    tile = tileFactory.makeInteriorTile(Entity.ENEMY);
                tiles[i][j] = tile;
            }
        return grid;
    }

    /**
     * @param player provide the instance of the player to appear on the grid
     * @param enemy  provide the instance of the enemy to appear on the grid
     * @return a Grid with default locations for colors, player, enemy
     */
    @Override
    public Grid createGrid(Actor player, Actor enemy) {
        Grid grid = createGrid();
        grid.addAlly(player, defaultPlayerPosition);
        grid.addEnemy(enemy, defaultEnemyPosition);
        return grid;
    }
}
