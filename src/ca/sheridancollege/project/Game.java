package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 *
 * @author Dhriti
 * @author Tarun
 */

public abstract class Game {
    private final String name;
    private ArrayList<Group5_UnoPlayer> players; // Changed to Group5_UnoPlayer
    private Scanner input;

    public Game(String name) {
        this.name = name;
        players = new ArrayList<>();
        input = new Scanner(System.in);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Group5_UnoPlayer> getPlayers() { // Changed to Group5_UnoPlayer
        return players;
    }

    public void setPlayers(ArrayList<Group5_UnoPlayer> players) { // Changed to Group5_UnoPlayer
        this.players = players;
    }

    public abstract void play();

    public abstract void declareWinner();

    
    public void registerPlayer() {
        System.out.print("Enter player name: ");
        String playerName = input.nextLine();
        Group5_UnoPlayer player = new Group5_UnoPlayer(playerName); // Updated to Group5_UnoPlayer
        players.add(player);
        System.out.println(playerName + " has been registered with the game.");
    }
}
