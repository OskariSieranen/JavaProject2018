/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarot;

import java.util.*;
/**
 * A list of Tarot cards.
 * @author aamu
 * Source for most of the meanings: https://www.biddytarot.com/tarot-card-meanings/major-arcana/
*/

public class TarotDeck {
    public static void main(String[] args) {
        
    
    //Card[] tarotdeck =  new Card[] {
    ArrayList<Card> tarotdeck = new ArrayList();
        tarotdeck.add(new Card("The Fool", "0", "Beginnings | Innocence | Spontaneity"));
        tarotdeck.add(new Card("The Magician", "I", "Power | Skill | Action"));
        tarotdeck.add(new Card("The High Priestess", "II", "Intuition | Higher Powers | Mystery"));
        tarotdeck.add(new Card("The Empress", "III", "Fertility | Beauty | Nature"));
        tarotdeck.add(new Card("The Emperor", "IV", "Authority | Structure | Solid Foundation"));
        tarotdeck.add(new Card("The Hierophant", "V", "Religion | Beliefs | Tradition"));
        tarotdeck.add(new Card("The Lovers", "VI", "Love | Union | Choices"));
        tarotdeck.add(new Card("The Chariot", "VII", "Control | Will Power | Victory"));
        tarotdeck.add(new Card("Strength", "VIII", "Strength | Patience | Control"));
        tarotdeck.add(new Card("The Hermit", "IX", "Introspection | Being Alone | Inner Guidance"));
        tarotdeck.add(new Card("Wheel of Fortune", "X", "Destiny | Turning Point | Good Luck"));
        tarotdeck.add(new Card("Justice", "XI", "Justice | Fairness | Truth"));
        tarotdeck.add(new Card("The Hanged Man", "XII", "Sacrifice | Letting Go | Suspension"));
        tarotdeck.add(new Card("Death", "XIII", "Transformation | Endings | Change"));
        tarotdeck.add(new Card("Temperance", "XIV", "Balance | Moderation | Purpose"));
        tarotdeck.add(new Card("The Devil", "XV", "Addicition | Materialism | Sexuality"));
        tarotdeck.add(new Card("The Tower", "XVI", "Disaster | Revelation | Sudden Change"));
        tarotdeck.add(new Card("The Star", "XVII", "Hope | Renewal | Serenity"));
        tarotdeck.add(new Card("The Moon", "XVIII", "Illusion | Fear | Subconcious"));
        tarotdeck.add(new Card("The Sun", "XIX", "Warmth | Positivity | Vitality"));
        tarotdeck.add(new Card("Judgement", "XX", "Absolution | Rebirth | Inner Calling"));
        tarotdeck.add(new Card("The World", "XXI", "Completion | Journey | Accomplishment"));
    
        Collections.shuffle(tarotdeck);
    }
}