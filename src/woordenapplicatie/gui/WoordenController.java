package woordenapplicatie.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import woordenapplicatie.Facade;

/**
 * FXML Controller class
 *
 * @author frankcoenen
 */
public class WoordenController implements Initializable {
    
   public static final String DEFAULT_TEXT =   "Een, twee, drie, vier\n" +
                                                "Hoedje van, hoedje van\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van papier";
    
    @FXML
    private Button btAantal;
    @FXML
    private TextArea taInput;
    @FXML
    private Button btSorteer;
    @FXML
    private Button btFrequentie;
    @FXML
    private Button btConcordantie;
    @FXML
    private TextArea taOutput;

    private Facade textProcessor;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        taInput.setText(DEFAULT_TEXT);
        textProcessor = new Facade();
    }
    
    @FXML
    private void aantalAction(ActionEvent event) {
        taOutput.setText(textProcessor.executeAantal(taInput.getText()));
    }

    @FXML
    private void sorteerAction(ActionEvent event) {
         taOutput.setText(textProcessor.executeSorteer(taInput.getText())); 
    }

    @FXML
    private void frequentieAction(ActionEvent event) {
        taOutput.setText(textProcessor.executeFrequentie(taInput.getText()));
    }

    @FXML
    private void concordatieAction(ActionEvent event) {
        taOutput.setText(textProcessor.executeConcordantie(taInput.getText())); 
    }
   
}
