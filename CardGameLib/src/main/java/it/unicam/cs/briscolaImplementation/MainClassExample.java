package it.unicam.cs.briscolaImplementation;


import it.unicam.cs.cardGamesProject.Player;

import java.util.ArrayList;

/**
 *
 * This is a Main class containing an example execution of a briscola match
 *
 * @author Damiano Pasquini
 *
 */
public class MainClassExample {

    public static void main(String[] args){
        System.out.println("- EXAMPLE BRISCOLA MATCH PLAYED BY THREE BOT PLAYERS -");
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < 3; i++)
            players.add(new BriscolaBotPlayer("Bot_"+(i+1)));
        BriscolaGame game = new BriscolaGame(players);
        game.startGame();
    }

}
