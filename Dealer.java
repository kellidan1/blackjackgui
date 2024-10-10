/**
 * Represents the dealer in a Blackjack game.
 * A Dealer has a Hand of cards and can perform actions like hitting
 * (drawing a card) and revealing the first card (up card). It also provides 
 * methods to check the hand value and bust status.
 */
public class Dealer {

  private final Hand hand;

  /**
   * Constructs a Dealer with an empty Hand.
   */
  public Dealer() {
    hand = new Hand();
  }

  /**
   * Deals a card from the provided Deck to the dealer's Hand.
   * 
   * @param deck the Deck to draw a card from
   */
  public void hit(Deck deck) {
    hand.addCard(deck.dealCard());
  }

  /**
   * Gets the dealer's Hand containing the cards they have been dealt.
   * 
   * @return the dealer's Hand
   */
  public Hand getHand() {
    return hand;
  }

  /**
   * Calculates and returns the current total value of the dealer's Hand.
   * 
   * @return the total value of the dealer's Hand
   */
  public int getHandValue() {
    return hand.getHandValue();
  }

  /**
   * Checks if the dealer's Hand value is greater than 21 (bust).
   * 
   * @return true if the dealer is bust, false otherwise
   */
  public boolean isBust() {
    return getHandValue() > 21;
  }

  public boolean hasWon() {
    return getHandValue() == 21;
  }

  /**
   * Retrieves the dealer's first (up) card.
   * 
   * @return the dealer's up card
   */
  public Card getUpCard() {
    return hand.getCards().get(0);
  }


}