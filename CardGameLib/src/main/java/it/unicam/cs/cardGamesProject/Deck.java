package it.unicam.cs.cardGamesProject;

import java.util.ArrayList;

/**
 *
 * Interface representing a generic cards deck
 *
 * @author Damiano Pasquini
 *
 */
public interface Deck {

    /**
     * Method to get the used card deck
     * @return the {@code Card} with index 0 in this {@code Deck}
     */
    Card getOneCard();

    /**
     * This method shuffle the {@code Deck}
     */
    void shuffle();

    /**
     * This method allows knowing how many cards are actually in this deck
     * @return {@code int} number of {@code Card} in this {@code Deck}
     */
    int getSize();

    /**
     * This method remove a specific card from this deck
     * @param suit the {@code Suit} of the {@code Card} to remove
     * @param number the {@code int} number of the {@code Card} to remove
     */
    void removeThisCard(Suit suit, int number);

    ArrayList<Card> getDeck();
}