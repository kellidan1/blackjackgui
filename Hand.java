import java.util.ArrayList;

/**
 * Represents a hand of cards in a Blackjack game.
 * A Hand can contain multiple Cards and provides methods for
 * adding cards, retrieving the list of cards, calculating the hand's value,
 * and checking if the hand is soft.
 */
public class Hand {

    private final ArrayList<Card> cards;

    /**
     * Constructs a new empty Hand.
     */
    public Hand() {
        cards = new ArrayList<>();
    }

    /**
     * Adds a Card to the player's Hand.
     *
     * @param card the Card to add to the Hand
     */
    public void addCard(Card card) {
        cards.add(card);
    }

    /**
     * Gets the ArrayList of Cards in the Hand.
     *
     * @return the ArrayList of Cards in the Hand
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * Calculates the total value of the cards in the Hand.
     * Aces are counted as 11 if the total value of the hand is less than or equal to 21,
     * otherwise they are counted as 1.
     *
     * @return the total value of the cards in the Hand
     */
    public int getHandValue() {
        int value = 0;
        for (Card card : cards) {
            value += card.rank().getValue();
        }
        return value;
    }

    public void cleanHand(){
        cards.clear();
    }

}