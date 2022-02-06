package it.unicam.cs.cardGamesProject;

import java.util.ArrayList;

/**
 *
 * Interface representing a generic cards game
 *
 * @author Damiano Pasquini
 *
 */
public interface Game {

    /**
     * Minimum player to play to this card game
     * @return {@code int} number of minimum {@code Player} to play this {@code Game}
     */
    int getMinPlayers();

    /**
     * Maximum player who can play to this card game
     * @return {@code int} number of maximum players to play this game
     */
    int getMaxPlayers();

    /**
     * ArrayList of current players who are playing this card game
     * @return an {@code ArrayList} of current gaming {@code Player}
     */
    ArrayList<Player> getCurrPlayers();

    /**
     * Used deck to play card game
     * @return the {@code Deck} used on this game
     */
    Deck deck();

    /**
     * Method to start a {@code Card} {@code Game}
     */
    void startGame();

    /**
     * Method to give a certain number of card to each player
     * @param cardsPerPlayer {@code int} number of {@code Card} to give to each {@code Player}
     */
    void giveCardsPerPlayer(int cardsPerPlayer);

    /**
     * Method to get the game winner
     * @return the {@code Player} who won this {@code Card} {@code Game}
     */
    Player getWinner();

    /**
     * This method is used to set all the values to all the cards in this deck
     */
    void setCardsValues();
}
