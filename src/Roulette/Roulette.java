/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Roulette;

import java.util.*;
import javax.swing.*;

/**
 *
 * @author aamu
 */
public class Roulette {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to the roulette table.");

        double chips = Double.parseDouble(JOptionPane.showInputDialog(null, "How many chips would you like to buy?"));

        JOptionPane.showMessageDialog(null, "You bought " + chips + " chips.");

        //Game loop
        while (chips > 0) {
            double bet = Double.parseDouble(JOptionPane.showInputDialog(null, "How much would you like to bet"));

            while (chips < bet) {
                JOptionPane.showMessageDialog(null, "You can't bet more than you have!");
                bet = Double.parseDouble(JOptionPane.showInputDialog(null, "Please bet again!"));
            }

            JOptionPane.showMessageDialog(null, "You bet " + bet);

            double guess = Double.parseDouble(JOptionPane.showInputDialog(null, "What is your guess between 0-36"));
            
            double roulette = (0 + (int) (Math.random() * (36 - 0) + 1));
            
            while (guess < 0 || guess > 36) {
                JOptionPane.showInputDialog(null, "You need to input a correct amount!");
                guess = sc.nextInt();
            }
            if (guess != roulette) {
                JOptionPane.showMessageDialog(null, "You lost!");
                chips -= bet;
            } else {
                JOptionPane.showMessageDialog(null, "You won!");
                chips += (bet * 35);
                JOptionPane.showMessageDialog(null, "You have " + chips + "chips.");
            }
        }
    }
}
