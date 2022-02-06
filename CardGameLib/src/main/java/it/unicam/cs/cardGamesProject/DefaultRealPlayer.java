package it.unicam.cs.cardGamesProject;

/**
 *
 * This class represents a default real cards game player
 *
 * @author Damiano Pasquini
 *
 */
public abstract class DefaultRealPlayer extends DefaultPlayer implements Player{

    public DefaultRealPlayer(String name){
        super(name);
    }

    public abstract Card chooseCard();

    public abstract void playTurn();

    /**
     * Method that prints all the {@code Cards} that a {@code Player} has on his hands
     */
    public void printCardsInHand(){
        StringBuilder stringToReturn = new StringBuilder(this.getName()+" has these cards:\n");
        for (int i = 0; i < this.getHandCards().size(); i++)
            stringToReturn.append(i+1).append(") ").append(this.getHandCards().get(i).getInfo()).append("\n");
        System.out.println(stringToReturn);
    }

}