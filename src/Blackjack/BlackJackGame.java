/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// idea: if the player gets blackjack in the first 2 cards multiply his bet by 2 or sumthing.
package Blackjack;

import javax.swing.*;

/**
 *
 * @author Pate
 */
public class BlackJackGame {

    public static void main(String[] args) {

        //Welcome the user
        JOptionPane.showMessageDialog(null, "Welcome to my Blackjack table, take a seat");

        //Creating a full shuffled deck
        CardDeck playingDeck = new CardDeck();
        playingDeck.createFullDeck();
        playingDeck.shuffle();
        //This is players hand
        CardDeck playerDeck = new CardDeck();

        //dealers "hand"
        CardDeck dealerDeck = new CardDeck();

        double chips = Double.parseDouble(JOptionPane.showInputDialog(null, "How much would you like to invest in chips? "));

        JOptionPane.showMessageDialog(null, "You purchased " + chips + " in chips");

        //Game Loop
        while (chips > 0) {
            //Game starts
            //ill ask how much does the player want to bet
            double bet = Double.parseDouble(JOptionPane.showInputDialog(null, "You have $ " + chips + " in chips, how much do you want to bet"));
            if (bet > chips) {
                JOptionPane.showMessageDialog(null, "You cannot bet more than you have! ");
                break;
            }

            boolean endRound = false;

            //Card dealing begins
            //in blackjack the player gets 2 cards at the start of round
            playerDeck.draw(playingDeck);
            playerDeck.draw(playingDeck);

            //Dealer also gets two cards
            dealerDeck.draw(playingDeck);
            dealerDeck.draw(playingDeck);

            while (true) {
                JOptionPane.showMessageDialog(null, "Your hand: " + playerDeck.toString() + "\nYour hands value is: " + playerDeck.cardsValue());
                //JOptionPane.showMessageDialog(null, playerDeck.toString());
                //JOptionPane.showMessageDialog(null, "Your hands value is: " + playerDeck.cardsValue());

                //Show dealers hand
                JOptionPane.showMessageDialog(null, "Dealers hand: " + "\n" + dealerDeck.getCard(0).toString() + "\n[UNKNOWN]");

                //Player will now decide if he wants to stay or hit
                //System.out.println("Do you want to (1) Hit or (2) Stay?");
                int response = JOptionPane.showOptionDialog(null,
                        "Do you want to hit?"
                        + "\nChoose yes to hit, no to stay?",
                        "BlackJackGame",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, null, null);
                //Player hits
                if (response == JOptionPane.YES_OPTION) {
                    playerDeck.draw(playingDeck);
                    JOptionPane.showMessageDialog(null, "You draw a: " + playerDeck.getCard(playerDeck.deckSize() - 1).toString());
                    if (playerDeck.cardsValue() > 21) {
                        JOptionPane.showMessageDialog(null, "Bust");
                        chips -= bet;
                        endRound = true;
                        break;
                    }
                }
                //Dealer hitting
                if (response == JOptionPane.NO_OPTION) {
                    //dealer will keep hitting untill his hand value is  at 17 or higher
                    while ((dealerDeck.cardsValue() < 17) && endRound == false) {
                        dealerDeck.draw(playingDeck);
                        JOptionPane.showMessageDialog(null, "Dealer draws: " + dealerDeck.getCard(dealerDeck.deckSize() - 1).toString());

                    }
                    //lets show the dealers hand value
                    JOptionPane.showMessageDialog(null, "Dealers hand is valued at: " + dealerDeck.cardsValue());
                    break;
                }
            }
            //lets see if the dealer busted
            if ((dealerDeck.cardsValue() > 21) && endRound == false) {
                JOptionPane.showMessageDialog(null, "Dealer busts. Congratulations you won");
                chips += bet;
                endRound = true;

            }
            //Lets show what cards the dealer has in hands
            JOptionPane.showMessageDialog(null, "Dealer Cards: " + dealerDeck.toString());
            //lets check if dealer has more points than player
            if (dealerDeck.cardsValue() > playerDeck.cardsValue() && endRound == false) {
                JOptionPane.showMessageDialog(null, "You lose");
                chips -= bet;
                endRound = true;
            }

            //lets see if the dealer and player ties
            if ((playerDeck.cardsValue() == dealerDeck.cardsValue()) && endRound == false) {
                JOptionPane.showMessageDialog(null, "Its a tie ");
                endRound = true;
            }

            if ((playerDeck.cardsValue() > dealerDeck.cardsValue() && endRound == false)) {
                JOptionPane.showMessageDialog(null, "You win ");
                chips += bet;

            } else if (endRound == false) {
                JOptionPane.showMessageDialog(null, "You lost that round.");
                chips -= bet;

            }

            playerDeck.moveALLcardsToDeck(playingDeck);
            dealerDeck.moveALLcardsToDeck(playingDeck);

            JOptionPane.showMessageDialog(null, "Time for a next round. ");

        }

        JOptionPane.showMessageDialog(null, "Game over! ");

    }

}
