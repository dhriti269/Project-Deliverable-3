
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @modifier Dhriti
 * @modifier Tarun
 
 */

public class GroupOfCards {

    private ArrayList<Card> cards;
    private int size;

    public GroupOfCards(int size) {
        this.size = size;
        cards = new ArrayList<>();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}