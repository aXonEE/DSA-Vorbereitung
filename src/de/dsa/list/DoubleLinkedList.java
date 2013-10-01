package de.dsa.list;

import java.util.Iterator;

/**
 *
 * @author Philipp
 */
public class DoubleLinkedList<K extends Comparable> {

    private Node head;
    private Node tail;

    public DoubleLinkedList() {
        head = new Node();
        tail = new Node();
        head.setNext(tail);
        tail.setPrev(head);
    }

    public void addFirst(K key) {
        Node n;
        Node temp = head.getNext();

        if (!temp.equals(tail)) {
            n = new Node(key, head, temp);
            head.setNext(n);
            temp.setPrev(n);
        } else {
            n = new Node(key, head, tail);
            head.setNext(n);
            tail.setPrev(n);
        }
    }

    public void addLast(K key) {
        Node n;
        Node temp = tail.getPrev();

        if (!temp.equals(head)) {
            n = new Node(key, temp, tail);
            tail.setPrev(n);
            temp.setNext(n);
        } else {
            n = new Node(key, head, tail);
            head.setNext(n);
            tail.setPrev(n);
        }
    }

    public Iterator iterator(boolean mode) {
        return new ListIterator(mode);
    }

    private class ListIterator implements Iterator<K> {

        private Node n;
        private boolean mode;

        public ListIterator(boolean mode) {

            this.mode = mode;

            if (mode) {
                n = head.getNext();
            } else {
                n = tail.getPrev();
            }
        }

        @Override
        public boolean hasNext() {
            if (mode) {
                return !n.equals(tail);
            } else {
                return !n.equals(head);

        
            }
        }

        @Override
        public K next() {
            K key = n.getKey();
            if (mode) {
                n = n.getNext();
            } else {
                n = n.getPrev();
            }


            return key;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    private class Node {

        private K key;
        private Node next;
        private Node prev;

        public Node(K key, Node p, Node n) {
            this.key = key;
            this.prev = p;
            this.next = n;
        }

        public Node() {
            this.key = null;
            this.next = null;
            this.prev = null;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public K getKey() {
            return key;
        }

        public void setNext(Node n) {
            this.next = n;
        }

        public Node getNext() {
            return this.next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node n) {
            prev = n;
        }
    }
}
