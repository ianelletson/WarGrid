package com.nineeyes.wargrid.field;

/**
 * Created by ian on 11/30/14.
 * Standard grid implementation
 */
public class StandardGrid extends Grid {
    public StandardGrid() {
        xSize = 6; // Standard x and y sizes based of MMBN
        ySize = 3;
        setPlayerXSize(xSize / 2);
        setPlayerYSize(ySize);
        setTiles(new Tile[xSize][ySize]);
    }
}
