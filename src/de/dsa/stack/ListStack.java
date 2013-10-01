/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dsa.stack;

import de.dsa.interfaces.Stack;


/**
 *
 * @author Philipp
 */
public class ListStack<K> implements Stack<K> {

    public Node head;

    public ListStack() {
        head = new Node();
    }

    @Override
    public void push(K key) {
        Node n = new Node(key, head.getNext());
        head.setNext(n);
    }

    @Override
    public K pop() {
        if (isEmpty()) {
            return null;
        }
        Node n = head.getNext();
        head.setNext(n.getNext());
        return n.getKey();
    }

    @Override
    public K peek() {
        if (isEmpty()) {
            return null ;
        }
        return head.getNext().getKey();
    }

    @Override
    public boolean isEmpty() {
        return head.getNext() == null;
    }

    private class Node {

        private K key;
        private Node next;

        public Node(K key, Node n) {
            this.next = n;
            this.key = key;
        }

        public Node() {
            this.next = null;
            this.key = null;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
