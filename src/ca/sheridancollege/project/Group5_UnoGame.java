package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @modifier Dhriti
 * @modifier Tarun
 */


public class Group5_UnoGame extends Game {
    private Group5_UnoDeck deck;
    private ArrayList<Group5_UnoPlayer> players;
    private Group5_UnoCard.Color currentColor;
    private Group5_UnoCard.Value currentValue;
    private boolean directionClockwise; // true for clockwise, false for counterclockwise
    private int currentPlayerIndex;

    public Group5_UnoGame(String name) {
        super(name);
        deck = new Group5_UnoDeck();
        players = new ArrayList<>();
        directionClockwise = true; // Start with clockwise direction
        currentPlayerIndex = 0; // Start with the first player

        // Initialize discard pile with an initial card
        Group5_UnoCard initialCard = deck.draw();
        deck.addToDiscardPile(initialCard);
        currentColor = initialCard.getColor();
        currentValue = initialCard.getValue();
    }

    public void addPlayer(Group5_UnoPlayer player) {
        players.add(player);
    }

    @Override
    public void play() {
        // Deal 7 cards to each player
        for (Group5_UnoPlayer player : players) {
            for (int i = 0; i < 7; i++) {
                player.addToHand(deck.draw());
            }
        }

        // Start the game
        boolean gameEnded = false;
        Scanner scanner = new Scanner(System.in);

        while (!gameEnded) {
            Group5_UnoPlayer currentPlayer = players.get(currentPlayerIndex);

            // Display current player's hand and top card on discard pile
            System.out.println("Current Player: " + currentPlayer.getName());
            System.out.println("Top Card: " + deck.getTopCard());

            // Display current player's hand
            System.out.println("Your Hand:");
            for (int i = 0; i < currentPlayer.getHand().size(); i++) {
                System.out.println((i + 1) + ". " + currentPlayer.getHand().get(i));
            }

            // Allow player to play a card
            System.out.println("Choose a card to play (enter index) or draw a card (enter 0):");
            int choice = -1;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.next(); // Clear the invalid input
                continue;
            }

            if (choice == 0) {
                // Draw a card from the deck
                Group5_UnoCard drawnCard = deck.draw();
                currentPlayer.addToHand(drawnCard);
                System.out.println("You drew: " + drawnCard);
            } else {
                Group5_UnoCard selectedCard = null;
                try {
                    selectedCard = currentPlayer.playCard(choice - 1);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Invalid card index! Please try again.");
                    continue;
                }

                if (isValidPlay(selectedCard)) {
                    // Update current color and value if needed
                    if (selectedCard.getValue() != Group5_UnoCard.Value.WILD && selectedCard.getValue() != Group5_UnoCard.Value.WILD_DRAW_FOUR) {
                        currentColor = selectedCard.getColor();
                        currentValue = selectedCard.getValue();
                    }
                    // Handle special card effects
                    handleSpecialCard(selectedCard);
                    // Put the played card on top of the discard pile
                    deck.addToDiscardPile(selectedCard);
                    System.out.println("You played: " + selectedCard);
                } else {
                    // Invalid play, draw a card
                    System.out.println("Invalid play! You must draw a card.");
                    Group5_UnoCard drawnCard = deck.draw();
                    currentPlayer.addToHand(drawnCard);
                    System.out.println("You drew: " + drawnCard);
                }
            }

            // Check if the player has won
            if (currentPlayer.getHand().isEmpty()) {
                gameEnded = true;
            }

            // Move to the next player
            moveNextPlayer();
        }

        scanner.close();
    }

    @Override
    public void declareWinner() {
        Group5_UnoPlayer winner = players.get(currentPlayerIndex);
        System.out.println("Congratulations! " + winner.getName() + " wins!");
    }

    private boolean isValidPlay(Group5_UnoCard card) {
        Group5_UnoCard topCard = deck.getTopCard();
        if (topCard == null) {
            System.out.println("Top card is null. Current discard pile is empty or not initialized.");
            return true; // or return false, depending on your game rules
        }
        return card.getColor() == currentColor || card.getValue() == currentValue || card.getColor() == Group5_UnoCard.Color.WILD || topCard.getColor() == Group5_UnoCard.Color.WILD;
    }

    private void handleSpecialCard(Group5_UnoCard card) {
        // Handle special card effects
    }

    private void moveNextPlayer() {
        if (directionClockwise) {
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        } else {
            currentPlayerIndex = (currentPlayerIndex - 1 + players.size()) % players.size();
        }
    }
}
