package de.dsa.main;

import de.dsa.list.DoubleLinkedList;
import java.util.Iterator;

import de.dsa.list.List;
import de.dsa.search.SimpleSearch;
import de.dsa.sort.MergeSort;
import de.dsa.sort.QuickSort;
import de.dsa.sort.SimpleSorts;
import de.dsa.stack.ArrayStack;
import de.dsa.stack.ListStack;
import de.dsa.trees.BinarySearchTree;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        //testSearch();
        //testSimpleList();
        //testDoubleLinkedList();
        //testStack();
        //testSort();
        testTree();
        
    }

    private static void testSimpleList() {
        System.out.println("Teste einfach verkettete Liste.");

        List<Integer> list = new List<>();


        for (long i = 0; i < 10; i++) {
            list.addFirst((int) (10 * Math.random()));
        }
        Iterator<Integer> iter = list.iterator();

        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");

            if (!iter.hasNext()) {
                System.out.println();
            }
        }

        System.out.println("Letztes Element gelöscht: " + list.removeLast());
        System.out.println("Erstes Element gelöscht :" + list.removeFirst());

        iter = list.iterator();

        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");

            if (!iter.hasNext()) {
                System.out.println();
            }
        }

        System.out.println("Test der einfach verkettete Liste ist beendet \n");
    }

    private static void testSearch() {
        SimpleSearch<Integer> simple = new SimpleSearch<>();

        Integer[] array = new Integer[11];

        for (int i = 0; i < array.length; i++) {

            array[i] = i;
        }


        System.out.println(simple.seqSearch(array, 4));
        System.out.println(simple.binarySearch_rec(array, 6));

    }

    private static void testDoubleLinkedList() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList();

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                list.addFirst(i);
            } else {
                list.addLast(i);
            }
        }

        Iterator iter = list.iterator(true);

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    private static void testStack() {
      ListStack<Integer> stack = new ListStack();
        
      for(long i = 0 ; i < 30000 ; i++){
          for(byte j = 0 ; j < 50 ; j++){
          stack.push((int)(1000 * Math.random()));
          }
      }
        while(!stack.isEmpty())
            System.out.println(stack.pop());
        
        
    }
    
    private static void testSort(){
        MergeSort sort = new MergeSort();
        int[] array = new int[10];
        SimpleSorts<Integer> sort1 = new SimpleSorts();
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(10000 * Math.random());
            System.out.print(array[i]+ " ");
        }
        
        System.out.println();
        
        int[] array1 = sort.mergeSort(array);
        
        for (int i = 0; i < array1.length; i++) {
            //array[i] = (int)(20 * Math.random());
            System.out.print(array1[i]+ " ");
        }
        
      
        
    }
    
    private static void testTree(){
        BinarySearchTree<Integer> tree = new BinarySearchTree();
        
        
       
        tree.insert(10);
        tree.insert(5);
        tree.insert(2);
        tree.insert(8);
        tree.insert(6);
        tree.insert(4);
        tree.insert(1);
        tree.insert(20);
        tree.insert(15);
        tree.insert(11);
        tree.insert(18);
        
       
       
        tree.print(BinarySearchTree.LEVELORDER);
        
        tree.printTree();
        
        tree.remove(2);
        
        System.out.println("");
        
        tree.print(BinarySearchTree.LEVELORDER);
        
        tree.printTree();
    }
}
