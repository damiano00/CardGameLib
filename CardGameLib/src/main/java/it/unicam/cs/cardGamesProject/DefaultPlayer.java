package it.unicam.cs.cardGamesProject;

import java.util.ArrayList;

/**
 *
 * This abstract class represents a default cards game player
 *
 * @author Damiano Pasquini
 *
 */
public abstract class DefaultPlayer implements Player{

    private final String name;
    private final ArrayList<Card> handCards;
    private final ArrayList<Card> tableCards;
    private int score;

    public DefaultPlayer(String name){
        this.name = name;
        this.handCards = new ArrayList<>();
        this.tableCards = new ArrayList<>();
        this.score = 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public ArrayList<Card> getHandCards() {
        return this.handCards;
    }

    @Override
    public ArrayList<Card> getTableCards() {
        return this.tableCards;
    }

    @Override
    public int getCurrScore() {
        return this.score;
    }

    @Override
    public void setScore(int score){
        this.score = score;
    }

    public abstract Card chooseCard();

    public abstract void playTurn();

    @Override
    public void printCardsInTable(){
        int uncoveredCards = 0;
        for (Card card : this.getTableCards())
            if(!card.isCovered())
                uncoveredCards++;
        if(uncoveredCards > 0) {
            StringBuilder stringToReturn = new StringBuilder(this.getName() + " table cards\n");
            for (int i = 0; i < this.getTableCards().size(); i++)
                if (!this.getTableCards().get(i).isCovered())
                    stringToReturn.append(" - ").append(this.getTableCards().get(i).getInfo()).append("\n");
            System.out.println(stringToReturn);
        }
    }

}