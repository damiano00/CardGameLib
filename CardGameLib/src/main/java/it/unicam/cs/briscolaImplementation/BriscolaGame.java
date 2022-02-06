package it.unicam.cs.briscolaImplementation;

import it.unicam.cs.cardGamesProject.*;

import java.util.ArrayList;

/**
 *
 * This class represents the italian {@code Card} {@code Game} of Briscola
 *
 * @author Damiano Pasquini
 *
 */
public class BriscolaGame extends DefaultGame implements Game {

    public final Card briscolaCard;
    public Card turnCard;
    public Player lastTurnWinner;
    public int turnNumber;

    public BriscolaGame(ArrayList<Player> players){
        super(players,2,6, new ItalianSuitedDeck());
        this.setCardsValues();
        this.threePlayerCheck();
        super.deck().shuffle();
        this.briscolaCard = super.deck().getOneCard();
        this.briscolaCard.setIsCovered(false);
        this.giveCardsPerPlayer(3);
    }

    public void startGame() {
        turnNumber = 1;
        while(super.deck().getSize() > 0){
            for (Player player : super.getCurrPlayers()){
                this.printPlayerSituation(player);
                player.playTurn();
                if(player.equals(super.getCurrPlayers().get(0))) this.turnCard = player.getTableCards().get(0);
            }
            this.calculateTurnWinner();
            this.reorderPlayer();
            turnNumber++;
            if(super.deck().getSize() >= super.getCurrPlayers().size()) super.giveCardsPerPlayer(1);
            else break;
        }
        this.getWinner();
    }


    public Player getWinner() {
        Player winner = super.getCurrPlayers().get(0);
        for (Player player : super.getCurrPlayers())
            if(player.getCurrScore() > winner.getCurrScore())
                winner = player;
        System.out.println("--- "+winner.getName()+" win! ---");
        return winner;
    }

    public void setCardsValues(){
        for (Card card : super.deck().getDeck()) {
            if(card.getNumber() == 1) card.setValue(11);
            if(card.getNumber() == 2) card.setValue(0);
            if(card.getNumber() == 3) card.setValue(10);
            if(card.getNumber() == 4) card.setValue(0);
            if(card.getNumber() == 5) card.setValue(0);
            if(card.getNumber() == 6) card.setValue(0);
            if(card.getNumber() == 7) card.setValue(0);
            if(card.getNumber() == 8) card.setValue(2);
            if(card.getNumber() == 9) card.setValue(3);
            if(card.getNumber() == 10) card.setValue(4);
        }
    }

    /**
     * This method prints the Briscola card, the table cards and the hand cards for the input player
     * @param inputPlayer the input {@code Player} that must play his turn
     */
    private void printPlayerSituation(Player inputPlayer) {
        if(inputPlayer instanceof DefaultRealPlayer) {
            System.out.println("----------------------------------------\n"
                    + "TURN_" + turnNumber + " " + inputPlayer.getName() + "\n");
            System.out.println("Briscola is: " + this.briscolaCard.getInfo() + "\n");
            if (super.getCurrPlayers().get(0).getTableCards().size() > 0)
                for (Player player : super.getCurrPlayers())
                    if (player.getTableCards().size() > 0) player.printCardsInTable();
            ((DefaultRealPlayer) inputPlayer).printCardsInHand();
        }
    }

    /**
     * This method checks if the {@code Player} are three and in this case remove a card with {@code int}
     * number two from the {@code Deck}
     */
    private void threePlayerCheck(){
        if(super.getCurrPlayers().size() == 3)
            super.deck().removeThisCard(new ItalianSuits("Spade"), 2);
    }

