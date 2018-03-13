/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package woordenapplicatie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author Rupture13
 */
public class FrequentieClass {
    //O(n)
    public String executeFrequency(String[] input) {
        //ArrayList chosen because:
        //• Needs to contain duplicates
        ArrayList<String> allWords = new ArrayList<>();
        
        //HashSet chosen because:
        //• Needs to contain uniques
        //• O(1)
        HashSet<String> uniqueWords = new HashSet<>();
        
        //HashMap chosen because:
        //• Needs key-value structure
        //• Does not need to be sorted (will be done manually later on)
        //• O(1)
        HashMap<String,Integer> map = new HashMap<>();
        
        //TreeMap chosen because:
        //• Needs key-value structure
        //• Needs to be sorted
        TreeMap<Integer, TreeSet<String>> sortedMap = new TreeMap<>();
        
        for (String word : input) {
            allWords.add(word.toLowerCase()); //O(1)
            uniqueWords.add(word.toLowerCase()); //O(1)
        }
        
        //Put each unique word with the frequency with which it occurs in the text in an unsorted map
        for (String word : uniqueWords) {
            map.put(word, Collections.frequency(allWords, word)); //O(1)
        }
        
        for (Entry<String, Integer> entry : map.entrySet()) { //O(n)
            TreeSet<String> words;
            
            if (!sortedMap.containsKey(entry.getValue())) { //O(log n)
                words = new TreeSet<>();
                words.add(entry.getKey()); //O(log n)
                sortedMap.put(entry.getValue(), words); //O(log n)
            }
            else {
                words = sortedMap.get(entry.getValue()); //O(log n)
                words.add(entry.getKey()); //O(log n)
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        //O(n^2)
        for (Entry<Integer, TreeSet<String>> entry : sortedMap.entrySet()) {
            TreeSet<String> value = entry.getValue();
            for (String word : value) {
                sb.append("\n");
                sb.append(String.format("%-23s %s %s", word, "\t: ", entry.getKey()));
            }
        }
        sb.deleteCharAt(0);
        
    //DEPRECATED
    //NOTE: Not allowed to use this "standard internet solution", for it is not efficient!
//        Map sortedMap = sortByValue(map); //O(n)
        
        return sb.toString();
    }
    
    //DEPRECATED
    //NOTE: Not allowed to use this "standard internet solution", for it is not efficient!
    //Ripped from https://stackoverflow.com/questions/109383/sort-a-mapkey-value-by-values
    //Added own custom comparator to secondarily sort on key
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(new ValueComparator()); //Custom comparator to sort primarily on value and secondarily on key

        Map<K, V> result = new LinkedHashMap<>();
        for (Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }
}