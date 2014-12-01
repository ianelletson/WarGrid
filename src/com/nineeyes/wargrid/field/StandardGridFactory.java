package com.nineeyes.wargrid.field;

/**
 * com.nineeyes.wargrid.field
 */
public class StandardGridFactory implements GridFactory {

    @Override
    public Grid createGrid() {
        return new StandardGrid();
    }
}
