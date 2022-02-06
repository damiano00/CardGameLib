package it.unicam.cs.cardGamesProject;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * This class is used to create a default deck
 *
 * @author Damiano Pasquini
 *
 */
public abstract class DefaultDeck implements Deck{

    private final ArrayList<Card> deck;

    /**
     * This constructor creates a default empty deck
     */
    public DefaultDeck(){
        this.deck = new ArrayList<>();
    }

    @Override
    public Card getOneCard() {
        return this.deck.remove(0);
    }

    @Override
    public void shuffle() {
        Collections.shuffle(this.deck);
    }

    @Override
    public int getSize(){
        return this.deck.size();
    }

    @Override
    public void removeThisCard(Suit suit, int number){
        this.deck.removeIf(card -> card.getSuit() == suit && card.getNumber() == number);
    }

    @Override
    public ArrayList<Card> getDeck(){
        return this.deck;
    }

}