    /**
     * This method decides which player win the current turn
     */
    private void calculateTurnWinner(){
        Player winnerPlayer = super.getCurrPlayers().get(0);
        int briscolaInTable = this.howManyBriscoleInTable();
        int scoreToAdd = 0;
        if(briscolaInTable == 0) winnerPlayer = this.noBriscoleCase();
        if(briscolaInTable == 1) winnerPlayer = this.oneBriscolaCase();
        if(briscolaInTable > 1) winnerPlayer = this.moreThanOneBriscolaCase();
        for (Player player : super.getCurrPlayers())
            if(player.getTableCards().size() > 0)
                for (Card card : player.getTableCards())
                    if(!card.isCovered())
                        scoreToAdd += card.getValue();
        for (Player player : super.getCurrPlayers())
            for (Card card : player.getTableCards())
                card.setIsCovered(true);
        winnerPlayer.setScore(winnerPlayer.getCurrScore() + scoreToAdd);
        this.lastTurnWinner = winnerPlayer;
    }

    /**
     * This method calculate how many briscola cards are on this table
     * @return an {@code int} value representing briscola {@code Card} on this table
     */
    private int howManyBriscoleInTable(){
        int briscolaInTable = 0;
        for (Player player : super.getCurrPlayers())
            if(player.getTableCards().size() > 0)
                for (Card card : player.getTableCards())
                    if(!card.isCovered() && card.getSuit().getName().equals(briscolaCard.getSuit().getName()))
                        briscolaInTable++;
        return briscolaInTable;
    }

    /**
     * The case when there aren't briscola on the table
     * @return the {@code Player} who won this turn, and {@code null} if there is an error calculating it
     */
    private Player noBriscoleCase() {
        Player tmpPlayer = super.getCurrPlayers().get(0);
        int higherValue = this.turnCard.getValue();
        for (Player player : super.getCurrPlayers())
            for (Card card : player.getTableCards())
                if(!card.isCovered())
                    if (card.getSuit().getName().equals(this.turnCard.getSuit().getName()))
                        if (card.getValue() > higherValue) {
                            tmpPlayer = player;
                            higherValue = card.getValue();
                        }
        return tmpPlayer;
    }

    /**
     * The case when there is one briscola on the table
     * @return the {@code Player} who won this turn, and {@code null} if there is an error calculating it
     */
    private Player oneBriscolaCase(){
        Player playerToReturn = super.getCurrPlayers().get(0);
        for (Player player : super.getCurrPlayers())
            for (Card card : player.getTableCards())
                if (!card.isCovered())
                    if (card.getSuit().getName().equals(this.briscolaCard.getSuit().getName()))
                        playerToReturn = player;
        return playerToReturn;
    }

    /**
     * The case when there are more than one briscola on the table
     * @return the {@code Player} who won this turn, and {@code null} if there is an error calculating it
     */
    private Player moreThanOneBriscolaCase(){
        Card higherCard = this.briscolaCard;
        Player playerToReturn = super.getCurrPlayers().get(0);
        for (Player player : super.getCurrPlayers())
            if(player.getTableCards().size() > 0)
                for (Card card : player.getTableCards())
                    if(!card.isCovered())
                        if(card.getSuit().getName().equals(higherCard.getSuit().getName())
                            && card.getValue() > higherCard.getValue()){
                            playerToReturn = player;
                            higherCard = card;
                        }
        return playerToReturn;
    }

    /**
     * Reorders the {@code Player} in the {@code Deck} arrayList in order to allow the turn winner to play
     * the next turn firstly
     */
    private void reorderPlayer(){
        for (int i = 0; i < super.getCurrPlayers().indexOf(this.lastTurnWinner); i++)
            this.shiftRight();
    }

    /**
     * Shifts to the right all the elements of the arrayList {@code Deck} of one position
     */
    private void shiftRight(){
        Player tmp = super.getCurrPlayers().get(super.getCurrPlayers().size()-1);
        for(int i = super.getCurrPlayers().size()-1; i > 0; i--)
            super.getCurrPlayers().set(i,super.getCurrPlayers().get(i-1));
        super.getCurrPlayers().set(0, tmp);
    }
}