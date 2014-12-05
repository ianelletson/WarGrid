package com.nineeyes.wargrid.entities;

import java.util.Map;

/**
 * com.nineeyes.wargrid.entities
 */
public abstract class Inventory {
    private Map<Card, Integer> cards;

    public Map<Card, Integer> getCards() {
        return cards;
    }

    public void setCards(Map<Card, Integer> cards) {
        this.cards = cards;
    }

    public void addCard(Card card) {
        if (card == null)
            throw new IllegalArgumentException("Cannot add null card");
        if (cards.containsKey(card)) {
            int count = cards.get(card);
            cards.put(card, ++count);
        } else
            cards.put(card, 1);
    }

    public void removeCard(Card card) {
        if (card == null)
            throw new IllegalArgumentException("Can't remove null card");
        if (cards.containsKey(card)) {

        }
    }
}
