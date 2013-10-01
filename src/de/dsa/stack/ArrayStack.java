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
public class ArrayStack  {

    
    private int[] array;

    private int index;
    
    public ArrayStack() {
        array = new int[1];
        index = array.length;
    }

    
    
    
   
    public void push(int key) {
       if(isFull()){
           expandArray();
       }
       index--;
       array[index] = key;
    }

   
    public int pop() {
        if(isEmpty()){
            
        }
        index++;
        return array[index - 1];    
    }

    
    public int peek() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    public boolean isEmpty() {
        return index == array.length;
    }

 
    private boolean isFull() {
        return index == 0;
    }
    
    private void expandArray(){
        int[] temp = new int[array.length];
        System.arraycopy(array, 0, temp, 0, array.length);
        
        array = new int[array.length * 2];
        
        int i = array.length - 1;
        int tempIndex = temp.length - 1;
        while(tempIndex >= 0){
            array[i] = temp[tempIndex];
            i--;
            tempIndex--;
        }
        
        index = temp.length ;
    }
    
}
