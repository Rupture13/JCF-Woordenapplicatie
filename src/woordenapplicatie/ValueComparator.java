/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package woordenapplicatie;

import java.util.Comparator;
import java.util.Map.Entry;

/**
 *
 * @author Rupture13
 */
public class ValueComparator implements Comparator {

    @Override
    public int compare(Object t, Object t1) {
        Entry<String, Integer> o1 = (Entry<String, Integer>) t;
        Entry<String, Integer> o2 = (Entry<String, Integer>) t1;
        
        if (o1.getValue().compareTo(o2.getValue()) == 0) {
            return o1.getKey().compareTo(o2.getKey());
        }
        return o1.getValue().compareTo(o2.getValue());
    }
    
}
