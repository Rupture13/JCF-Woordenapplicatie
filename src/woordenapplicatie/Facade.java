/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package woordenapplicatie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rupture13
 */
public class Facade {
    AantalClass aantal;
    SorteerClass sorteer;
    FrequentieClass frequentie;
    ConcordantieClass concordantie;

    public Facade() {
        this.aantal = new AantalClass();
        this.sorteer = new SorteerClass();
        this.frequentie = new FrequentieClass();
        this.concordantie = new ConcordantieClass();
    }
    
    public String executeAantal(String input) {
        return aantal.executeAantal(splitWords(input));
    }
    
    public String executeSorteer(String input) {
        return sorteer.executeSorteer(splitWords(input));
    }
    
    public String executeFrequentie(String input) {
       return frequentie.executeFrequency(splitWords(input));
    }
    
    public String executeConcordantie(String input) {
        return concordantie.executeConcordantie(splitWords(input), splitLines(input));
    }
    
    private String[] splitWords(String input) {
        //Get array of actual words from the string
        //(A word being defined as a series of "a-z/A-Z" characters)
        return input.split("[^a-zA-Z]+");
    }
    
    private String[] splitLines(String input) {
        return input.split("\\n+");
    }
    
    public String readInputFromFile(boolean large) {
        String path;
        if (large) {
            path = System.getProperty("user.dir") + File.separator + "input10000.txt";
        }
        else {
            path = System.getProperty("user.dir") + File.separator + "input1000000.txt";
        }
        String content = "test test";
        
        try (FileReader fr = new FileReader(path); BufferedReader br = new BufferedReader(fr); Scanner s = new Scanner(br).useDelimiter("\\Z")) {
            content = s.next();
        } catch (IOException e) {
            Logger.getGlobal().log(Level.SEVERE, "Reading files failed.");
            return "nothing";
        }
        
        return content;
    }
}
