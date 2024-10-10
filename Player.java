/**
 * Represents a player in a Blackjack game.
 * A Player has a Hand of cards and can perform actions like hitting 
 * (drawing a card) and checking their hand's value.
 */
public class Player {

  private final Hand hand;

  /**
   * Constructs a Player with an empty Hand.
   */
  public Player() {
    hand = new Hand();
  }

  /**
   * Deals a card from the provided Deck to the player's Hand.
   * 
   * @param deck the Deck to draw a card from
   */
  public void hit(Deck deck) {
    hand.addCard(deck.dealCard());
  }

  /**
   * Gets the player's Hand containing the cards they have been dealt.
   * 
   * @return the player's Hand
   */
  public Hand getHand() {
    return hand;
  }

  /**
   * Calculates and returns the current total value of the player's Hand.
   * 
   * @return the total value of the player's Hand
   */
  public int getHandValue() {
    return hand.getHandValue();
  }

  /**
   * Checks if the player's Hand value is greater than 21 (bust).
   * 
   * @return true if the player is bust, false otherwise
   */
  public boolean isBust() {
    return getHandValue() > 21;
  }

  public boolean hasWon(){
    return getHandValue() == 21;
  }

  public void resetHand() {
    hand.cleanHand();
  }
}