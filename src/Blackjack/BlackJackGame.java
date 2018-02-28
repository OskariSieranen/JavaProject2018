/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blackjack;

import java.util.Scanner;

/**
 *
 * @author Pate
 */
public class BlackJackGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double chips = 100.0000;
        double bet;

        //Welcome the user
        System.out.println("Welcome to my Blackjack table, take a seat");

        //Creating a full shuffled deck
        CardDeck playingDeck = new CardDeck();
        playingDeck.createFullDeck();
        playingDeck.shuffle();
        //This is players hand
        CardDeck playerDeck = new CardDeck();

        //dealers "hand"
        CardDeck dealerDeck = new CardDeck();

        System.out.println("How much would you like to invest in chips? ");

        chips = sc.nextDouble();

        System.out.println("You purchased " + chips + " in chips");

        //Game Loop
        while (chips > 0) {
            //Game starts
            //ill ask how much does the player want to bet
            System.out.println("You have $ " + chips + " in chips, how much do you want to bet");
            bet = sc.nextDouble();
            if (bet > chips){
                System.out.println("You cannot bet more than you have! ");
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
            
            while(true){
                System.out.println("Your hand: ");
                System.out.println(playerDeck.toString());
                System.out.println("Your hands value is: " + playerDeck.cardsValue());
                
                //Show dealers hand
                System.out.println("Dealers hand: " + dealerDeck.getCard(0).toString() + "and a card of unknown value" );
                
                //Player will now decide if he wants to stay or hit
                System.out.println("Do you want to (1) Hit or (2) Stay?");
                int response = sc.nextInt();
                
                //Player hits
                if(response == 1){
                    playerDeck.draw(playingDeck);
                    System.out.println("You draw a: " + playerDeck.getCard(playerDeck.deckSize()-1).toString());
                    if (playerDeck.cardsValue() > 21){
                        System.out.println("Bust");
                        chips -= bet;
                        endRound = true;
                    }
                }
                
                if (response == 2){
                    
                    
                }
                
            }
            
            
        }

        System.out.println("Game over! You lost all of your cash. ");

    }

}
