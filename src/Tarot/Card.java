/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarot;

/**
 * The Tarot card object
 * @author aamu
 */
public class Card {
    String name, number, description;
    
    Card(String name, String number, String description) {
        this.name = name;
        this.number = number;
        this.description = description;
    }
    public String toString() {
        return number + " " + name + " meaning: " + description;
    }
    
}
