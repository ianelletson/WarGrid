package com.nineeyes.wargrid.field;

import com.nineeyes.wargrid.entities.Actor;
import com.nineeyes.wargrid.entities.Entity;

/**
 * com.nineeyes.wargrid.field
 */
public class StandardGridFactory implements GridFactory {
    Location defaultPlayerPosition;
    Location defaultEnemyPosition;
    TileFactory tileFactory;

    StandardGridFactory(TileFactory tileFactory) {
        defaultPlayerPosition = new Location(0,1);
        defaultEnemyPosition = new Location(5,1);
        this.tileFactory = tileFactory;
    }

    @Override
    public Grid createGrid() {
        Grid grid = new StandardGrid();
        int x = grid.getxSize();
        int y = grid.getySize();
        Tile[][] tiles = new Tile[x][y];
        for (int i = 0; i < grid.getxSize(); ++i)
            for (int j = 0; j < grid.getySize(); ++j) {
                Tile tile;
                // TODO refactor with player/enemy distinction at top, then better size disctinction
                if ((i == 0) || (i == x-1) || (i == x/2) || (i == (x/2) + 1) || (j == 0) || (j == y-1))
                    if ((i < grid.getxPlayerSize()) || (j < grid.getyPlayerSize()))
                        tile = tileFactory.makeEdgeTile(Entity.PLAYER);
                    else
                        tile = tileFactory.makeEdgeTile(Entity.ENEMY);
                else
                    if ((i < grid.getxPlayerSize()) || (j < grid.getyPlayerSize()))
                        tile = tileFactory.makeInteriorTile(Entity.PLAYER);
                    else
                        tile = tileFactory.makeInteriorTile(Entity.ENEMY);
                tiles[i][j] = tile;
            }
        return grid;
    }

    @Override
    public Grid createGrid(Actor player, Actor enemy) {
        Grid grid = createGrid();
        grid.addAlly(player, defaultPlayerPosition);
        grid.addEnemy(enemy, defaultEnemyPosition);
        return grid;
    }
}
