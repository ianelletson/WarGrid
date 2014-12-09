package com.nineeyes.wargrid.entities;

import java.util.Collection;
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

    public void addCards(Collection<Card> cards) {
        for (Card card : cards) addCard(card);
    }

    public void removeCard(Card card) {
        if (card == null)
            throw new IllegalArgumentException("Can't remove null card");
        if (cards.containsKey(card)) {
            int count = cards.get(card);
            if (count == 1)
                cards.remove(card);
            else
                cards.put(card, --count);
        }
    }

    public void removeCards(Collection<Card> cards) {
        for (Card card : cards) removeCard(card);
    }

    public Card getCard(Card card) {
        if (card == null || !cards.containsKey(card))
            throw new IllegalArgumentException("Card does not exist");
        return card;
    }

    public void clearInventory() {
        cards.clear();
    }

    public int size() {
        return cards.size();
    }
}
