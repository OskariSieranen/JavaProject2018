/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RussianRoulette;

import javax.swing.JOptionPane;

/**
 *
 * @author joona
 */
public class Survival {

    public static void main(String[] args) {

        boolean repeat = true;
        int roundcount = 0;
        int firstcardvalue, record = 0;
        String firstcard;

        //Ask player whether he/she already knows the rules. If he/she doesn't know, tutorial starts. If he/she knows, skips the tutorial. 
        int choice2 = JOptionPane.showOptionDialog(null,
                "This is the Survival mode!"
                + "\nAre you familiar with the rules?",
                "Survival",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, null, null);

        //Tutorial
        if (choice2 == JOptionPane.NO_OPTION) {

            JOptionPane.showMessageDialog(null, "GAME RULES:"
                    + "\nEvery turn you'll draw a random card from a normal deck of 52 cards. "
                    + "The goal of the game is survive as many rounds as possible without drawing the Ace of Spades aka \"The Bullet\".");

            JOptionPane.showMessageDialog(null, "Easy! Right?!");

            JOptionPane.showMessageDialog(null, "Well... not exactly. The value of the card that you draw determines how many other cards you'll be drawing that turn.");

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
        //Creates a full deck and shuffles it
        CardDeck playingDeck = new CardDeck();
        playingDeck.createFullDeck();
        playingDeck.shuffle();
        //Creates a hand for the player
        CardDeck playerHand = new CardDeck();
        //Creates a dump deck/hand where drawn cards go after every turn
        CardDeck trashBin = new CardDeck();

        //Draws the first card and shows it to the player
        while (repeat == true) {
            playerHand.draw(playingDeck);
            firstcardvalue = playerHand.cardsValue();
            firstcard = playerHand.toString();
            JOptionPane.showMessageDialog(null, "You drew:" + "\n" + firstcard);

            //If the first card was an ace, shuffles all the drawn cards into the deck
            if (firstcard.contains("ACE") && !firstcard.contains("SPADE-ACE")) {
                JOptionPane.showMessageDialog(null, "All of your drawn cards were shuffled back into the deck");
                playerHand.moveALLcardsToDeck(playingDeck);
                playingDeck.shuffle();
            } //Draws amount of cards determined by the first card and shows them to the player
            else if (!firstcard.contains("SPADE-ACE")) {
                for (int i = 1; i <= firstcardvalue; i++) {
                    playerHand.draw(playingDeck);
                }
                JOptionPane.showMessageDialog(null, "You drew " + firstcardvalue + " cards");
                JOptionPane.showMessageDialog(null, "All cards you drew this turn:" + "\n" + playerHand.toString());
            }
            //If the ace of spades is drawn game ends, and the program shows player how many rounds he/she survived 
            if (playerHand.toString().contains("SPADE-ACE")) {
                JOptionPane.showMessageDialog(null, "BANG!");
                JOptionPane.showMessageDialog(null, "GAME OVER! \n You survived " + roundcount + " rounds");
                repeat = false;
            } else {
                // Adds one round into the roundcount
                roundcount++;
            }
            //Empties hands into a dump deck
            playerHand.moveALLcardsToDeck(trashBin);
            
            // Asks player whether he/she wants to play again. YES = new game starts
            //and the deck gets resuffled; NO = goes back to mode menu
            if (repeat == false) {
                if (roundcount > record){
                    record = roundcount;
                }
                int choice3 = JOptionPane.showOptionDialog(null,
                        "Your record: " + record + " rounds"
                        + "\nAgain?",
                        "Survival",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, null, null);
                if (choice3 == JOptionPane.YES_OPTION) {
                    repeat = true;
                    trashBin.moveALLcardsToDeck(playingDeck);
                    playingDeck.shuffle();
                } else {
                    RussianRouletteGame.main(args);
                }
            }
        }
    }
}
