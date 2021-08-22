package com.espol.ed.tresenrayaedg5.Models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vivi
 */
public class Tablero {
    
    private Celda[][] celdas;
    
    public Tablero(){
        celdas = new Celda[3][3];
        generarTablero();
    }
    
    public Tablero(int i, int j){
        celdas = new Celda[i][j];
    }

    private void generarTablero(){
        for(int i = 0; i < celdas.length; i++){
            for(int j = 0; j < celdas[0].length; j++){
                celdas[i][j] = new Celda(i, j, ' ');
            }
        }
    }
    
    public Celda[][] getCeldas() {
        return celdas;
    }

    public void setCeldas(Celda[][] celdas) {
        this.celdas = celdas;
    }
    
    public List<Integer> searchPositionPlayer(Tablero board, char player){
        List<Integer> indexs = new ArrayList<>();
        for(int i = 0; i < this.getCeldas().length; i++){
            for(int j = 0; j < this.getCeldas()[0].length; j++){
                if(this.getCeldas()[i][j].getJugador() != board.getCeldas()[i][j].getJugador()){
                    indexs.add(i);
                    indexs.add(j);
                    return indexs;
                }
            }
        }
        return null;
    }
    
    public void printTablero(){
        for(int i = 0; i < celdas.length; i++){
            for(int j = 0; j < celdas[0].length; j++){
                if(j == 2){
                    System.out.print(((char)celdas[i][j].getJugador()) + "\n");
                }else{
                    System.out.print(((char)celdas[i][j].getJugador()) + " | ");
                }
            }
            if(i != 2){
                System.out.print("----------\n");
            }
        }
    }

    @Override
    public String toString() {
        String s = "";
        for(int i = 0; i < celdas.length; i++){
            for(int j = 0; j < celdas[0].length; j++){
                if(j == 2){
                    s += ((char)celdas[i][j].getJugador()) + "\n";
                }else{
                    s += ((char)celdas[i][j].getJugador()) + "";
                }
            }
        }
        return s;
    }
    
}
