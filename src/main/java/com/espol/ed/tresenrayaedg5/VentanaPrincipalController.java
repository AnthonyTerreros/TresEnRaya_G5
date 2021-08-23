package com.espol.ed.tresenrayaedg5;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

/**
 * FXML Controller class
 *
 * @author dante
 */
public class VentanaPrincipalController implements Initializable {
    
    @FXML
    public Button btnIniciar;
    
    @FXML 
    public RadioButton xPlayer;
    public RadioButton yPlayer;
    public RadioButton startHuman;
    public RadioButton startComputer;
    
    
    public static String primerJugador;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    public void empezarPartida(ActionEvent e){
        if(xPlayer.isSelected()){
            primerJugador = "";
        }
        
        if(yPlayer.isSelected()){
            
        }
        
    }
    
    
}
