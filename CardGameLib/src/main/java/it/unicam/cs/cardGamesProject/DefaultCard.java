package it.unicam.cs.cardGamesProject;

/**
 *
 * This class represent a default game card
 *
 * @author Damiano Pasquini
 *
 */
public class DefaultCard implements Card{

    private final Suit suit;
    private int value;
    private final int number;
    private boolean isCovered;

    /**
     * Creates a card with given suit and given number
     * @param suit given suit
     * @param number given number
     */
    public DefaultCard(Suit suit, int number){
        this.suit = suit;
        this.number = number;
        this.isCovered = true;
        this.value = -1;
    }

    @Override
    public final Suit getSuit() {
        return this.suit;
    }

    @Override
    public final int getValue() {
        return this.value;
    }

    @Override
    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public final int getNumber() {
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
    public String getInfo(){
        return this.number+" of "+this.suit.getName();
    }

}
