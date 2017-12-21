package Algo.Hashing;

import Algo.Sorting.QuickSort;
/* QN :: Find the missing elements in the given array between the range low and high 
 * Time Complexity :: O(nLogn + k) */
public class MissingEltsSorting {
	static int A[];
	static int low, high;

	public static void printMissing() {

		// Do binary search -> O(log n)
		int index = binSrch();

		int i = index, x = low;
		while (i < A.length && x <= high) {
			// If x doesn't math with current element print it
			if (A[i] != x) {
				System.out.print(x + " ");
			// If x matches, move to next element in A[]
			}else{
				i++;
			}
			// Move to next element in range [low, high]
			x++;
		}

		// Print range elements that are greater than the last element of sorted array.
		while (x <= high) {
			System.out.print(x++ + " ");
		}

	}

	// O(log k)
	public static int binSrch() {

		int loIndex = 0;
		int hiIndex = A.length - 1;
		int midIndex;
		while (loIndex <= hiIndex) {
			midIndex = (loIndex + hiIndex) / 2;
			if (low > A[midIndex])
				loIndex = midIndex + 1;
			else if (low < A[midIndex])
				hiIndex = midIndex - 1;
			else if (low == A[midIndex])
				return midIndex;
		}

		return (loIndex > hiIndex)? loIndex : hiIndex;
	}

	public static void main(String[] args) {
		A = new int[] {1, 3, 5, 4, 7};
		low = 6;
		high = 10;
		//O(nLogn)
		QuickSort.a = A;
		QuickSort.quickSort(0, A.length - 1);
		printMissing();
	}
	
	/*
	  ALGORITHM :-
	  1) First sort the array
	  2) Take the index that is equal or greater than low
	  3) Iterate over the array from index
	         if (low is not in array)
	             print low;
	         else 
	             goto next elt in array
	         increment low
	  4) Till high is reached
	         increment low and print
	  */
}
