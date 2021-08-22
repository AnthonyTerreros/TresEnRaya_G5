package com.espol.ed.tresenrayaedg5.Models;

import com.espol.ed.tresenrayaedg5.VentanaGameController;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;

/**
 *
 * @author vivi
 */
public class Celda extends VBox {
    
    private char jugador = ' ';
    private int i;
    private int j;
    
    public Celda(int i, int j, char jugador){
        this.i = i;
        this.j = j;
        this.jugador = jugador;
    }     
    
    public Celda(int i, int j) {
        this.i = i;
        this.j = j;
        this.jugador = ' ';
        this.setPrefSize(100, 100);
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-border-color: black");
        this.setOnMouseClicked(e -> {
            onClick();
        });
    }

    public char getJugador() {
        return jugador;
    }

    public void setJugador(char jugador) {
        this.jugador = jugador;
    }
    
    public void dibujarJugador() {
        Text t = new Text();
        if (jugador == 'X') {
            t.setText("X");
            t.setFill(Color.rgb(0, 159, 227));
        } else {
            t.setText("O");
            t.setFill(Color.rgb(249, 178, 51));
        }
        t.setFont(new Font("System", 50));
        t.setStyle("-fx-font-weight: bold");
        t.setBoundsType(TextBoundsType.VISUAL);
        getChildren().add(t);
    }
    
    public void onClick(){
        System.out.println("i: " + this.i + " j: " + this.j);
        TresEnRaya game = TresEnRaya.getTresEnRaya();
        if(this.jugador == ' '){
            setJugador(game.getHumanPlayer().getJugador());
            dibujarJugador();
            if(game.revisarGanador(game.getHumanPlayer().getJugador())){
               VentanaGameController.VentanaGanador(Status.WIN, game.getHumanPlayer().getJugador());
            }else if(game.isTableroFull()){
               VentanaGameController.VentanaGanador(Status.TIE, ' ');
            }else{
                game.getComputerPlayer().makeMove();
            }
        }
    }
    
    @Override
    public String toString() {
        return "x: " + this.i + " " + "y: " + this.j + " Jugador: " + (char)this.jugador;
    }
    
    
}