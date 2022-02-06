package it.unicam.cs.briscolaImplementation;

import it.unicam.cs.cardGamesProject.Player;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * Main class of Briscola Game execution
 *
 * @author Damiano Pasquini
 *
 */
public class MainClass {

    public static void main(String[] args){
        ArrayList<Player> players = new ArrayList<>();
        System.out.println("How many interactive players:");
        Scanner input = new Scanner(System.in);
        int howManyInteractivePlayers = input.nextInt();
        System.out.println("Write players names:");
        for (int i = 0; i < howManyInteractivePlayers; i++)
            players.add(new BriscolaRealPlayer(input.next()));
        System.out.println("How many bot players:");
        int howManyBotPlayers = input.nextInt();
        for (int i = 0; i < howManyBotPlayers; i++)
            players.add(new BriscolaBotPlayer("Bot_"+i));
        BriscolaGame game = new BriscolaGame(players);
        game.startGame();
    }

}