package it.unicam.cs.briscolaImplementation;

import it.unicam.cs.cardGamesProject.Deck;
import it.unicam.cs.cardGamesProject.DefaultDeck;
import it.unicam.cs.cardGamesProject.Suit;

/**
 *
 * This class is used to create a deck with italian suits
 *
 * @author Damiano Pasquini
 *
 */
public class ItalianSuitedDeck extends DefaultDeck implements Deck {

    /**
     * Create a deck with italian suits which are Spade, Coppe, Denari and Bastoni
     */
    ItalianSuitedDeck(){
        super();
        final Suit spade = new ItalianSuits("Spade");
        final Suit coppe = new ItalianSuits("Coppe");
        final Suit denari = new ItalianSuits("Denari");
        final Suit bastoni = new ItalianSuits("Bastoni");
        for (int j = 1; j < 11; j++) super.getDeck().add(new ItalianSuitedCard(spade, j));
        for (int j = 1; j < 11; j++) super.getDeck().add(new ItalianSuitedCard(coppe, j));
        for (int j = 1; j < 11; j++) super.getDeck().add(new ItalianSuitedCard(denari, j));
        for (int j = 1; j < 11; j++) super.getDeck().add(new ItalianSuitedCard(bastoni, j));
    }

}