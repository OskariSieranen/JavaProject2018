    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */ 
package Controller;
import java.util.Scanner;

/**
 * Controller class for the games found within.
 * 
 */
public class Controller {

    public static void main(String[] args) {
        int ans;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Choose your game of choice:");
        System.out.println("(1) Blackjack");
        System.out.println("(2) Russian Roulette");
        System.out.println("(3) A Tarot Reading");
        
        ans = sc.nextInt();
        
        switch (ans) {
            case 1: Blackjack.BlackJackGame.main(args);
                    break;
            
            
            case 3: Tarot.TarotDeck.main(args);
                    break;
            default: System.out.println("Pick a valid option");
            
        
        }
        
    }
    
}
