/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dsa.interfaces;

/**
 *
 * @author Philipp
 */
public interface Stack<K> {
    public void push(K key);
    public K pop();
    public K peek();
    public boolean isEmpty();
}
