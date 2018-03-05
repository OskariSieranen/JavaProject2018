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

        Object[] options = {"Survival", "Versus"};
        int mode = JOptionPane.showOptionDialog(null,
                "Welcome to Russian Roulette! \nWhat mode would you like to play?",
                "Russian Roulette",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options, null);

        if (mode == JOptionPane.YES_OPTION) {
            int roundcount = -1;
            int firstcardvalue;
            String firstcard;

            //Ask player whether he/she already knows the rules. If he/she doesn't know, tutorial starts. If he/she knows, skips the tutorial. 
            int choice = JOptionPane.showOptionDialog(null,
                    "This is the Survival mode!"
                    + "\nAre you familiar with the rules?",
                    "Survival",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, null, null);

            //Tutorial
            if (choice == JOptionPane.NO_OPTION) {

                JOptionPane.showMessageDialog(null, "GAME RULES:"
                        + "\nEvery turn you will draw a random card from a deck of 52 cards."
                        + "The goal of the game is survive as many rounds as possible without drawing the Ace of Spades aka \"The Bullet\".");

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
            while (!playerHand.toString().contains("ACE OF SPADES")) {
                playerHand.draw(playingDeck);
                firstcardvalue = playerHand.cardsValue();
                firstcard = playerHand.toString();
                JOptionPane.showMessageDialog(null, "You drew:" + "\n" + firstcard);

                if (firstcard.contains("ACE")) {
                    JOptionPane.showMessageDialog(null, "Your drawn cards were shuffled in the deck");
                    playerHand.moveALLcardsToDeck(playingDeck);
                } //Drawing more Cards
                else {
                    for (int i = 1; i <= firstcardvalue; i++) {
                        playerHand.draw(playingDeck);
                    }
                    JOptionPane.showMessageDialog(null, "You drew " + firstcardvalue + " cards");
                    JOptionPane.showMessageDialog(null, "Now you have: " + playerHand.toString());
                }
                roundcount++;
            }
            JOptionPane.showMessageDialog(null, "GAME OVER! \n You survived " + roundcount + " rounds");
        }
        if (mode == JOptionPane.NO_OPTION) {
            int firstcardvalue;
            String firstcard;
            boolean repeat = true;

            //Ask player whether he/she already knows the rules. If he/she doesn't know, tutorial starts. If he/she knows, skips the tutorial. 
            int choice = JOptionPane.showOptionDialog(null,
                    "This is the Versus mode!"
                    + "\nAre you familiar with the rules?",
                    "Versus",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, null, null);

            //Tutorial
            if (choice == JOptionPane.NO_OPTION) {

                JOptionPane.showMessageDialog(null, "GAME RULES:"
                        + "\nYou are playing against a computer."
                        + "\nYou and your opponent are taking turns of drawing cards from a deck of 52 cards."
                        + "The goal of the game is to avoid drawing the Ace of Spades aka \"The Bullet\".");

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

                JOptionPane.showMessageDialog(null, "The face cards are safe cards. If a player draws one of them, he won't need to draw any other cards that turn.");

                JOptionPane.showMessageDialog(null, "But what you want to be drawing are the Aces, exept \"The Bullet\" of course...");

                JOptionPane.showMessageDialog(null, "If one happens draw one of the three Aces, the opponent has to draw 5 extra cards ");

                JOptionPane.showMessageDialog(null, "So... you got the rules right?");

                JOptionPane.showMessageDialog(null, "If so, press that OK-button once more and the game will start. Have fun playing and be careful not to blast your brains out!");
            }
            //Creating a full shuffled deck
            CardDeck playingDeck = new CardDeck();
            playingDeck.createFullDeck();
            playingDeck.shuffle();
            CardDeck playerHand = new CardDeck();
            CardDeck cpuHand = new CardDeck();
            CardDeck trashBin = new CardDeck();

            //Player draws a Card
            while (repeat == true) {
                //This is players hand
                playerHand.draw(playingDeck);
                firstcardvalue = playerHand.cardsValue();
                firstcard = playerHand.toString();
                JOptionPane.showMessageDialog(null, "You drew:" + "\n" + firstcard);

                if (firstcard.contains("ACE OF SPADES")) {

                } else if (firstcard.contains("ACE")) {
                    JOptionPane.showMessageDialog(null, "Your opponent drew 5 cards");
                    for (int i = 1; i <= 5; i++) {
                        cpuHand.draw(playingDeck);
                    }
                    JOptionPane.showMessageDialog(null, "Your opponent now has:" + "\n" + cpuHand.toString());
                } //Player draws more cards
                else {
                    for (int i = 1; i <= firstcardvalue; i++) {
                        playerHand.draw(playingDeck);
                    }
                    JOptionPane.showMessageDialog(null, "You drew " + firstcardvalue + " cards");
                    JOptionPane.showMessageDialog(null, "Now you have:" + "\n" + playerHand.toString());
                }
                //Checks if "The Bullet" was drawn. If it was game ends. 
                if (playerHand.toString().contains("ACE OF SPADES")) {
                    JOptionPane.showMessageDialog(null, "BANG!");
                    JOptionPane.showMessageDialog(null, "You lost!\nBetter luck next time...I guess...");
                    repeat = false;
                }
                if (cpuHand.toString().contains("ACE OF SPADES")) {
                    JOptionPane.showMessageDialog(null, "BANG!");
                    JOptionPane.showMessageDialog(null, "You won!\nCongratulations!");
                    repeat = false;
                } else {
                    //Empties hands into a dump deck
                    playerHand.moveALLcardsToDeck(trashBin);
                    cpuHand.moveALLcardsToDeck(trashBin);
                    // Computer draws a card
                    cpuHand.draw(playingDeck);
                    firstcardvalue = cpuHand.cardsValue();
                    firstcard = cpuHand.toString();
                    JOptionPane.showMessageDialog(null, "Your opponent drew:" + "\n" + firstcard);

                    if (firstcard.contains("ACE OF SPADES")) {

                    } else if (firstcard.contains("ACE")) {
                        JOptionPane.showMessageDialog(null, "You drew 5 cards");
                        for (int i = 1; i <= 5; i++) {
                            playerHand.draw(playingDeck);
                        }
                        JOptionPane.showMessageDialog(null, "You now have:" + "\n" + playerHand.toString());

                    } //Computer draws more cards
                    else {
                        for (int i = 1; i <= firstcardvalue; i++) {
                            cpuHand.draw(playingDeck);
                        }
                        JOptionPane.showMessageDialog(null, "Opponent drew " + firstcardvalue + " cards");
                        JOptionPane.showMessageDialog(null, "Your opponent now has:" + "\n" + cpuHand.toString());
                    }
                    //Checks if "The Bullet" was drawn. If it was game ends. 
                    if (playerHand.toString().contains("ACE OF SPADES")) {
                        JOptionPane.showMessageDialog(null, "BANG!");
                        JOptionPane.showMessageDialog(null, "You lost!\nBetter luck next time...I guess...");
                        repeat = false;
                    }
                    if (cpuHand.toString().contains("ACE OF SPADES")) {
                        JOptionPane.showMessageDialog(null, "BANG!");
                        JOptionPane.showMessageDialog(null, "You won!\nCongratulations!");
                        repeat = false;
                    }
                    //Empties hands into a dump deck
                    playerHand.moveALLcardsToDeck(trashBin);
                    cpuHand.moveALLcardsToDeck(trashBin);
                }
            }
        }
    }
}
