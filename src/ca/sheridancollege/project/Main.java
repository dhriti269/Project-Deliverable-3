package ca.sheridancollege.project;

import java.util.InputMismatchException;

/**
 * 
 * @modifier Dhriti
 * @modifier Tarun
 */

public class Main {
    public static void main(String[] args) {
        Group5_UnoGame unoGame = new Group5_UnoGame("Uno");
        Group5_UnoPlayer player1 = new Group5_UnoPlayer("Player 1");
        Group5_UnoPlayer player2 = new Group5_UnoPlayer("Player 2");

        unoGame.addPlayer(player1);
        unoGame.addPlayer(player2);

        try {
            unoGame.play();
            unoGame.declareWinner();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid number.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
