/**
 * Represents a single card in a Blackjack game.
 * <p>
 * A Card has a Suit and a Rank.
 */
public record Card(Suit suit, Rank rank) {

  /**
   * Constructs a Card with a specified Suit and Rank.
   *
   * @param suit the Suit of the Card
   * @param rank the Rank of the Card
   */
  public Card {
  }

  /**
   * Gets the Suit of the Card.
   *
   * @return the Suit of the Card
   */
  @Override
  public Suit suit() {
    return suit;
  }

  /**
   * Gets the Rank of the Card.
   *
   * @return the Rank of the Card
   */
  @Override
  public Rank rank() {
    return rank;
  }

  /**
   * Overrides the default toString() method to provide a human-readable representation of the Card.
   *
   * @return a string representation of the Card in the format "Rank of Suit" (e.g., "Ten of Hearts")
   */
  @Override
  public String toString() {
    return rank + " of " + suit;
  }
}