package it.unicam.cs.cardGamesProject;

/**
 *
 * This class represents a default bot cards game player
 *
 * @author Damiano Pasquini
 *
 */
public abstract class DefaultBotPlayer extends DefaultPlayer implements Player {

    /**
     * The level of difficulty in a range of three (Easy, Medium and Hard)
     */
    private final Difficulty difficulty;

    /**
     * Creates a bot player with a name and easy difficulty
     * @param name the input name of this bot
     */
    public DefaultBotPlayer(String name){
        super(name);
        this.difficulty = Difficulty.EASY;
    }

    /**
     * Creates a default bot player with name and difficulty
     * @param name the input name of this bot
     * @param difficulty the chosen difficulty
     */
    public DefaultBotPlayer(String name, Difficulty difficulty){
        super(name);
        this.difficulty = difficulty;
    }

    public Difficulty getDifficulty(){
        return this.difficulty;
    }

    public abstract Card chooseCard();

    public abstract void playTurn();
}