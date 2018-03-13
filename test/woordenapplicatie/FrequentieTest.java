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
public class FrequentieTest {
    static String input;
    static Facade f;
    
    @BeforeClass
    public static void setUpClass() {
        input = WoordenController.DEFAULT_TEXT;
        
        f = new Facade();
    }

    @Test
    public void testFrequentie1() {
        String result = f.executeFrequentie(input);
        assertEquals("papier                  	:  1\n" +
        "drie                    	:  2\n" +
        "een                     	:  2\n" +
        "twee                    	:  2\n" +
        "vier                    	:  2\n" +
        "hoedje                  	:  3\n" +
        "van                     	:  3", result);
    }
    
    @Test
    public void testFrequentie2() {
        String result = f.executeFrequentie(input);
        assertNotEquals("papier                  	:  1\n" +
        "drie                    	:  3\n" +
        "een                     	:  2\n" +
        "twee                    	:  2\n" +
        "vier                    	:  2\n" +
        "hoedje                  	:  3\n" +
        "van                     	:  3", result);
    }
    
    //Performance tests:
    @Test
    public void testFrequentieWithInput1() {
        String result = f.executeFrequentie(f.readInputFromFile(false));
        Logger.getGlobal().log(Level.INFO, "Input of 10.000:\n{0}\n", result);
        assertTrue(true);
    }
    
    @Test
    public void testFrequentieWithInput2() {
        String result = f.executeFrequentie(f.readInputFromFile(true));
        Logger.getGlobal().log(Level.INFO, "Input of 1.000.000:\n{0}\n", result);
        assertTrue(true);
    }
}
