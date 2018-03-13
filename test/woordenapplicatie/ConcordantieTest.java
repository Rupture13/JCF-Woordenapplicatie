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
public class ConcordantieTest {
    static String input;
    static Facade f;
    
    @BeforeClass
    public static void setUpClass() {
        input = WoordenController.DEFAULT_TEXT;
        
        f = new Facade();
    }

    @Test
    public void testConcordantie1() {
        String result = f.executeConcordantie(input);
        assertEquals("drie                    	:  [1, 3]\n" +
        "een                     	:  [1, 3]\n" +
        "hoedje                  	:  [2, 4]\n" +
        "papier                  	:  [4]\n" +
        "twee                    	:  [1, 3]\n" +
        "van                     	:  [2, 4]\n" +
        "vier                    	:  [1, 3]", result);
    }
    
    @Test
    public void testConcordantie2() {
        String result = f.executeConcordantie(input);
        assertNotEquals("drie                    	:  [1, 3]\n" +
        "een                     	:  [1, 3]\n" +
        "hoedje                  	:  [2, 4]\n" +
        "papier                  	:  [4]\n" +
        "twee                    	:  [1, 3]\n" +
        "van                     	:  [2, 4]\n" +
        "vier                    	:  [1, 2]", result);
    }
    
    //Performance tests:
    @Test
    public void testConcordantieWithInput1() {
        String result = f.executeConcordantie(f.readInputFromFile(false));
        Logger.getGlobal().log(Level.INFO, "Input of 10.000:\n{0}\n", result);
        assertTrue(true);
    }
    
    @Test
    public void testConcordantieWithInput2() {
        String result = f.executeConcordantie(f.readInputFromFile(true));
        Logger.getGlobal().log(Level.INFO, "Input of 1.000.000:\n{0}\n", result);
        assertTrue(true);
    }
}
