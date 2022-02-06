package it.unicam.cs.briscolaImplementation;

import it.unicam.cs.cardGamesProject.Suit;

/**
 *
 * This class represents how the italian suit is made
 *
 * @author Damiano Pasquini
 *
 */
public class ItalianSuits implements Suit {

    String name;

    ItalianSuits(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

}