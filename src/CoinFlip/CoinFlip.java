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
        double quess = 0;
        double playerpoints = 0;
        double quessIndex;
        // JOptionPane.showMessageDialog(null, "Welcome to my Blackjack table, take a seat");
        JOptionPane.showMessageDialog(null, "Welcome to my coin flipping game \nYou have 5 quesses \nif you quess right you get a point!\nif you quess wrong you lose a point");

        while (quess < 5) {

            int response = JOptionPane.showOptionDialog(null,
                    "Do you want to throw?"
                    + "\nChoose yes to throw, no to leave the game",
                    "CoinFlippingGame",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, null, null);
            //if the player decides to throw 
            if (response == JOptionPane.YES_OPTION) {
                quess += 1;

                quessIndex = Double.parseDouble(JOptionPane.showInputDialog(null, "Make your quess \ntype 1 if you want to quess tails \ntype 2 if you want to quess heads"));

                //generate number between 1 and 2
                int coinresult = (int) (Math.random() * 2 + 1);
                //if this happens then do this
                if (coinresult == 1) {
                    JOptionPane.showMessageDialog(null, "You threw tails");

                    if (quessIndex == 1) {
                        playerpoints += 1;
                        JOptionPane.showMessageDialog(null, "You quessed right! \nYou now have" + playerpoints + " points");
                    } else {
                        //if (quessIndex == 2) {
                        playerpoints -= 1;
                        JOptionPane.showMessageDialog(null, "You quessed wrong! \nYou now have" + playerpoints + " points");
                    }
                }
                if (coinresult == 2) {
                    JOptionPane.showMessageDialog(null, "You threw heads");

                    if (quessIndex == 1) {
                        playerpoints -= 1;
                        JOptionPane.showMessageDialog(null, "You quessed wrong! \nYou now have" + playerpoints + " points");
                    } else {
                        //if (quessIndex == 2){
                        playerpoints += 1;
                        JOptionPane.showMessageDialog(null, "You quessed right! \nYou now have" + playerpoints + " points");
                    }

                }

            }
            if (response == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Sad to hear");
                break;
            }

        }
        JOptionPane.showMessageDialog(null, "You got" + playerpoints + " points");
    }

}
