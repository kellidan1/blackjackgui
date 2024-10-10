import javax.swing.*;
import java.awt.event.*;

public class blackjack extends JDialog {
    private final Player player;
    private final Deck deck;
    private final Dealer dealer;
    boolean isRuleDisplayed = false;
    int flag=0;
    private JPanel contentPane;
    private JButton buttonCancel;
    private JButton standButton;
    private JButton hitButton;
    private JLabel label;
    private JButton yesButton;
    private JButton noButton;
    private JButton RuleButton;
    private JLabel label1;
    private String input;

    public void replay(int i) {
        if (i == 0) {
            yesButton.setVisible(false);
            noButton.setVisible(false);
            standButton.setVisible(true);
            hitButton.setVisible(true);
            buttonCancel.setVisible(true);
            RuleButton.setVisible(false);
            label1.setVisible(false);
        }
        else {
            yesButton.setVisible(true);
            noButton.setVisible(true);
            standButton.setVisible(false);
            hitButton.setVisible(false);
            buttonCancel.setVisible(false);
            RuleButton.setVisible(true);
            label1.setVisible(false);
        }
    }

    public blackjack() {
        setContentPane(contentPane);
        setTitle("Blackjack Game");

        setModal(true);

        ImageIcon icon = new ImageIcon(getClass().getResource("blackjack.png"));
        setIconImage(icon.getImage());
        // Setup initial UI
        label.setText("Welcome to Blackjack! Do you want to play?");
        buttonCancel.addActionListener(e -> onCancel());
        noButton.addActionListener(e -> {
            if (!isRuleDisplayed) {
                onCancel();
            } else {
                replay(1);
                isRuleDisplayed = false;
                noButton.setText("No");
                label.setVisible(true);
            }
        });

        replay(1);

        // Instantiate a new Player, Deck and Dealer
        player = new Player();
        deck = new Deck();
        dealer = new Dealer();

        // Shuffle the deck
        deck.shuffle();

        // Set up the Player Hit
        hitButton.addActionListener(e -> {
            player.hit(deck);
            StringBuilder message = new StringBuilder();
            String playerHand = player.getHand().getCards() + " (Value: " + player.getHandValue() + ")";
            message.append("Your hand: ").append(playerHand);
            if(deck.isEmpty()){
                label1.setText("Deck Empty. GAME OVER");
                label1.setVisible(true);
                yesButton.setVisible(false);
                noButton.setVisible(false);
                standButton.setVisible(false);
                hitButton.setVisible(false);
                buttonCancel.setText("Exit");
                buttonCancel.setVisible(true);
                RuleButton.setVisible(false);
                label.setVisible(false);
            }
            else if (player.isBust()) {
                message.append("<br>Bust! You lose.<br>Do you want to play again?<br>");
                message.append("Dealer's hand: ").append(dealer.getHand().getCards()).append(" Value:").append(dealer.getHandValue());
                replay(1);
                player.resetHand();
            } else if (player.getHandValue()==21) {
                message.append("<br>You won.<br>Do you want to play again?<br>");
                message.append("Dealer's hand: ").append(dealer.getHand().getCards()).append(" Value:").append(dealer.getHandValue());
                replay(1);
                player.resetHand();
            } else {
                update_player_display();  // Update the UI to show the new hand
            }
            label.setText("<html>"+message+"</html>");
        });

        standButton.addActionListener(e -> {
            // Start Dealer Logic
            startDealer();
            update_dealer_Display();
        });

        RuleButton.addActionListener(e -> {
            pack(); // Adjust the dialog size to fit its content
            label1.setVisible(true);
            label.setVisible(false);
            label1.setText("<html>Blackjack Rules<br><u>Objective:</u><br>To beat the dealer by having a higher card total without going over 21<br><br><u>Card Values:</u><br>2 to 10 = Face Value<br>Jack, Queen, King = 10<br>Ace = 11<br>Note: The card suits are irrelevant in Blackjack.<br><br><u>Definitions:</u><br>Hit = draw another card<br>Stand = take no more cards<br>Bust = going over 21<br><br><u>How to Play:</u><br>Player starts with an empty hand.<br>The player is asked to hit or stand.<br>If player stands on first turn with empty hand or if player busts, the player loses.<br>If player does not bust and if dealer busts, player wins.<br>If player gets higher card total then dealer, player wins.If dealer gets higher card total then player, dealer wins.If player and dealer get same card total, push occurs.<br><br><br></html>");
            setSize(getPreferredSize().width + 50, getPreferredSize().height + 50); // Add padding

            // Center the dialog on the screen
            setLocationRelativeTo(null);

            RuleButton.setVisible(false);
            yesButton.setVisible(false);
            noButton.setText("Back");
            isRuleDisplayed = true;
        });

        yesButton.addActionListener(e -> {
            label.setText("Game starts. Do you want to hit or stand?");
            replay(0);
        });

        // Call onCancel() when cross is clicked
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onCancel() {
        dispose();
    }

    private void update_player_display() {
        StringBuilder message = new StringBuilder();
        String playerHand = player.getHand().getCards() + " (Value: " + player.getHandValue() + ")";
        message.append("Your hand: ").append(playerHand);
        if (player.isBust()) {
            message.append("<br>Bust! You lose.<br>Do you want to play again?<br>");
            message.append("Dealer's hand: ").append(dealer.getHand().getCards()).append(" Value:").append(dealer.getHandValue());
            replay(1);
            player.resetHand();
        } else if (player.hasWon()) {
            message.append("<br>Yay! You Win.<br>Do you want to play again?<br>");
            message.append("Dealer's hand: ").append(dealer.getHand().getCards()).append(" Value:").append(dealer.getHandValue());
            replay(1);
            player.resetHand();
        }
        label.setText("<html>" + message + "</html>");
    }

    private void update_dealer_Display() {
        StringBuilder message = new StringBuilder();
        String playerHand = player.getHand().getCards() + " (Value: " + player.getHandValue() + ")";
        String dealerHand = dealer.getHand().getCards() + " (Value: " + dealer.getHandValue() + ")";

        message.append("Your hand: ").append(playerHand).append("<br>");
        message.append("Dealer's hand: ").append(dealerHand).append("<br>");

        // Update the label text based on the game state
        if (player.isBust()) {
            message.append("Your hand: ").append(playerHand);
            message.append("Bust! You lose.");
        } else if (dealer.isBust()) {
            message.append("Your hand: ").append(playerHand);
            message.append("Dealer busts! You win.");
        } else if (player.hasWon()) {
            message.append("Your hand: ").append(playerHand);
            message.append("Yay! You Win with 21.");
            player.resetHand();
        } else if (dealer.hasWon()) {
            message.append("Your hand: ").append(playerHand);
            message.append("Sorry! Dealer won with 21.");
            player.resetHand();
        } else {
            int dealer_diff = 21 - dealer.getHandValue();
            int player_diff = 21 - player.getHandValue();
            if (dealer_diff > player_diff) {
                message.append("Yay! You got closer to 21! You win.");
            } else {
                message.append("Sorry! Dealer got closer to 21! You lose.");
            }
            player.resetHand();
        }
        replay(1);
        label.setText("<html>" + message + "<br>Do you want to play again?<br>" + "</html>");
    }

    public void startDealer() {
        while (dealer.getHandValue() < 10) {
            dealer.hit(deck);
            if(dealer.getHandValue() > 10){
                flag=1;
            }
        }
        /*if (flag==1) {
            dealer.hit(deck);
            flag=0;
        }*/

    }

    public static void main(String[] args) {
        blackjack blackjackInstance = new blackjack();
        blackjackInstance.setSize(700, 300); // Set initial size
        // Center the dialog on the screen
        blackjackInstance.setLocationRelativeTo(null);
        blackjackInstance.setVisible(true);
    }
}
