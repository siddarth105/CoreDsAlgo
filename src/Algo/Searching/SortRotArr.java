package Algo.Searching;

/*
 * Search an element in a sorted and rotated array
 * Time_Complexity :: O(logN)
 */

public class SortRotArr {

	static int[] arr;
	static int len;

	/* Searches an element key in a pivoted sorted array arr[] of size n */
	static int pivotedBinarySearch(int key) {
		int pivot = findPivot(0, len - 1);

		// If we didn't find a pivot, then array is not rotated at all
		if (pivot == -1)
			return binarySearch(0, len - 1, key);

		// If we found a pivot, then first compare with pivot and then search in two subarrays around pivot
		if (arr[pivot] == key)
			return pivot;
		if (arr[0] <= key)
			return binarySearch(0, pivot - 1, key);
		return binarySearch(pivot + 1, len - 1, key);
	}

	/*
	 * Function to get pivot. For array 3, 4, 5, 6, 1, 2 it returns 3 (index of 6)
	 */
	static int findPivot(int low, int high) {
		// base cases
		if (high < low)
			return -1;
		if (high == low)
			return low;

		int mid = (low + high) / 2; /* low + (high - low)/2; */
		if (mid < high && arr[mid] > arr[mid + 1])
			return mid;
		if (mid > low && arr[mid] < arr[mid - 1])
			return (mid - 1);
		if (arr[low] >= arr[mid])
			return findPivot(low, mid - 1);
		return findPivot(mid + 1, high);
	}

	/* Standard Binary Search function */
	static int binarySearch(int low, int high, int key) {
		if (high < low)
			return -1;
		int mid = (low + high) / 2; /* low + (high - low)/2; */
		if (key == arr[mid])
			return mid;
		if (key > arr[mid])
			return binarySearch((mid + 1), high, key);
		return binarySearch(low, (mid - 1), key);
	}

	public static void main(String[] args) {
		arr = new int[] { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
		len = arr.length;
		System.out.println(pivotedBinarySearch(2));
	}
	
	/*ALGORITHM :-
	Input arr[] = {3, 4, 5, 1, 2}
	Element to Search = 1
	  1) Find out pivot point and divide the array in two
	      sub-arrays. (pivot = 2) Index of 5
	  2) Now call binary search for one of the two sub-arrays.
	      (a) If element is greater than 0th element then
	             search in left array
	      (b) Else Search in right array
	          (1 will go in else as 1 < 0th element(3))
	  3) If element is found in selected sub-array then return index
	     Else return -1.*/
}
