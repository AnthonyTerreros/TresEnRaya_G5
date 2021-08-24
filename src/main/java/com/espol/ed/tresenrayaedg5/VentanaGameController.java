package com.espol.ed.tresenrayaedg5;

import com.espol.ed.tresenrayaedg5.Models.Status;
import com.espol.ed.tresenrayaedg5.Models.TresEnRaya;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
        if(VentanaPrincipalController.comienzaIt){
           game.getComputerPlayer().makeMove();
        }
    }

    public static void VentanaGanador(Status status, char jugador){
        VBox root2 = new VBox();
        Label l1 = new Label();
        Label l2 = new Label();
        Button btn2 = new Button("Salir");
        Stage s = new Stage();
        btn2.setStyle("-fx-background-color: #dc3545; -fx-font-size: 14; -fx-font-weight: bold; -fx-text-fill: white;");
        root2.setAlignment(Pos.CENTER);
        root2.setSpacing(10);
        l1.setStyle("-fx-font-size: 64; -fx-font-weight: bold;");
        l2.setStyle("-fx-font-size: 24; -fx-font-weight: bold;");
        if(status == Status.WIN){
            System.out.println("\tGano: " + jugador);
            l1.setText(String.valueOf(jugador));
            l2.setText("¡WINS!");
        }
        if(status == Status.TIE){
            l1.setText("XO");
            l2.setText("¡TIE!");
        }
        
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                try {
                    App.setRoot("VentanaPrincipal");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                s.close();
            }
        });
        root2.getChildren().addAll(l1, l2, btn2);
        Scene sce = new Scene(root2, 450, 400);
        s.setScene(sce);
        s.show();
    }
    
    
    
}
