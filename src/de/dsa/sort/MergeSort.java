/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dsa.sort;

/**
 *
 * @author Philipp
 */
public class MergeSort {
    
    private int[] array;
    
    public int[] mergeSort(int[] array){
        this.array = array;
        
        sort(0, array.length - 1);
        
        return this.array;
    
        
    }
    
    private void sort(int low , int high) {
        if(low < high){
            int mid = (low + high) / 2;
            sort(low,mid);
            sort(mid + 1, high);
            merge(low, high);
            
        }
    }
    
    private void merge(int low, int high){
        int length = high - low + 1;
        int mid = (high + low) / 2;
        
        int[] temp = new int[length];
        int i;
        int j = 0;
        
        for(int k = low ; k <= mid; k++){
            temp[j] = array[k];
            j++;
        }
        
        for(int k = high; k > mid ; k--){
            temp[j] = array[k];
            j++;
        }
        
        i = 0;
        j = length - 1;
        
        while(i <= j){
            if(temp[i] <= temp[j]){
                this.array[low] = temp[i];
                i++;
                low++;
            }else{
                this.array[low] = temp[j];
                j--;
                low++;
            }
        }
        
    }

   
}
