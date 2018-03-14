/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RoPaSc;

import java.util.Arrays;
import javax.swing.JOptionPane;

/**"
 *
 * @author aamu
 */
public class RockPaperScissorsGame {

    public static void main(String[] args) {
        int WChoice;
        String[] weapon = new String[] {"Rock", "Paper", "Scissors"};
      
        JOptionPane.showMessageDialog(null, "Welcome to the Rock, Paper, Scissors -game");
        
        WChoice = JOptionPane.showOptionDialog(null, "Choose your weapon:", 
                "Choose your weapon:", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.QUESTION_MESSAGE, 
                null, weapon, weapon[0]);
        
        // Rock is 0, Paper is 1 and Scissors are 2.
        String OneW = new String();
        switch (WChoice) {
            case 0: OneW = "Rock";
                    break;
            case 1: OneW = "Paper";
                    break;
            case 2: OneW = "Scissors";
                    break;
        }
        
        int compWeapon = (0 + (int) (Math.random() * (2 - 0) + 1));
        String TwoW = new String();
        switch (compWeapon) {
            case 0: TwoW = "Rock";
                    break;
            case 1: TwoW = "Paper";
                    break;
            case 2: TwoW = "Scissors";
                    break;
        }
        
        JOptionPane.showMessageDialog(null, "You and the Computer picked: " + OneW + " and " + TwoW);
        
        if (WChoice == compWeapon) {
            JOptionPane.showMessageDialog(null, "It's a tie!");
        } else if (WChoice == 0  && compWeapon == 1) {
            JOptionPane.showMessageDialog(null, "You lose!");
        } else if (WChoice == 1 && compWeapon == 2) {
            JOptionPane.showMessageDialog(null, "You lose!");
        } else if (WChoice == 2 && compWeapon == 0) {
            JOptionPane.showMessageDialog(null, "You lose!");
        } else if (WChoice == 0 && compWeapon == 2) {
            JOptionPane.showMessageDialog(null, "You win!");
        } else if (WChoice == 1 && compWeapon == 0) {
            JOptionPane.showMessageDialog(null, "You win!");
        } else if (WChoice == 2 && compWeapon == 1) {
            JOptionPane.showMessageDialog(null, "You win!");
        }
    }
}
