import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents a deck of cards used in a Blackjack game.
 * A Deck contains a collection of Cards and provides methods for 
 * shuffling the deck, dealing cards, and checking if the deck is empty.
 */
public class Deck {

  private final ArrayList<Card> cards;

  /**
   * Constructs a new Deck containing all possible combinations of Suits and Ranks.
   */
  public Deck() {
    cards = new ArrayList<>();
    for (Suit suit : Suit.values()) {
      for (Rank rank : Rank.values()) {
        cards.add(new Card(suit, rank));
      }
    }
  }

  /**
   * Shuffles the cards in the Deck randomly.
   */
  public void shuffle() {
    Collections.shuffle(cards);
  }

  /**
   * Deals the top card (the last card) from the Deck and removes it.
   * 
   * @return the dealt Card
   */
  public Card dealCard() {
    return cards.remove(cards.size() - 1);
  }

  /**
   * Checks if the Deck is empty (contains no more cards).
   * 
   * @return true if the Deck is empty, false otherwise
   */
  public boolean isEmpty() {
    return cards.isEmpty();
  }
}