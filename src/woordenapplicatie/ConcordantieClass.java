/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package woordenapplicatie;

import java.util.HashSet;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author Rupture13
 */
public class ConcordantieClass {
    
    public String executeConcordantie(String[] input, String[] lines) {
        //TreeMap chosen because:
        //• Sorted key-value structure
            //TreeSet chosen because:
            //• Sorted
            //• Uniqueness
        TreeMap<String, TreeSet<Integer>> map = new TreeMap<>();
        HashSet<String> uniqueWords = new HashSet<>();
        
        for (String word : input) { //O(n)
            uniqueWords.add(word); //O(1)
        }
        
        int lineCount = 1;
        for (String word : uniqueWords) { //O(n)
            TreeSet<Integer> concordance = new TreeSet<>();
            
            for (String line : lines) {
                if (line.contains(word)) {
                    concordance.add(lineCount);
                }
                ++lineCount;
            }
            
            map.put(word.toLowerCase(), concordance);
            lineCount = 1;
        }
        
        
        StringBuilder sb = new StringBuilder();
        for (Entry<String, TreeSet<Integer>> entry : map.entrySet()) { //O(n)
            sb.append("\n");
            sb.append(String.format("%-23s %s %s", entry.getKey(), "\t: ", entry.getValue())); //O(log n)
        }
        sb.deleteCharAt(0);
        
        return sb.toString();
    }
}
