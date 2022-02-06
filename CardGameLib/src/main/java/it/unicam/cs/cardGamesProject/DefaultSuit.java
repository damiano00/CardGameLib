package it.unicam.cs.cardGamesProject;

/**
 *
 * This class represents a default {@code Suit} of a {@code Card}
 *
 * @author Damiano Pasquini
 *
 */
public class DefaultSuit implements Suit{

    String name;

    public DefaultSuit(String name){
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