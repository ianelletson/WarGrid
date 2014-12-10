package com.nineeyes.wargrid.entities;

import java.util.HashMap;
import java.util.Map;

/**
 * com.nineeyes.wargrid.entities
 */
public class EnemyInventory extends Inventory {
    EnemyInventory() {
        this(new HashMap<Card, Integer>());
    }

    EnemyInventory(Map<Card, Integer> cards) {
        setCards(cards); // TODO how do I know what cards enemies have?
    }
}
