/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dsa.trees;

/**
 *
 * @author Philipp
 */
public class Node<K> {

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

        public Node<K> getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node<K> getRight() {
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

        
    }
