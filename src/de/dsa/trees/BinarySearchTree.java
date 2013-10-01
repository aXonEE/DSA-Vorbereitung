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
    /**
     * Löscht Knoten des Baumes , falls vorhanden.
     * 
     * 
     * @param k Schlüssel des zu löschenden Knotens
     * @return wenn erfolgreich true, sonst false. 
     */
    public boolean remove(K k) {
        Node<K> parent = head;
        Node<K> n = head.getRight();

        /*
         *  Sucht Knoten mit zu löschendem Schlüssel.
         *  Schleife erfasst auch Elternknoten des Knotens.
         */
        while (n != nullNode) {
            int compare = k.compareTo(n.getKey());

            

            if (compare == 0) {
                break;
            }

            parent = n;
            n = (compare > 0 ? n.getRight() : n.getLeft());

        }
        
        /*
         * Falls Knoten mit gesuchtem Schlüssel nicht exisitet
         * gebe false zurück.
         */
        if (n == nullNode) {
            return false;
        }
        
        System.out.println("Anzahl Kinder " + getChildCount(n) );
        
        /*
         * Abhängig von der Kindanzahl wird die entsprechende Aktion
         * bzw. Methode ausgeführt.
         */
        switch (getChildCount(n)) {
            case 0:
                if(parent.getLeft() == n)
                    parent.setLeft(nullNode);
                else
                    parent.setRight(nullNode);
                break;
            case 1:                
                this.replace_with_child(parent, n);
                break;
            case 2:
                this.replace_with_Inorderpredecessor(parent, n);
                break;
            default:
                break;
        }

        return true;
    }
    
    /**
     * Für den Fall das nur ein Kindknoten existiert.
     * 
     * @param parent Elternknoten des zu löschenden Knotens.
     * @param n zu löschender Knoten
     */
    private void replace_with_child(Node<K> parent, Node<K> n) {
        Node<K> child;
        if (n.getLeft() != nullNode) 
            child = n.getLeft();
        else 
            child = n.getRight();
        
        
        
        if(parent.getLeft() == n)
            parent.setLeft(child);
        else
            parent.setRight(child);

    }
    /**
     * 
     * @param n 
     */
    private void replace_with_Inorderpredecessor(Node<K> parent,Node<K> n) {
        Node<K> child = n.getLeft();
        Node<K> temp_parent = n;
    
        while(child.getRight() != nullNode){
            temp_parent = child;
            child = child.getRight();
        }
        
        if(temp_parent != n){
            temp_parent.setRight(nullNode);
        }else{
            temp_parent.setLeft(nullNode);
        }
        
        if(parent.getLeft() == n)
            parent.setLeft(child);
        else 
            parent.setRight(child);
            
        child.setLeft(n.getLeft());
        child.setRight(n.getRight() );
    
    }

    private byte getChildCount(Node<K> n) {
        Node<K> left = n.getLeft();
        Node<K> right = n.getRight();

        if (left == nullNode && right == nullNode) {
            return 0;
        } else if (left != nullNode && right != nullNode) {
            return 2;
        } else {
            return 1;
        }
    }

    public Node findNode(K k) {
        Node<K> n = head.getRight();

        while (n != nullNode) {
            int compare = k.compareTo(n.getKey());

            if (compare == 0) {
                return n;
            }

            n = (compare > 0 ? n.getRight() : n.getLeft());

        }

        return null;
    }

    public void print(byte mode) {
        Node<K> n = head.getRight();

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

    public void printTree() {
        Node root = head.getRight();
        if (root == nullNode) {
            return;
        }

        Stack<Node> globalStack = new Stack();
        int emptyLeaf = 32;
        boolean isRowEmpty = false;
        globalStack.push(root);

        while (!isRowEmpty) {
            Stack<Node> localStack = new Stack();
            isRowEmpty = true;

            for (int i = 0; i < emptyLeaf; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()) {
                Node temp = globalStack.pop();

                if (temp != nullNode) {
                    System.out.print(temp.getKey());
                    localStack.push(temp.getLeft());
                    localStack.push(temp.getRight());

                    if (temp.getLeft() != nullNode || temp.getRight() != nullNode) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("  ");
                    localStack.push(nullNode);
                    localStack.push(nullNode);
                }
                for (int i = 0; i < emptyLeaf * 2 - 2; i++) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            emptyLeaf /= 2;
            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }
        }


    }
}
