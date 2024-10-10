/**
 * An enumeration representing the rank of a card in a Blackjack game.
 * 
 * Each rank has a corresponding value used for calculating the score 
 * of a hand.
 */
public enum Rank {

  /** The rank Two with a value of 2. */
  TWO(2),

  /** The rank Three with a value of 3. */
  THREE(3),

  /** The rank Four with a value of 4. */
  FOUR(4),

  /** The rank Five with a value of 5. */
  FIVE(5),

  /** The rank Six with a value of 6. */
  SIX(6),

  /** The rank Seven with a value of 7. */
  SEVEN(7),

  /** The rank Eight with a value of 8. */
  EIGHT(8),

  /** The rank Nine with a value of 9. */
  NINE(9),

  /** The rank Ten with a value of 10. */
  TEN(10),

  /** The rank Jack with a value of 10. */
  JACK(10),

  /** The rank Queen with a value of 10. */
  QUEEN(10),

  /** The rank King with a value of 10. */
  KING(10),

  /** The rank Ace with a value of 11. */
  ACE(11);

  private final int value;

  /**
   * Constructs a Rank with its corresponding value.
   * 
   * @param value the value of the Rank
   */
  Rank(int value) {
    this.value = value;
  }

  /**
   * Gets the value of the Rank used for calculating the score of a hand.
   * 
   * @return the value of the Rank
   */
  public int getValue() {
    return value;
  }
}