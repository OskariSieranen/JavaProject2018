/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RussianRoulette;

import javax.swing.JOptionPane;

/**
 * This is a game mode called Versus (Russian Roulette) and it is played against the computer.
 * The idea is to take turns drawing playing cards from a deck of 52 cards one at a time.
 * The value of the first card drawn in a turn, determines how many other cards must be drawn.
 * The one who draws the Ace of Spades first loses.
 * @author joona
 */
public class Versus {
    
    public static void main(String[] args) {
        
        int firstcardvalue, wins = 0, losses = 0;
        String firstcard;
        boolean repeat = true;

        //Asks player whether he/she already knows the rules. If he/she doesn't know, tutorial starts. If he/she knows, skips the tutorial. 
        int choice2 = JOptionPane.showOptionDialog(null,
                "This is the Versus mode!"
                + "\nAre you familiar with the rules?",
                "Versus",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, null, null);

        //Tutorial
        if (choice2 == JOptionPane.NO_OPTION) {
            
            JOptionPane.showMessageDialog(null, "GAME RULES:"
                    + "\nYou are playing against a computer."
                    + "\nYou and your opponent are taking turns of drawing cards from a normal deck of 52 cards."
                    + "The goal of the game is to avoid drawing the Ace of Spades aka \"The Bullet\".");
            
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
            
            JOptionPane.showMessageDialog(null, "The face cards are safe cards. If a player happens to draw one of them, he won't need to draw any other cards that turn.");
            
            JOptionPane.showMessageDialog(null, "But what you want to be drawing, are the Aces. Exept \"The Bullet\" of course...");
            
            JOptionPane.showMessageDialog(null, "If one of the players happens draw one of the three Aces, the opponent has to draw 5 extra cards.");
            
            JOptionPane.showMessageDialog(null, "So... you got the rules right?");
            
            JOptionPane.showMessageDialog(null, "If so, press that OK-button once more and the game will start. Have fun playing and be careful not to blast your brains out!");
        }
        //Creates a full shuffled deck
        CardDeck playingDeck = new CardDeck();
        playingDeck.createFullDeck();
        playingDeck.shuffle();
        //Creates a hand for the player
        CardDeck playerHand = new CardDeck();
        //Creates a hand for the computer
        CardDeck cpuHand = new CardDeck();
        //Creates a dump deck/hand where drawn cards go after every turn
        CardDeck trashBin = new CardDeck();

        //Repeats the game (turns) until Ace of Spades is drawn
        while (repeat == true) {
            //The first card gets drawn and showed to the player
            playerHand.draw(playingDeck);
            firstcardvalue = playerHand.cardsValue();
            firstcard = playerHand.toString();
            JOptionPane.showMessageDialog(null, "You drew:" + "\n" + firstcard);
            
            //Checks if a normal Ace was drawn, and if it was, draws 5 cards to the opponent and shows them
            if (firstcard.contains("ACE") && !firstcard.contains("SPADE-ACE")) {
                JOptionPane.showMessageDialog(null, "Your opponent draws 5 cards");
                for (int i = 1; i <= 5; i++) {
                    cpuHand.draw(playingDeck);
                }
                JOptionPane.showMessageDialog(null, "All cards your opponent drew this turn:" + "\n" + cpuHand.toString());
            } //Player draws more cards determined by the value of the first card
            else if (!firstcard.contains("SPADE-ACE")) {
                for (int i = 1; i <= firstcardvalue; i++) {
                    playerHand.draw(playingDeck);
                }
                JOptionPane.showMessageDialog(null, "You drew " + firstcardvalue + " cards");
                JOptionPane.showMessageDialog(null, "All cards you drew this turn:" + "\n" + playerHand.toString());
            }
            //Checks if "The Bullet" was drawn. If it was game ends and the winner gets announced 
            if (playerHand.toString().contains("SPADE-ACE")) {
                JOptionPane.showMessageDialog(null, "BANG!");
                JOptionPane.showMessageDialog(null, "You lost!\nBetter luck next time...I guess...");
                losses++;
                repeat = false;
            } else if (cpuHand.toString().contains("SPADE-ACE")) {
                JOptionPane.showMessageDialog(null, "BANG!");
                JOptionPane.showMessageDialog(null, "You won!\nCongratulations!");
                wins++;
                repeat = false;
            } 
            //Executes opponents turn only if "The Bullet" wasn't drawn
            else {
                //Empties hands into a dump deck
                playerHand.moveALLcardsToDeck(trashBin);
                cpuHand.moveALLcardsToDeck(trashBin);
                // Computer draws a card
                cpuHand.draw(playingDeck);
                firstcardvalue = cpuHand.cardsValue();
                firstcard = cpuHand.toString();
                JOptionPane.showMessageDialog(null, "Your opponent drew:" + "\n" + firstcard);
                
                //Checks if a normal Ace was drawn, and if it was, draws 5 cards to the player and shows them
                if (firstcard.contains("ACE") && !firstcard.contains("SPADE-ACE")) {
                    JOptionPane.showMessageDialog(null, "You draw 5 cards");
                    for (int i = 1; i <= 5; i++) {
                        playerHand.draw(playingDeck);
                    }
                    JOptionPane.showMessageDialog(null, "All cards you drew this turn:" + "\n" + playerHand.toString());
                } //Computer draws more cards determined by the value of the first card
                else if (!firstcard.contains("SPADE-ACE")) {
                    for (int i = 1; i <= firstcardvalue; i++) {
                        cpuHand.draw(playingDeck);
                    }
                    JOptionPane.showMessageDialog(null, "Opponent drew " + firstcardvalue + " cards");
                    JOptionPane.showMessageDialog(null, "All cards your opponent drew this turn:" + "\n" + cpuHand.toString());
                }
                //Checks if "The Bullet" was drawn. If it was game ends and the winner gets announced 
                if (playerHand.toString().contains("SPADE-ACE")) {
                    JOptionPane.showMessageDialog(null, "BANG!");
                    JOptionPane.showMessageDialog(null, "You lost!\nBetter luck next time...I guess...");
                    losses++;
                    repeat = false;
                } else if (cpuHand.toString().contains("SPADE-ACE")) {
                    JOptionPane.showMessageDialog(null, "BANG!");
                    JOptionPane.showMessageDialog(null, "You won!\nCongratulations!");
                    wins++;
                    repeat = false;
                }
            }
            //Empties hands into a dump deck
            playerHand.moveALLcardsToDeck(trashBin);
            cpuHand.moveALLcardsToDeck(trashBin);
            //Asks player whether he/she wants to play again. YES = new game starts
            //and the deck gets resuffled; NO = goes back to mode menu
            if (repeat == false) {
                int choice3 = JOptionPane.showOptionDialog(null,
                        "Wins: " + wins
                        + "Losses: " + losses        
                        + "\nAgain?",
                        "Versus",
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
