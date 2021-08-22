package com.espol.ed.tresenrayaedg5.TDAs;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * @author Lizbeth Vergara
 * @param <T>
 */
public class Tree<T> {

    private TreeNode<T> root;

    public Tree(T content) {
        this.root = new TreeNode<>(content);
    }

    public Tree() {
        this.root = null;
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }

    public LinkedList<Tree<T>> getChildren() {
        return root.getChildren();
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean isLeaf() {
        return root.getChildren().isEmpty();
    }

    public void clear() {
        root = null;
    }
    
    public Tree<T> search(T value, Comparator<T> cmp){
        Tree<T> tree = new Tree<>(value);
        Deque<Tree<T>> cola = new LinkedList<>();
        cola.offer(this);
        while(!cola.isEmpty()){
            Tree<T> current = cola.poll();
            for(Tree<T> childrenTree: this.getChildren()){
                if(cmp.compare(current.getRoot().getContent(), tree.getRoot().getContent()) == 0){
                    return current;
                }
                cola.offer(childrenTree);
            }
        }
        return null;
    }
    
    public void imprimir() {
        System.out.println(root);
        System.out.println(root.getChildren());
    }

    @Override
    public String toString() {
        return root.getContent().toString();
    }
    
}