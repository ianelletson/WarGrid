package com.nineeyes.wargrid.field;

import com.nineeyes.wargrid.entities.Actor;

/**
 * com.nineeyes.wargrid.field
 */
public interface GridFactory {
    /**
     * createGrid
     *
     * @return a Grid
     */
    public Grid createGrid();

    /**
     * @param player instance of Actor to appear on ally side
     * @param enemy  instance of Actor to appear on enemy side
     * @return Grid with both actors attached
     */
    public Grid createGrid(Actor player, Actor enemy);
}
