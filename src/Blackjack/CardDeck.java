/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blackjack;

import java.util.*;

/**
 *
 * @author Pate
 *
 */
public class CardDeck {

    //ilmentymämuuttuja
    private ArrayList<Card> cards;

    //konstruktori
    public CardDeck() {
        this.cards = new ArrayList<Card>();
    }

    public void createFullDeck() {
        //Here i create the cards using a For-each loop
        for (Suit cardSuit : Suit.values()) {
            for (Value cardValue : Value.values()) {
                //Adding new card to a deck
                this.cards.add(new Card(cardSuit, cardValue));
            }
        }

    }
// i hate github
    public void shuffle() {
        //here i create a new empty deck
        ArrayList<Card> tmpDeck = new ArrayList<Card>();
        //Here i use the Random object 
        Random random = new Random();
        // a card that i pull out of the deck
        int randomCardIndex;
        int originalSize = this.cards.size();
        for (int i = 0; i < originalSize; i++) {
            //Generating Random index
            randomCardIndex = random.nextInt(this.cards.size());
            //adding the random card to the temporary deck
            tmpDeck.add(this.cards.get(randomCardIndex));
            //removing the random card from the original deck so that the shuffle will keep working nornally
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

    @Override
    public String toString() {
        String cardListOutput = "";
        for (Card aCard : this.cards) {
            cardListOutput += "\n " + aCard.toString();
        }
        return cardListOutput;

    }

    //drawing from the deck
    //in the CardDeck drawing from we will refer to the deck we want to draw from
    //by inserting its name to playerDeck.draw(playingDeck); playingDeck slot
    //this.cards.add means the deck we are adding them to basicly it makes a copy of the card
    //so in the last line we refer to the playingDeck again with the drawingFrom and then
    //we remove a card from it becouse well thats what drawing is
    public void draw(CardDeck drawingFrom) {
        this.cards.add(drawingFrom.getCard(0));
        drawingFrom.removeCard(0);

    }

    // dealerDeck.moveALLcardsToDeck(playingDeck);
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

    //shows how many cards there is in a hand
    public int deckSize() {
        return this.cards.size();
    }

    //defining the values of the cards
    //also defining when ace is one or eleven
    public int cardsValue() {
        int totalValue = 0;
        int aces = 0;

        for (Card aCard : this.cards) {
            switch (aCard.getValue()) {
                case TWO:
                    totalValue += 2;
                    break;
                case THREE:
                    totalValue += 3;
                    break;
                case FOUR:
                    totalValue += 4;
                    break;
                case FIVE:
                    totalValue += 5;
                    break;
                case SIX:
                    totalValue += 6;
                    break;
                case SEVEN:
                    totalValue += 7;
                    break;
                case EIGHT:
                    totalValue += 8;
                    break;
                case NINE:
                    totalValue += 9;
                    break;
                case TEN:
                    totalValue += 10;
                    break;
                case JACK:
                    totalValue += 10;
                    break;
                case QUEEN:
                    totalValue += 10;
                    break;
                case KING:
                    totalValue += 10;
                    break;
                case ACE:
                    aces += 1;
                    break;
            }
        }
        //this is where we define when ace is one or eleven
        
        for (int i = 0; i < aces; i++) {

            if (totalValue > 10) {
                totalValue += 1;

            } else {
                totalValue += 11;
            }

        }
        return totalValue;
    }
    
}
