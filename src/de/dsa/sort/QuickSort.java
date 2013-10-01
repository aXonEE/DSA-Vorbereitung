/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dsa.sort;

/**
 *
 * @author Philipp
 */
public class QuickSort {
    
    public static int[] array;
    
    public static int[] quickSort(int[] a){
        array = a;
    
        sort(0, array.length - 1);
        
        return array;
    }

    private static void sort(int left, int right) {
        if(left < right){
            int pivot = partition(left,right);
            sort(left,pivot -1);
            sort(pivot + 1, right);
        }
        
    }

    private static int partition(int left, int right) {
        int pivot = array[right];
        int i = left;
        int j = right - 1;
        
        do{
            while(array[i] <= pivot && i < right)
                i++;
            
            while(array[j] >= pivot && j > left)
                j--;
            
            if(i < j)
                swap(i,j);
            
        }while(i < j);
        
        if(array[i] > pivot){
            swap(i ,right);
        }
        
        return i;
    }

    private static void swap(int i, int j) {
        int puffer = array[i];
        array[i] = array[j];
        array[j] = puffer;
    }
}
