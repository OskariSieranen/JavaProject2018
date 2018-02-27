/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarot;
/**
 * A list of Tarot cards.
 * @author aamu
 * Source for most of the meanings: https://www.biddytarot.com/tarot-card-meanings/major-arcana/
*/

public class TarotDeck {
    private Card[] deck =  new Card[] {
        new Card("The Fool", "0", "Beginnings | Innocence | Spontaneity"),
        new Card("The Magician", "I", "Power | Skill | Action"),
        new Card("The High Priestess", "II", "Intuition | Higher Powers | Mystery"),
        new Card("The Empress", "III", "Fertility | Beauty | Nature"),
        new Card("The Emperor", "IV", "Authority | Structure | Solid Foundation"),
        new Card("The Hierophant", "V", "Religion | Beliefs | Tradition"),
        new Card("The Lovers", "VI", "Love | Union | Choices"),
        new Card("The Chariot", "VII", "Control | Will Power | Victory"),
        new Card("Strength", "VIII", "Strength | Patience | Control"),
        new Card("The Hermit", "IX", "Introspection | Being Alone | Inner Guidance"),
        new Card("Wheel of Fortune", "X", "Destiny | Turning Point | Good Luck"),
        new Card("Justice", "XI", "Justice | Fairness | Truth"),
        new Card("The Hanged Man", "XII", "Sacrifice | Letting Go | Suspension"),
        new Card("Death", "XIII", "Transformation | Endings | Change"),
        new Card("Temperance", "XIV", "Balance | Moderation | Purpose"),
        new Card("The Devil", "XV", "Addicition | Materialism | Sexuality"),
        new Card("The Tower", "XVI", "Disaster | Revelation | Sudden Change"),
        new Card("The Star", "XVII", "Hope | Renewal | Serenity"),
        new Card("The Moon", "XVIII", "Illusion | Fear | Subconcious"),
        new Card("The Sun", "XIX", "Warmth | Positivity | Vitality"),
        new Card("Judgement", "XX", "Absolution | Rebirth | Inner Calling"),
        new Card("The World", "XXI", "Completion | Journey | Accomplishment")
    };
}