/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dsa.trees;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Philipp
 */
public class BinarySearchTree<K extends Comparable<K>> {

    public static final byte PREORDER = 0;
    public static final byte POSTORDER = 1;
    public static final byte INORDER = 2;
    public static final byte LEVELORDER = 3;
    private Node<K> head;
    private Node<K> nullNode;

    public BinarySearchTree() {
        head = new Node();
        nullNode = new Node();
        nullNode.setLeft(nullNode);
        nullNode.setRight(nullNode);
        head.setRight(nullNode);
    }

    public boolean insert(K k) {
        Node<K> parent = head;
        Node<K> child = head.getRight();

        if (child == nullNode) {
            head.setRight(new Node(k, nullNode, nullNode));
            return true;
        }


        while (child != nullNode) {
            parent = child;

            int compare = k.compareTo(child.getKey());

            if (compare == 0) {
                return false;
            }

            if (compare > 0) {
                child = child.getRight();
            } else {
                child = child.getLeft();
            }

        }

        Node n = new Node(k, nullNode, nullNode);

        if (k.compareTo(parent.getKey()) > 0) {
            parent.setRight(n);
        } else {
            parent.setLeft(n);
        }


        return true;
    }
    
    public boolean remove(K k){
        return true;
    }
    
    

    public void print(byte mode) {
        Node n = head.getRight();

        if (n == nullNode) {
            System.err.println("Tree is empty.");
        }

        switch (mode) {
            case POSTORDER:
                printPostorder(n);
                break;
            case PREORDER:
                printPreorder(n);
                break;
            case INORDER:
                printInorder(n);
                break;
            case LEVELORDER:
                printLevelorder(n);
                break;
            default:
                System.err.println("Wrong mode.");
                System.err.println("Possible modes are:");
                System.err.println("Preorder    : 0");
                System.err.println("Postorder   : 1");
                System.err.println("Inorder     : 2");
                System.err.println("Levelorder  : 3");
        }

        System.out.println();
    }

    private void printPostorder(Node n) {
        if (n != nullNode) {
            printPostorder(n.getLeft());
            printPostorder(n.getRight());
            System.out.print(n.getKey() + " ");
        }


    }

    private void printPreorder(Node n) {
        if (n != nullNode) {
            System.out.print(n.getKey() + " ");
            printPreorder(n.getLeft());
            printPreorder(n.getRight());
        }
    }

    private void printInorder(Node n) {
        if (n != nullNode) {
            printInorder(n.getLeft());
            System.out.print(n.getKey() + " ");
            printInorder(n.getRight());
        }
    }

    private void printLevelorder(Node root) {
        Queue<Node> q = new LinkedList();

        q.add(root);

        while (!q.isEmpty()) {
            Node n = q.poll();
            System.out.println(n.getKey());

            if (n.getLeft() != nullNode) {
                q.add(n.getLeft());
            }
            if (n.getRight() != nullNode) {
                q.add(n.getRight());
            }
        }
    }
    
    public void printTree(){
        Node root = head.getRight();
        if(root == nullNode)
            return;
        
        Stack<Node> globalStack = new Stack();
        int emptyLeaf = 32;
        boolean isRowEmpty = false;
        globalStack.push(root);
        
        while(!isRowEmpty){
            Stack<Node> localStack = new Stack();
            isRowEmpty = true;
            
            for(int i = 0 ; i < emptyLeaf ; i++){
                System.out.print(" ");
            }
            
            while(!globalStack.isEmpty()){
                Node temp = globalStack.pop();
                
                if(temp != nullNode){
                    System.out.print(temp.getKey());
                    localStack.push(temp.getLeft());
                    localStack.push(temp.getRight());
                    
                    if(temp.getLeft() != nullNode || temp.getRight() != nullNode)
                        isRowEmpty = false;
                }else{
                    System.out.print("  ");
                    localStack.push(null);
                    localStack.push(null);
                }
                for(int i = 0; i < emptyLeaf * 2 - 2 ; i++){
                    System.out.print(" ");
                }
            }
            System.out.println();
            emptyLeaf /=2;
            while(!localStack.isEmpty())
                globalStack.push(localStack.pop());
        }
        
        
    }
    
  

    private class Node<K> {

        private Node<K> left;
        private Node<K> right;
        private K key;

        public Node(K key, Node left, Node right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }

        public Node() {
            this.left = null;
            this.right = null;
            this.key = null;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        private boolean isLeaf() {
            return right == nullNode && left == nullNode;
        }
    }
}
