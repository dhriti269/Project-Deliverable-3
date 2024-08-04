package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * Represents a player in the UNO game.
 * 
 * @modifier Dhriti
 * @modifier Tarun
 */
public class Group5_UnoPlayer extends Player {
    private ArrayList<Group5_UnoCard> hand;

    public Group5_UnoPlayer(String name) {
        super(name);
        hand = new ArrayList<>();
    }

    public void addToHand(Group5_UnoCard card) {
        hand.add(card);
    }

    public Group5_UnoCard playCard(int index) {
        return hand.remove(index);
    }

    public ArrayList<Group5_UnoCard> getHand() {
        return hand;
    }

    @Override
    public void play() {
        // Logic to play Uno
    }
}
