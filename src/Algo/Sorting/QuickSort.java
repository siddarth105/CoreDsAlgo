package Algo.Sorting;

public class QuickSort {

	/*
	 * Best :: O(nlogn)
	 * Avg :: O(nlogn) 
	 * Worst :: O(n^2)
	 * 
	 * Sort Logic :-
	 * 	1) Choose an element, called pivot, from the list. Generally pivot can be the middle index element.
	 *	2) Reorder the list so that all elements with values less than the pivot come before the pivot, while all elements with values greater than the pivot come after it (equal values can go either way). After this partitioning, the pivot is in its final position. This is called the partition operation.
	 *	3) Recursively apply the above steps to the sub-list of elements with smaller values and separately the sub-list of elements with greater values. - See more at: http://www.java2novice.com/java-sorting-algorithms/quick-sort/#sthash.W2mEJ29r.dpuf
	 */

	public static int a[];

	public static void quickSort(int lowerIndex, int higherIndex) {
		int i = lowerIndex;
		int j = higherIndex;
		// taking pivot as middle index number
		int pivot = a[lowerIndex + (higherIndex - lowerIndex) / 2];
		while (i <= j) {

			while (a[i] < pivot) {
				i++;
			}
			while (a[j] > pivot) {
				j--;
			}
			if (i <= j) {
				swap(i, j);
				i++;
				j--;
			}
			
			if (lowerIndex < j)
	            quickSort(lowerIndex, j);
	        if (i < higherIndex)
	            quickSort(i, higherIndex);
		}
	}

	private static void swap(int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {

		a = new int[] { 24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12 };
		int l = a.length;
		quickSort(0, l - 1);
		printElts();
	}
	
	public static void printElts() {
		for (int i=0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
