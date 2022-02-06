package it.unicam.cs.briscolaImplementation;

import it.unicam.cs.cardGamesProject.Card;
import it.unicam.cs.cardGamesProject.Suit;

/**
 *
 * Standard italian suited card which compose the italian suited deck
 *
 * @author Damiano Pasquini
 *
 */
public class ItalianSuitedCard implements Card {

    private final Suit suit;
    private int value;
    private final int number;
    private ItalianCardFace figure;
    private boolean isCovered;

    /**
     * Constructor method that create a single italian card through its suit and its number, with
     * value -1 which could be modified according to the game {@code Player} wants to play, and
     * figure {@code null} if it has not a figure because it is a number
     * @param suit the {@code Suit} of this {@code Card}
     * @param number the {@code int} number of this {@code Card}
     */
    ItalianSuitedCard(Suit suit, int number){
        this.suit = suit;
        this.number = number;
        this.isCovered = true;
        this.figure = null;
        this.value = -1;
        if(number == 1) this.figure = ItalianCardFace.ASSO;
        else if(number == 8) this.figure = ItalianCardFace.FANTE;
        else if(number == 9) this.figure = ItalianCardFace.CAVALLO;
        else if(number == 10) this.figure = ItalianCardFace.RE;
    }

    /**
     * Method that return the figure represented on this card
     * @return the {@code italianCardFace} (the figure) represented on this {@code Card} or {@code null}
     * if the {@code Card} has not a figure
     */
    public ItalianCardFace getFigure() {
        return this.figure;
    }

    @Override
    public Suit getSuit() {
        return this.suit;
    }

    @Override
    public int getValue() {
        return this.value;
    }

    @Override
    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int getNumber() {
        return this.number;
    }

    @Override
    public boolean isCovered() {
        return this.isCovered;
    }

    @Override
    public void setIsCovered(boolean isCovered) {
        this.isCovered = isCovered;
    }

    @Override
    public String getInfo() {
        if(this.figure == null) return this.number+" di "+this.suit.getName();
        else return this.figure.name()+" di "+this.suit.getName();
    }
}
