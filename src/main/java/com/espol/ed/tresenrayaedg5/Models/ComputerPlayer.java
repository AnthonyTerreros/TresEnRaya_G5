/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espol.ed.tresenrayaedg5.Models;

import com.espol.ed.tresenrayaedg5.TDAs.Tree;
import com.espol.ed.tresenrayaedg5.TDAs.TreeNode;
import com.espol.ed.tresenrayaedg5.VentanaGameController;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author dante
 */
public class ComputerPlayer {
    
    private char jugador;
    private Tablero tableroGame;
    
    public ComputerPlayer(){
        jugador = 'X';
        tableroGame = TresEnRaya.getTablero();
    }
    
    public ComputerPlayer(char jugador){
        this.jugador = jugador;
    }
    
    public char getJugador() {
        return jugador;
    }

    public void setJugador(char jugador) {
        this.jugador = jugador;
    }

    public void setTableroGame(Tablero tableroGame) {
        this.tableroGame = tableroGame;
    }
    
    public void makeMove() {
        TresEnRaya game = TresEnRaya.getTresEnRaya();
        Tree<Tablero> tree = new Tree<>(tableroGame);
        generateFamily(tree);
        TreeNode<Tablero> nodeRes = new TreeNode<>(cloneTablero(minimax(tree).getRoot().getContent()));
        Tablero t = nodeRes.getContent();
        List<Integer> pos = t.searchPositionPlayer(tableroGame,jugador);
        tableroGame.getCeldas()[pos.get(0)][pos.get(1)].setJugador(jugador);
        tableroGame.getCeldas()[pos.get(0)][pos.get(1)].dibujarJugador();
        if(game.revisarGanador(this.jugador)){
            VentanaGameController.VentanaGanador(Status.WIN, this.jugador);
        }
        if(game.isTableroFull()){
            VentanaGameController.VentanaGanador(Status.TIE, this.jugador);
        }
    }
   
    public void generateFamily(Tree<Tablero> arbol){
        TresEnRaya game = TresEnRaya.getTresEnRaya();
        generateStatesBoards(arbol, jugador, false);
        for(Tree<Tablero> childrenTree: arbol.getChildren()){
            generateStatesBoards(childrenTree, game.getHumanPlayer().getJugador() , true);
        }
    }
    
    private void generateStatesBoards(Tree<Tablero> tree, char player, boolean isSecondGeneration) {
        TresEnRaya game = TresEnRaya.getTresEnRaya();
        int counter = 0;
        for (int i = 0; i < tree.getRoot().getContent().getCeldas().length; i++) {
            for (int j = 0; j < tree.getRoot().getContent().getCeldas()[0].length; j++) {
                if (tree.getRoot().getContent().getCeldas()[i][j].getJugador() == ' ' && tree.getRoot().getContent().getCeldas()[i][j].getJugador() != game.getHumanPlayer().getJugador()) {
                    Tree<Tablero> node = new Tree<>(cloneTablero(tree.getRoot().getContent()));
                    node.getRoot().getContent().getCeldas()[i][j].setJugador(player);
                    node.getRoot().setParent(tree);
                    if (isSecondGeneration) {
                        node.getRoot().setUtility(calculateUtilityBoard(node.getRoot().getContent()));
                    }
                    tree.getRoot().addChild(node);
                    counter++;
                }
            }
        }
    }

    public Tree<Tablero> minimax(Tree<Tablero> tree){
        PriorityQueue<Tree<Tablero>> cola = new PriorityQueue<>((t1, t2) -> {
            return t2.getRoot().getUtility() - t1.getRoot().getUtility();
        });
        for(Tree<Tablero> chilTree: tree.getChildren()){
            min(chilTree);
            cola.offer(chilTree);
        }
        
        //Prueba
        for(Tree<Tablero> children: cola){
            System.out.print(children.getRoot().getUtility() + " ");
        }
        System.out.println("Max: " + cola.peek().getRoot().getUtility() + "\n");
        
        return cola.poll();
    }
    
    public void min(Tree<Tablero> tree){
        PriorityQueue<Tree<Tablero>> pq = new PriorityQueue<>((t1, t2) -> {
            return t1.getRoot().getUtility() - t2.getRoot().getUtility();
        });
        for(Tree<Tablero> minitree: tree.getChildren()){
            pq.offer(minitree);
        }
        
        //Prueba
        for(Tree<Tablero> children: pq){
            System.out.print(children.getRoot().getUtility() + " ");
        }
        System.out.println("Min: " + pq.peek().getRoot().getUtility());
        
        tree.getRoot().setUtility(pq.poll().getRoot().getUtility());
    }
    
    public int calculateUtilityForPlayer(Tablero t, char jugador) {
        boolean c1 = (t.getCeldas()[0][0].getJugador() != jugador) && (t.getCeldas()[1][1].getJugador() != jugador) && (t.getCeldas()[2][2].getJugador() != jugador);
        boolean c2 = (t.getCeldas()[2][0].getJugador() != jugador) && (t.getCeldas()[1][1].getJugador() != jugador) && (t.getCeldas()[0][2].getJugador() != jugador);
        int counter = 0;
        for (int i = 0; i < t.getCeldas().length; i++) {
            if (t.getCeldas()[i][0].getJugador() != jugador && t.getCeldas()[i][1].getJugador() != jugador && t.getCeldas()[i][2].getJugador() != jugador) {
                counter++;
            }
        }
        for (int j = 0; j < t.getCeldas().length; j++) {
            if (t.getCeldas()[0][j].getJugador() != jugador && t.getCeldas()[1][j].getJugador() != jugador && t.getCeldas()[2][j].getJugador() != jugador) {
                counter++;
            }
        }
        if (c1) counter++;
        if (c2) counter++;
        return counter;
    }

    public int calculateUtilityBoard(Tablero tablero) {
        TresEnRaya game = TresEnRaya.getTresEnRaya();
        return calculateUtilityForPlayer(tablero, game.getHumanPlayer().getJugador()) - calculateUtilityForPlayer(tablero, this.jugador);
    }
    
    public Tablero cloneTablero(Tablero tableroGame){
        Tablero clon = new Tablero();
        for(int k = 0; k < tableroGame.getCeldas().length; k++){
            for(int j = 0; j < tableroGame.getCeldas()[0].length; j++){
                clon.getCeldas()[k][j].setJugador(tableroGame.getCeldas()[k][j].getJugador());
            }
        }
        return clon;
    }

}
