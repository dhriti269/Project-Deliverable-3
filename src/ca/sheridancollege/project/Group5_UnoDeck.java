package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;


/**
 * @modifier Dhriti
 * @modifier Tarun
 */


public class Group5_UnoDeck extends GroupOfCards {
    private ArrayList<Group5_UnoCard> discardPile;

    public Group5_UnoDeck() {
        super(108); // Uno deck has 108 cards
        initializeDeck();
        discardPile = new ArrayList<>();
    }

    private void initializeDeck() {
        for (Group5_UnoCard.Color color : Group5_UnoCard.Color.values()) {
            if (color != Group5_UnoCard.Color.WILD) {
                for (Group5_UnoCard.Value value : Group5_UnoCard.Value.values()) {
                    if (value != Group5_UnoCard.Value.WILD && value != Group5_UnoCard.Value.WILD_DRAW_FOUR) {
                        Group5_UnoCard card = new Group5_UnoCard(color, value);
                        getCards().add(card);
                    }
                }
            }
        }
        // Add four copies of each Wild and Wild Draw Four card
        for (int i = 0; i < 4; i++) {
            getCards().add(new Group5_UnoCard(Group5_UnoCard.Color.WILD, Group5_UnoCard.Value.WILD));
            getCards().add(new Group5_UnoCard(Group5_UnoCard.Color.WILD, Group5_UnoCard.Value.WILD_DRAW_FOUR));
        }
        shuffle(); // Shuffle the deck after populating it
    }

    public Group5_UnoCard draw() {
        if (getCards().isEmpty()) {
            reshuffleDiscardPile();
        }
        return (Group5_UnoCard) getCards().remove(0); // Cast the Card object to Group5_UnoCard
    }

    public Group5_UnoCard getTopCard() {
        if (discardPile.isEmpty()) {
            return null;
        }
        return discardPile.get(discardPile.size() - 1);
    }

    public void addToDiscardPile(Group5_UnoCard card) {
        discardPile.add(card);
    }

    private void reshuffleDiscardPile() {
        // Move cards from discard pile to deck, shuffle, and clear the discard pile
        getCards().addAll(discardPile);
        discardPile.clear();
        Collections.shuffle(getCards());
    }
}
