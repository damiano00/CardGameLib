package it.unicam.cs.cardGamesProject;

import java.util.ArrayList;

/**
 *
 * This default game defines all the common attributes that a game musts have
 *
 * @author Damiano Pasquini
 *
 */
public abstract class DefaultGame implements Game{

    /**
     * Minimum players allowed
     */
    private final int MIN_PLAYERS;

    /**
     * Maximum players allowed
     */
    private final int MAX_PLAYERS;

    /**
     * Current players those are playing to this {@code Card} {@code Game}
     */
    private final ArrayList<Player> currPlayers;

    /**
     * Used deck in this game
     */
    private final Deck deck;

    /**
     * Constructor of a default card game
     * @param players {@code Player} who want to play this {@code Card} {@code Game}
     * @param minPlayers minimum {@code int} number of {@code Player}
     * @param maxPlayers maximum {@code int} number of {@code Player}
     * @param deck used {@code Deck} in this {@code Card} {@code Game}
     *
     * @throws NullPointerException if {@code Player} ArrayList or {@code Deck} is null
     * @throws IllegalArgumentException if minimum players or maximum players are null
     */
    public DefaultGame(ArrayList<Player> players, int minPlayers, int maxPlayers, Deck deck){
        if(players == null || deck == null) throw new NullPointerException();
        if(minPlayers == 0 || maxPlayers == 0) throw new IllegalArgumentException();
        this.MIN_PLAYERS = minPlayers;
        this.MAX_PLAYERS = maxPlayers;
        this.currPlayers = players;
        this.deck = deck;
    }

    @Override
    public int getMinPlayers(){
        return this.MIN_PLAYERS;
    }

    @Override
    public int getMaxPlayers(){
        return this.MAX_PLAYERS;
    }

    @Override
    public ArrayList<Player> getCurrPlayers(){
        return this.currPlayers;
    }

    @Override
    public Deck deck(){
        return this.deck;
    }

    public abstract void startGame();

    /**
     * @param cardsPerPlayer {@code int} number of {@code Card} to give to each {@code Player}
     *
     * @throws IllegalArgumentException if {@code Card} per {@code Card} is equals to zero and if there
     *          aren't enough {@code Card} in this {@code Deck}
     */
    @Override
    public void giveCardsPerPlayer(int cardsPerPlayer){
        if(cardsPerPlayer == 0) throw new IllegalArgumentException("Cards per player can't be zero");
        if(cardsPerPlayer * this.currPlayers.size() > this.deck.getSize())
            throw new IllegalArgumentException("Too many cards per player");

        for (Player currPlayer : this.currPlayers)
            for (int i = 0; i < cardsPerPlayer; i++)
                currPlayer.getHandCards().add(this.deck.getOneCard());
    }

    public abstract Player getWinner();

    public abstract void setCardsValues();

}
