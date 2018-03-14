/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RussianRoulette;

import Blackjack.Value;
import Blackjack.Suit;
import Blackjack.Card;
import java.util.*;

/**
 *
 * @author joona
 *
 */
public class CardDeck {

    //ArrayList
    private ArrayList<Card> cards;

    //Constructor
    public CardDeck() {
        this.cards = new ArrayList<Card>();
    }

    public void createFullDeck() {
        //Creates the cards using a For-each loop
        for (Suit cardSuit : Suit.values()) {
            for (Value cardValue : Value.values()) {
                //Adding new card to a deck
                this.cards.add(new Card(cardSuit, cardValue));
            }
        }

    }

    //Creates the shuffle mechanism
    public void shuffle() {
        //Creates a new empty deck
        ArrayList<Card> tmpDeck = new ArrayList<Card>();
        //Uses the Random object 
        Random random = new Random();
        //A card that i pull out of the deck
        int randomCardIndex = 0;
        int originalSize = this.cards.size();
        for (int i = 0; i < originalSize; i++) {
            //Generates Random index
            randomCardIndex = random.nextInt((this.cards.size() - 1 - 0) + 1) + 0;
            //Adds the random card to the temporary deck
            tmpDeck.add(this.cards.get(randomCardIndex));
            //Removes the random card from the original deck so that the shuffle will keep working nornally
            this.cards.remove(randomCardIndex);
        }

        this.cards = tmpDeck;

    }

    public void removeCard(int i) {
        this.cards.remove(i);
    }

    public Card getCard(int i) {
        return this.cards.get(i);

    }

    public void addCard(Card addCard) {
        this.cards.add(addCard);
    }

    public String toString() {
        String cardListOutput = "";
        for (Card aCard : this.cards) {
            cardListOutput += "\n " + aCard.toString();
        }
        return cardListOutput;

    }

    //Drawing from the deck
    //in the CardDeck drawing from we will refer to the deck we want to draw from
    //by inserting its name to playerDeck.draw(playingDeck); playingDeck slot
    //this.cards.add means the deck we are adding them to basicly it makes a copy of the card
    //so in the last line we refer to the playingDeck again with the drawingFrom and then
    //we remove the card from the top of the imaginary deck so the first cell of the list
    public void draw(CardDeck drawingFrom) {
        this.cards.add(drawingFrom.getCard(0));
        drawingFrom.removeCard(0);

    }
    
    //Shows how many cards there is in a hand
    public int deckSize() {
        return this.cards.size();
    }
    
    //Moves all the card from a deck to another
    public void moveALLcardsToDeck(CardDeck moveTo) {
        int thisDeckSize = this.cards.size();

        //put cards into moveTo deck
        for (int i = 0; i < thisDeckSize; i++) {
            moveTo.addCard(this.getCard(i));

        }
        //removing cards from hand
        for (int i = 0; i < thisDeckSize; i++) {
            this.removeCard(0);
        }
    }
    
    //Defines the values of the cards exept the Aces which are defined in the game
    public int cardsValue() {
        int totalValue = 0;

        for (Card aCard : this.cards) {
            switch (aCard.getValue()) {
                case TWO:
                    totalValue = 2;
                    break;
                case THREE:
                    totalValue = 3;
                    break;
                case FOUR:
                    totalValue = 4;
                    break;
                case FIVE:
                    totalValue = 5;
                    break;
                case SIX:
                    totalValue = 1;
                    break;
                case SEVEN:
                    totalValue = 2;
                    break;
                case EIGHT:
                    totalValue = 3;
                    break;
                case NINE:
                    totalValue = 4;
                    break;
                case TEN:
                    totalValue = 5;
                    break;
                case JACK:
                    totalValue = 0;
                    break;
                case QUEEN:
                    totalValue = 0;
                    break;
                case KING:
                    totalValue = 0;
                    break;

            }
        }

        return totalValue;
    }
}
