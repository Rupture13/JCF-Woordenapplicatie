/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package woordenapplicatie;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import woordenapplicatie.gui.WoordenController;

/**
 *
 * @author Rupture13
 */
public class SorteerTest {
    static String input;
    static Facade f;
    
    @BeforeClass
    public static void setUpClass() {
        input = WoordenController.DEFAULT_TEXT;
        
        f = new Facade();
    }

    @Test
    public void testSorteer1() {
        String result = f.executeSorteer(input);
        assertEquals("vier\n" +
        "van\n" +
        "twee\n" +
        "papier\n" +
        "hoedje\n" +
        "een\n" +
        "drie", result);
    }
    
    @Test
    public void testSorteer2() {
        String result = f.executeSorteer(input);
        assertNotEquals("vier\n" +
        "van\n" +
        "papier\n" +
        "twee\n" +
        "hoedje\n" +
        "een\n" +
        "drie", result);
    }
    
    //Performance tests:
    @Test
    public void testSorteerWithInput1() {
        String result = f.executeSorteer(f.readInputFromFile(false));
        Logger.getGlobal().log(Level.INFO, "Input of 10.000:\n{0}\n", result);
        assertTrue(true);
    }
    
    @Test
    public void testSorteerWithInput2() {
        String result = f.executeSorteer(f.readInputFromFile(true));
        Logger.getGlobal().log(Level.INFO, "Input of 1.000.000:\n{0}\n", result);
        assertTrue(true);
    }
}
