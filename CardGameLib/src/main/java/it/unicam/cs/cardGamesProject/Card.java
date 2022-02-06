package it.unicam.cs.cardGamesProject;

/**
 *
 * Interface representing a generic Card
 *
 * @author Damiano Pasquini
 *
 */
public interface Card {

    /**
     * Method used to get the suit of a card
     * @return The {@code Suit} of a {@code Card}
     */
    Suit getSuit();

    /**
     * Method used to get the value of a card
     * @return the {@code int} value of a {@code Card}
     */
    int getValue();

    /**
     * Method to set the {@code int} value to a single {@code Card} according to the played game
     */
    void setValue(int value);

    /**
     * Is the represented number on this card, which can be different from the card value
     * @return the {@code int} number on this {@code Card}
     */
    int getNumber();

    /**
     * Method used to know if this card is currently visible to all player or not
     * @return {@code True} if the card is currently covered and not visible, {@code False} if
     * the card is currently visible to all the {@code Player}
     */
    boolean isCovered();

    /**
     * Method used to set this card covered or not covered
     * @param isCovered is {@code True} to set the {@code Card} covered, or {@code False} to set it uncovered
     *                  and visible to all {@code Player}
     */
    void setIsCovered(boolean isCovered);

    /**
     * Method used to return a {@code String} containing all the {@code Card} information
     * @return a {@code String} containing all the {@code Card} information
     */
    String getInfo();

}
