package com.espol.ed.tresenrayaedg5;

import com.espol.ed.tresenrayaedg5.Models.Status;
import com.espol.ed.tresenrayaedg5.Models.TresEnRaya;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author dante
 */
public class VentanaGameController implements Initializable {
    
    
    @FXML
    public HBox _root;
    public VBox root;
    private Label msgText;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TresEnRaya game = TresEnRaya.getTresEnRaya();
        game.init();
        _root.getChildren().add(game.getContenedor());
    }

    public static void VentanaGanador(Status status, char jugador){
        if(status == Status.WIN){
            System.out.println("\tGano: " + jugador);
        }
        if(status == Status.TIE){
            System.out.println("\tEmpate!");
        }
    }
    
    
}
