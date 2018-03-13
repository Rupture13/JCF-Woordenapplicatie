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
public class AantalTest {
    static String input;
    static Facade f;
    
    @BeforeClass
    public static void setUpClass() {
        input = WoordenController.DEFAULT_TEXT;
        
        f = new Facade();
    }

    @Test
    public void testAantal1() {
        String result = f.executeAantal(input);
        assertEquals("Totaal aantal woorden:			15\nAantal verschillende woorden:	7", result);
    }
    
    @Test
    public void testAantal2() {
        String result = f.executeAantal(input);
        assertNotEquals("Totaal aantal woorden:			14\nAantal verschillende woorden:	8", result);
    }
    
    //Performance tests:
    @Test
    public void testAantalWithInput1() {
        String result = f.executeAantal(f.readInputFromFile(false));
        Logger.getGlobal().log(Level.INFO, "Input of 10.000:\n{0}\n", result);
        assertTrue(true);
    }
    
    @Test
    public void testAantalWithInput2() {
        String result = f.executeAantal(f.readInputFromFile(true));
        Logger.getGlobal().log(Level.INFO, "Input of 1.000.000:\n{0}\n", result);
        assertTrue(true);
    }
}
