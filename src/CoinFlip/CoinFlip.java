/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CoinFlip;

import javax.swing.*;

/**
 *
 * @author Pate
 */
public class CoinFlip {

    public static void main(String[] args) {
        double guess = 0;
        double playerpoints = 0;
        double guessIndex;
        JOptionPane.showMessageDialog(null, "Welcome to my coin flipping game \nYou have 5 guesses \nif you guess right you get a point!\nif you guess wrong you lose a point");

        while (guess < 5) {

            int response = JOptionPane.showOptionDialog(null,
                    "Do you want to throw?"
                    + "\nChoose yes to throw, no to leave the game",
                    "CoinFlippingGame",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, null, null);
            //if the player decides to throw 
            if (response == JOptionPane.YES_OPTION) {
                guess += 1;

                guessIndex = Double.parseDouble(JOptionPane.showInputDialog(null, "Make your guess \ntype 1 if you want to guess tails \ntype 2 if you want to guess heads"));

                //generate number between 1 and 2
                int coinresult = (int) (Math.random() * 2 + 1);
                //if this happens then do this
                if (coinresult == 1) {
                    JOptionPane.showMessageDialog(null, "You threw tails");

                    if (guessIndex == 1) {
                        playerpoints += 1;
                        JOptionPane.showMessageDialog(null, "You guessed right! \nYou now have" + playerpoints + " points");
                    } else {
                        playerpoints -= 1;
                        JOptionPane.showMessageDialog(null, "You guessed wrong! \nYou now have" + playerpoints + " points");
                    }
                }
                if (coinresult == 2) {
                    JOptionPane.showMessageDialog(null, "You threw heads");

                    if (guessIndex == 1) {
                        playerpoints -= 1;
                        JOptionPane.showMessageDialog(null, "You guessed wrong! \nYou now have" + playerpoints + " points");
                    } else {
                        playerpoints += 1;
                        JOptionPane.showMessageDialog(null, "You guessed right! \nYou now have" + playerpoints + " points");
                    }

                }

            }
            if (response == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Sad to hear");
                break;
            }

        }
        JOptionPane.showMessageDialog(null, "You got " + playerpoints + " points");
    }

}
