package it.unicam.cs.cardGamesProject;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * Test class of a default game
 *
 * @author Damiano Pasquini
 *
 */
class DefaultGameTest {

    ArrayList<Player> players = new ArrayList<>();

    Player player = new DefaultPlayer("Test_Player") {
        @Override
        public Card chooseCard() {
            return this.getHandCards().get(0);
        }

        @Override
        public void playTurn() {
            Card chosenCard = this.chooseCard();
            super.getHandCards().remove(chosenCard);
            super.getTableCards().add(chosenCard);
            chosenCard.setIsCovered(false);
        }
    };

    Player playerTwo = new DefaultPlayer("Test_Player_Two") {
        @Override
        public Card chooseCard() {
            return this.getHandCards().get(0);
        }

        @Override
        public void playTurn() {
            Card chosenCard = this.chooseCard();
            super.getHandCards().remove(chosenCard);
            super.getTableCards().add(chosenCard);
            chosenCard.setIsCovered(false);
        }
    };

    DefaultDeck deck = new DefaultDeck(){};

    DefaultGame testGame = new DefaultGame(players, 2,6, deck) {

        @Override
        public void startGame() {
            while(super.deck().getSize() > 0){
                for (Player player : super.getCurrPlayers()){
                    player.playTurn();
                }
                if(super.deck().getSize() >= super.getCurrPlayers().size()) super.giveCardsPerPlayer(1);
                else break;
            }
        }

        @Override
        public Player getWinner() {
            return null;
        }

        @Override
        public void setCardsValues() {
        }
    };

    @Test
    void giveCardsPerPlayerTest() {
        players.add(player);
        players.add(playerTwo);
        final Suit testSuit = new DefaultSuit("testSuit");
        deck.getDeck().add(new DefaultCard(testSuit, 1));
        deck.getDeck().add(new DefaultCard(testSuit, 2));
        testGame.giveCardsPerPlayer(1);
        assertEquals(1,this.player.getHandCards().size());
    }
}