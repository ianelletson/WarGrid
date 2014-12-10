package com.nineeyes.wargrid.entities;

import java.util.HashMap;
import java.util.Map;

/**
 * com.nineeyes.wargrid.entities
 */
public class PlayerInventory extends Inventory {
    public PlayerInventory() {
        this(new HashMap<Card, Integer>());
    }
    public PlayerInventory(Map<Card, Integer> cards) {
        setCards(cards);
    }
}
