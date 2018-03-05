/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RussianRoulette;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author joona
 */
public class RussianRouletteGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String special;

        //Ask player whether he/she already knows the rules. If he/she doesn't know, tutorial starts. If he/she knows, skips the tutorial. 
        int choice = JOptionPane.showOptionDialog(null,
                "Welcome to Russsian Roulette!"
                + "\nAre you familiar with the rules?",
                "Russian Roulette",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, null, null);

        //Tutorial
        if (choice == JOptionPane.NO_OPTION) {

            JOptionPane.showMessageDialog(null, "GAME RULES:"
                    + "\nEvery turn you will draw a random card from a deck of 52 cards."
                    + "The goal of the game is survive as many turns as possible without drawing the Ace of Spades aka \"The Bullet\".");

            JOptionPane.showMessageDialog(null, "Easy! Right?!");

            JOptionPane.showMessageDialog(null, "Well... there is a twist to it. The value of the card that you draw will determine how many other cards you'll be drawing that turn.");

            JOptionPane.showMessageDialog(null, "This is how it works:"
                    + "\nTWO = Draw 2 Cards"
                    + "\nTHREE = Draw 3 Cards"
                    + "\nFOUR = Draw 4 Cards"
                    + "\nFIVE = Draw 5 Cards"
                    + "\nSIX = Draw 1 Card"
                    + "\nSEVEN = Draw 2 Cards"
                    + "\nEIGHT = Draw 3 Cards" + " and so on..");

            JOptionPane.showMessageDialog(null, "The face cards are safe cards. If you happen draw one of them, you won't need to draw any other cards that turn.");

            JOptionPane.showMessageDialog(null, "But what you want to be drawing are the Aces, exept \"The Bullet\" of course...");

            JOptionPane.showMessageDialog(null, "If you happen draw one of the three Aces, the deck will reset and all the cards that you've drawn will be put back in the deck. The game however continues!");

            JOptionPane.showMessageDialog(null, "So... you got the rules right?");

            JOptionPane.showMessageDialog(null, "If so, press that OK-button once more and the game will start. Have fun playing and be careful not to blast your brains out!");
        }
         //Creating a full shuffled deck
        CardDeck playingDeck = new CardDeck();
        playingDeck.createFullDeck();
        playingDeck.shuffle();
        //This is players hand
        CardDeck playerHand = new CardDeck();
        
        //Draw a Card
         playerHand.draw(playingDeck);
         JOptionPane.showMessageDialog(null, "You drew:" + "\n" + playerHand.toString());
         special = playerHand.toString();
         
         //Drawing more Cards
         
             
         for (int i = 1; i <= playerHand.cardsValue(); i++) {
             playerHand.draw(playingDeck);
         }
         JOptionPane.showMessageDialog(null, "You drew " + playerHand.cardsValue() + " cards");
         JOptionPane.showMessageDialog(null, "Now you have: " + playerHand.toString());

    }

}
