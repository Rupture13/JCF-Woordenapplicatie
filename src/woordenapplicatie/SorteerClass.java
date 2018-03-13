/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package woordenapplicatie;

import java.util.Collections;
import java.util.TreeSet;

/**
 *
 * @author Rupture13
 */
public class SorteerClass {
    
    //O(n)
    public String executeSorteer(String[] input) {
        //TreeSet chosen because:
        //• Adding is O(log n)
        //• Sorted
        TreeSet<String> uniqueWords = new TreeSet<>(Collections.reverseOrder()); 
        //reverseOrder is a Comparator which in this case makes the un-alphabetic order happen
        
        for (String word : input) { //O(n)
            uniqueWords.add(word.toLowerCase()); //O(log n)
        }
        
        StringBuilder sb = new StringBuilder();
        for (String word : uniqueWords) {
            sb.append(word);
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
