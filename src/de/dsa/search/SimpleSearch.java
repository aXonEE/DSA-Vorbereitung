package de.dsa.search;
public class SimpleSearch<K extends Comparable<K>> {

	public static int NO_KEY = -1;

	/**
	 * Sequentielle Suche.
	 * Die Eintr�ge des Arrays werden nacheinander mit dem Schl�ssel verglichen.
	 * Wenn erfolgreich, R�ckgabe des Arrayindex.
	 * Wenn erfolglos  , R�ckgabe -1 ( SimpleSearch.NO_KEY )
	 * 
	 * @param array Array
	 * @param key Schl�ssel
	 * @return index oder NO_KEY
	 */
	public int seqSearch(K[] array, K key) {
		for (int i = 0; i < array.length; i++) {
			
			if (key.compareTo(array[i]) == 0)
				return i;
		}

		return NO_KEY;

	} 

	/**
	 * Bin�re Suche.
	 * 
	 * Der erste bzw. letzte Arrayindex bildet die untere bzw. obere Grenze.
	 * Mit den beiden Grenzen wird ein Mittelwert m bestimmt.
	 * Ist der Schl�ssel gleich array[m], wird m zur�ckgegeben.
	 * 
	 * Wenn Schl�ssel < array[m] wird m - 1 neue obere Grenze.
	 * Wenn Schl�ssel > array[m] wird m + 1 neue untere Grenze.
	 * 
	 * Dies wird solange lustig fortgef�hrt, bis array[m] dem Schl�ssel entspricht
	 * oder der Schl�ssel in der Folge nicht existiert.
	 * Das erkennt man wenn die untere Grenze > obere Grenze ist.
	 * 
	 * 
	 * @param array
	 * @param key
	 * @return
	 */
	public int binarySearch_rec(K[] array, K key) {
		int m;
		int u = 0;
		int o = array.length - 1;

		m = (u + o) / 2;
		
		if(array[m].compareTo(key) == 0)
			return m;
		
		if (array[m].compareTo(key) < 0)
			return binarySearch_rec(array, key, m + 1, o);
		else
			return binarySearch_rec(array, key, u, m - 1);

	}

	private int binarySearch_rec(K[] array, K key, int u, int o) {
		int m;

		
		if (u > o)
			return NO_KEY;

		m = (u + o) / 2;

		if(array[m].compareTo(key) == 0)
			return m;
		
		if (array[m].compareTo(key) < 0)
			return binarySearch_rec(array, key, m + 1, o);
		else
			return binarySearch_rec(array, key, u, m - 1);

		
	}
	

	
	
}
