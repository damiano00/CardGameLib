package it.unicam.cs.cardGamesProject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * Test class of a default deck
 *
 * @author Damiano Pasquini
 *
 */
class DefaultDeckTest {

    DefaultDeck deck = new DefaultDeck(){};
    Suit suitOne = new DefaultSuit("suitOneTest");
    Suit suitTwo = new DefaultSuit("suitTwoTest");
    Card cardOne = new DefaultCard(suitOne, 1);
    Card cardTwo = new DefaultCard(suitTwo, 2);

    @Test
    void removeThisCardTest() {
        this.deck.getDeck().add(cardOne);
        this.deck.getDeck().add(cardTwo);
        this.deck.shuffle();
        assertTrue(this.deck.getDeck().contains(cardTwo));
        deck.removeThisCard(suitTwo,2);
        assertFalse(this.deck.getDeck().contains(cardTwo));
    }
}