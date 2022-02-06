package it.unicam.cs.cardGamesProject;

import java.util.ArrayList;

/**
 *
 * Interface representing a generic cards player
 *
 * @author Damiano Pasquini
 *
 */
public interface Player {

    /**
     * The name of the player
     * @return the {@code String} name of that {@code Player}
     */
    String getName();

    /**
     * All the cards a player has in his hands
     * @return an {@code ArrayList} of {@code Card} that this {@code Player} has in his hands
     */
    ArrayList<Card> getHandCards();

    /**
     * All the cards a player has on table
     * @return an {@code ArrayList} of {@code Card} that this {@code Player} has on table
     */
    ArrayList<Card> getTableCards();

    /**
     * The current cumulated score of a player
     * @return current {@code int} value of the cumulated score of this {@code player}
     */
    int getCurrScore();

    /**
     * Method to assign the score to this {@code Player}
     * @param score the {@code int} value to assign to this {@code Player}
     */
    void setScore(int score);

    /**
     * With this method a {@code Player} chooses a {@code Card} from the ones he has in his hands
     * @return a {@code Card}
     */
    Card chooseCard();

    /**
     * This method allows a player to play his turn
     */
    void playTurn();

    /**
     * Method used to print all the uncovered {@code Card} that a {@code Player} has on the table
     */
    void printCardsInTable();

}