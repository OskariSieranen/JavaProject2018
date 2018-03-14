/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;
import javax.swing.*;
/**
 *
 * @author aamu
 */
public class UI {
    public static void main(String[] args) {
        int game = 0;
        
        //TODO set that confirm dialog to change the boolean to false.
        while (game == JOptionPane.YES_OPTION) {
                Controller.Controller.main(args);
                game = JOptionPane.showConfirmDialog(null, "Do you want to play again?");
        }
    }
}
