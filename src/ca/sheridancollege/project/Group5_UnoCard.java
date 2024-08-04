package ca.sheridancollege.project;

/**
 * Represents an UNO card with a color and a value.
 * 
 * @modifier Dhriti
 * @modifier Tarun
 */
public class Group5_UnoCard extends Card {
    public enum Color {
        RED, GREEN, BLUE, YELLOW, WILD
    }

    public enum Value {
        ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, SKIP, REVERSE, DRAW_TWO, WILD, WILD_DRAW_FOUR
    }

    private Color color;
    private Value value;

    public Group5_UnoCard(Color color, Value value) {
        this.color = color;
        this.value = value;
    }

    @Override
    public String toString() {
        return color + " " + value;
    }

    public Color getColor() {
        return color;
    }

    public Value getValue() {
        return value;
    }
}