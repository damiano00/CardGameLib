package it.unicam.cs.cardGamesProject;

/**
 *
 * Interface representing a generic suit of a card
 *
 * @author Damiano Pasquini
 *
 */
public interface Suit {

    /**
     * Name of a card suit
     * @return the name of a {@code Card} {@code Suit}
     */
    String getName();

    /**
     * Method to set the suit name
     */
    void setName(String name);
}