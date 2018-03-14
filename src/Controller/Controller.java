    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */ 
package Controller;
import java.util.*;
import javax.swing.*;
/**
 * Controller class for the games found within.
 * 
 */
public class Controller {

    public static void main(String[] args) {
        int ans;
        String[] options = new String[] {"Blackjack", "Russian Roulette", "Tarot Reading", "Roulette"};
        
        ans = JOptionPane.showOptionDialog(null, 
                "Choose your game of choice:",
                "Choose your game",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);
        
        switch (ans) {
            case 0: Blackjack.BlackJackGame.main(args);
                    break;
            case 1: RussianRoulette.RussianRouletteGame.main(args);
                    break;
            case 2: Tarot.TarotDeck.main(args);
                    break;
            case 3: Roulette.Roulette.main(args);
            default: System.out.println("Pick a valid option");
        }
        
    }

}
