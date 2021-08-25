package com.espol.ed.tresenrayaedg5;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dante
 */
public class VentanaPrincipalController implements Initializable {
    
    @FXML
    public VBox root;
    
    @FXML
    public Label message;
    
    @FXML
    public Button btnIniciar;
    public Button btnSalir;
    
    @FXML 
    public RadioButton xPlayer;
    public RadioButton yPlayer;
    public RadioButton startHuman;
    public RadioButton startComputer;
    
    
    public static boolean primerJugador;
    public static boolean comienzaIt;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    public void empezarPartida(ActionEvent e) {
        if ( !(xPlayer.isSelected() || yPlayer.isSelected()) && !(startHuman.isSelected() || startComputer.isSelected()) ) {
            message.setText("Debe seleccionar los opciones, para poder jugar. :(");
        } else {
            if (xPlayer.isSelected()) {
                primerJugador = true;
            } else {
                primerJugador = false;
            }
            if (startComputer.isSelected()) {
                comienzaIt = true;
            } else {
                comienzaIt = false;
            }
            try {
                App.setRoot("VentanaGame");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    @FXML 
    public void close(ActionEvent e){
        Stage s = (Stage) root.getScene().getWindow();
        s.close();
    }
    
}
