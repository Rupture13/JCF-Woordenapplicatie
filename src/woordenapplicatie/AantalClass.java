/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package woordenapplicatie;

import java.util.HashSet;

/**
 *
 * @author Rupture13
 */
public class AantalClass {
    
    //O(n)
    public String executeAantal(String[] input){
        int totalWords = 0;
        //HashSet chosen because:
        //• Adding is O(1)
        //• Has desired uniqueness
        HashSet<String> uniqueWords = new HashSet<>();
        
        for (String word : input) {  //O(n)
            ++totalWords;
            uniqueWords.add(word.toLowerCase()); //O(1)
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("Totaal aantal woorden:\t\t\t");
        sb.append(totalWords);
        sb.append("\nAantal verschillende woorden:\t");
        sb.append(uniqueWords.size());
        return sb.toString();
    }
}
