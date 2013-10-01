package de.dsa.list;

import java.util.Iterator;

public class List<K extends Comparable<K>> {

	private Node head;
	
        /**
         * Der Konstruktor erzeugt einen Head-Node, welcher als Einstiegspunkt 
         * in die Liste dient.
         */
	public List() {
		head = new Node();
	}
	
        /**
         * Fügt ein Element vor dem vorherigen ersten Element ein.
         * @param key 
         */
	public void  addFirst(K key){
		Node n = new Node(key, head.getNext());
		head.setNext(n);
	}
	/**
         * Fügt an das Ende der Liste ein Element an.
         * @param key 
         */
	public void addLast(K key){
		/*
                 * Man durchläuft die Liste bis das letzte Element erreicht ist.
                 * Da mit head begonnen wird, wird der Fall abgedeckt, dass die
                 * Liste leer ist.
                 */
                Node i = head;
		Node n;
		
		while(i.getNext() != null){
			i = i.getNext();
		}
		
		n = new Node(key, null);
		
		i.setNext(n);
	}
	
        /**
         * Fügt der Liste die Elemente aufsteigend sortiert hinzu.
         * 
         * Warnung:
         * Im Falle, dass diese Methode verwendet wird, nicht addFirst und 
         * addLast verwenden.
         * @param key 
         */
	public void addSorted(K key){
		Node i = head;
		Node temp = null;
		
		/*
                 * Liste wird durchlaufen.
                 * Wenn Schlüssel <= dem nächsten Element wird es an 
                 * entsprechender Stelle hinzugefügt und die Methode wird 
                 * abgebrochen.
                 */
		while(i.getNext() != null){
			
			temp = i;
			i = i.getNext();
			K k = i.getKey();
			
			if(key.compareTo(k) <= 0){
				Node n = new Node(key,i);
				temp.setNext(n);
				return;
			}
			
			
			
		}
                
                /*
                 * Wenn Liste leer, genauso einfügen wie addFirst.
                 */
		Node n;
		if(i.equals(head)){
			n = new Node(key, i.getNext());
			i.setNext(n);
                        return;
		}
		/*
                 * Wenn Element das Größte, dann genauso einfügen wie addLast.
                 */	
		if(i.getNext() == null){
			n = new Node(key, null);
			i.setNext(n);
		}
	}
        
        public K removeFirst(){
            if(head.getNext() == null)
                return null;
            
            Node n = head.getNext();
            
            head.setNext(n.getNext());
            
            return n.key;
            
        }
        
        public K removeLast(){
            Node i = head;
            Node temp = null;
            
            if(i.getNext() == null)
                return null;
            
            while(i.getNext() != null){
                temp = i;
                i = i.getNext();
            }
            
            temp.setNext(null);
            
            return i.getKey();
            
            
        }
	
	public Iterator iterator(){
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<K>{
		private Node n;
		
		public ListIterator(){
			n = head;
		}
		
		
		@Override
		public boolean hasNext() {
			return n != null;
		}

		@Override
		public K next() {
			
			K k = n.getKey();
			n = n.getNext();
			
			return k;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}

	private class Node{
		private K key;
		private Node next;
		
		public Node(K key, Node n){
			this.key = key;
			this.next = n;
		}
		
		public Node(){
			this.key = null;
			this.next = null;
		}
		
		public void setKey(K key){
			this.key = key;
		}
		
		public K getKey(){
			return key;
		}
		
		public void setNext(Node n){
			this.next = n;
		}
		
		public Node getNext(){
			return this.next;
		}
		
	}
}
