/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espol.ed.tresenrayaedg5.Models;

/**
 *
 * @author Lizbeth Vergara
 */
public class HumanPlayer {
    
    public final char jugador;
    
    public HumanPlayer(){
        this.jugador = 'O';
    }
    
    public HumanPlayer(char establecerJugador){
        this.jugador = establecerJugador;
    }

    public char getJugador() {
        return jugador;
    }
    
}