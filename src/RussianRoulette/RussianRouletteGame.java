/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RussianRoulette;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author joona
 */
public class RussianRouletteGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Asks player whether he/she wants to play survival or versus mode 
        Object[] options = {"Survival", "Versus", "Main Menu"};
        int choice1 = JOptionPane.showOptionDialog(null,
                "Welcome to Russian Roulette! \nWhat mode would you like to play?",
                "Russian Roulette",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options, null);

        if (choice1 == JOptionPane.CANCEL_OPTION) {
            Controller.Controller.main(args);
        }
        if (choice1 == JOptionPane.YES_OPTION) {
            Survival.main(args);

        }
        if (choice1 == JOptionPane.NO_OPTION) {
            Versus.main(args);
        }
    }
}
