package it.unicam.cs.briscolaImplementation;

import it.unicam.cs.cardGamesProject.Card;
import it.unicam.cs.cardGamesProject.DefaultRealPlayer;
import it.unicam.cs.cardGamesProject.Player;
import java.util.Scanner;

/**
 *
 * This class is used to create a real Briscola player or a bot Briscola player
 *
 * @author Damiano Pasquini
 *
 */
public class BriscolaRealPlayer extends DefaultRealPlayer implements Player {

    public BriscolaRealPlayer(String name){
        super(name);
    }

    @Override
    public Card chooseCard() {
        Scanner input = new Scanner( System.in );
        int cardIndex;
        System.out.println(super.getName()+" choose a card [1, 2 or 3]");
        cardIndex = input.nextInt();
        while(cardIndex < 1 || cardIndex > 3) {
            System.out.println("Invalid number! Choose a card [1, 2 or 3]");
            cardIndex = input.nextInt();
        }
        return super.getHandCards().get(cardIndex-1);
    }

    /**
     * A turn for a {@code Player} in {@code BriscolaGame} is made moving a {@code Card} from his hands
     * to the table uncovering it
     */
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