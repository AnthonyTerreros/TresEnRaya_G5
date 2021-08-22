package com.espol.ed.tresenrayaedg5.Models;

import com.espol.ed.tresenrayaedg5.Models.ComputerPlayer;
import com.espol.ed.tresenrayaedg5.Models.HumanPlayer;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

/**
 *
 * @author vivi
 */
public class TresEnRaya {
    
    private static TresEnRaya tresEnRaya;
    private GridPane contenedor;
    private static Tablero tablero;
    private ComputerPlayer computerPlayer;
    private HumanPlayer humanPlayer;
    
    private TresEnRaya(){
        tablero = new Tablero(3,3);
        computerPlayer = new ComputerPlayer();
        humanPlayer = new HumanPlayer();
    }

    public static TresEnRaya getTresEnRaya() {
        if(tresEnRaya == null){
            tresEnRaya = new TresEnRaya();
        }
        return tresEnRaya;
    }
    
    /*
    * Crea el tablero de juego 
    * @return void
    */
    public void init(){
        contenedor = new GridPane();
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                tablero.getCeldas()[i][j] = new Celda(i,j);
                //PROBLEMA
                contenedor.add(tablero.getCeldas()[i][j], j, i);
            }
        }
        contenedor.setAlignment(Pos.CENTER);
        System.out.println(contenedor.getChildren());
    }
    
    
    /*
    * Revisa en el tablero del juego dado un jugador 'X' o 'O'
    * si ha hecho 3 en raya.
    * @param jugador char
    * @return boolean
    */
    public boolean revisarGanador(char jugador){
        for(int i = 0; i < tablero.getCeldas().length; i++){
            if(tablero.getCeldas()[i][0].getJugador() == jugador && tablero.getCeldas()[i][1].getJugador() == jugador &&  tablero.getCeldas()[i][2].getJugador() == jugador ){
                return true;
            }
        }
        for(int j = 0; j < tablero.getCeldas()[0].length; j++){
            if(tablero.getCeldas()[0][j].getJugador() == jugador && tablero.getCeldas()[1][j].getJugador() == jugador &&  tablero.getCeldas()[2][j].getJugador() == jugador ){
                return true;
            }
        }
        if(tablero.getCeldas()[0][0].getJugador() == jugador && tablero.getCeldas()[1][1].getJugador() == jugador && tablero.getCeldas()[2][2].getJugador() == jugador ){
            return true;
        }
        
        if(tablero.getCeldas()[0][2].getJugador() == jugador && tablero.getCeldas()[1][1].getJugador() == jugador && tablero.getCeldas()[2][0].getJugador() == jugador ){
            return true;
        }
        return false;
    }
    
    /*
    * Permite verificar si el tablero esta lleno,
    * si hay una 'X' o 'O' en la casilla o celdas del tablero
    * @return boolean
    */
    public boolean isTableroFull(){
        for(int i = 0; i < tablero.getCeldas().length; i++){
            for(int j = 0; j < tablero.getCeldas()[0].length; j++){
                if(tablero.getCeldas()[i][j].getJugador() == ' '){
                    return false;
                }
            }
        }
        return true;
    }

    /*
    * Imprime por consola el tablero actual del juego
    * @return void
    */
    public void print() {
        for(int i = 0; i < tablero.getCeldas().length; i++){
            for(int j = 0; j < tablero.getCeldas()[0].length; j++){
                if(j == 2){
                    System.out.print(((char)tablero.getCeldas()[i][j].getJugador()) + "\n");
                }else{
                    System.out.print(((char)tablero.getCeldas()[i][j].getJugador()) + " | ");
                }
            }
            if(i != 2){
                System.out.print("----------\n");
            }
        }
    }

    public static Tablero getTablero() {
        return tablero;
    }

    public ComputerPlayer getComputerPlayer() {
        return computerPlayer;
    }

    public HumanPlayer getHumanPlayer() {
        return humanPlayer;
    }

    public GridPane getContenedor() {
        return contenedor;
    }
    
}