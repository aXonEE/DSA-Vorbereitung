package de.dsa.sort;

public class SimpleSorts<K extends Comparable> {

    public K[] genericSelectionSort(K[] array) {

        int i = array.length - 1;

        int max;

        while (i > 0) {
            max = i;
            for (int j = i - 1; j >= 0; j--) {
                if (array[max].compareTo(array[j]) < 0) {

                    max = j;
                }
            }

            if (max != i) {
                K puffer = array[i];
                array[i] = array[max];
                array[max] = puffer;
            }

            i--;
        }

        return array;

    }

    public K[] genericInsertionSort(K[] array) {

        for (int i = 1; i < array.length; i++) {
            K temp = array[i];
            int j = i;

            while (j > 0 && array[j - 1].compareTo(temp) > 0) {
                array[j] = array[j - 1];
                j--;
            }

            array[j] = temp;


        }

        return array;
    }

    public int[] selectionSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            int min = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }

            if (min != i) {
                int puffer = array[i];
                array[i] = array[min];
                array[min] = puffer;
            }


        }


        return array;
    }

    public int[] insertionSort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i;

            while (j > 0 && temp < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }

            array[j] = temp;

        }
        return array;
    }

    public int[] bubbleSort(int[] array) {
        boolean hasChanged;

        do {
            hasChanged = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    hasChanged = true;
                    int puffer = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = puffer;
                }
            }
        } while (hasChanged);

        return array;
    }
}
