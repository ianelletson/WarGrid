package com.nineeyes.wargrid.field;

import com.nineeyes.wargrid.entities.Actor;

/**
 * com.nineeyes.wargrid.field
 */
public interface GridFactory {
    public Grid createGrid();
    public Grid createGrid(Actor player, Actor enemy);
}
