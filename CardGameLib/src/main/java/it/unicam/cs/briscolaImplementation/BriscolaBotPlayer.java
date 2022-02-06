package it.unicam.cs.briscolaImplementation;

import it.unicam.cs.cardGamesProject.Card;
import it.unicam.cs.cardGamesProject.DefaultBotPlayer;
import it.unicam.cs.cardGamesProject.Player;

import java.util.Random;

/**
 *
 * This class is used to represent a bot player who is able to play briscola card game
 *
 * @author Damiano Pasquini
 *
 */
public class BriscolaBotPlayer extends DefaultBotPlayer implements Player {

    /**
     * This constructor creates a bot player who can play briscola card game
     * @param name the bot player name
     */
    public BriscolaBotPlayer(String name){
        super(name);
    }

    /**
     * This method choose a {@code Card} from the hand cards randomly
     * @return the chosen {@code Card}
     */
    public Card chooseCard() {
        Random r = new Random();
        return super.getHandCards().get(r.nextInt((2) + 1));
    }

    /**
     * A turn for a {@code Player} in {@code BriscolaGame} is made moving a {@code Card} from his hands
     * to the table uncovering it
     */
    @Override
    public void playTurn() {
        Card chosenCard = this.chooseCard();
        this.throwThisCard(chosenCard);
    }

    /**
     * This private method move the card on the table and uncovers it
     * @param card the {@code Card} to move on the table
     */
    private void throwThisCard(Card card){
        super.getHandCards().remove(card);
        super.getTableCards().add(card);
        card.setIsCovered(false);
    }

}