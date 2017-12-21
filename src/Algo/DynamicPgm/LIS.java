package Algo.DynamicPgm;

public class LIS {

	// http://www.geeksforgeeks.org/?p=9591

	static int A[];

	// Binary search
	// A[] is ceilIndex in the caller
	static int getCeilIndex(int[] T, int l, int r, int key) {
		while (r - l > 1) {
			int m = l + (r - l) / 2;
			if (A[T[m]] >= key)
				r = m;
			else
				l = m;
		}
		return r;
	}

	static int LngIncSub() {

		int[] tailIndices = new int[A.length];
		int[] prevIndices = new int[A.length];
		for (int k = 0; k < prevIndices.length; k++) {
			prevIndices[k] = -1;
		}
		int len = 1;

		for (int i = 1; i < A.length; i++) {
			if (A[i] < A[tailIndices[0]]) {

				tailIndices[0] = i;

			} else if (A[i] > A[tailIndices[len - 1]]) {

				prevIndices[i] = tailIndices[len - 1];
				tailIndices[len++] = i;

			} else {

				int pos = getCeilIndex(tailIndices, -1, len - 1, A[i]);
				prevIndices[i] = tailIndices[pos - 1];
				tailIndices[pos] = i;
			}
		}

		for (int i = tailIndices[len - 1]; i >= 0; i = prevIndices[i]) {
			System.out.print(A[i] + " ");
		}
		System.out.println();

		return len;
	}

	// O(logN)
	static int CeilIndex(int A[], int l, int r, int key) {
		while (r - l > 1) {
			int m = l + (r - l) / 2;
			if (A[m] >= key)
				r = m;
			else
				l = m;
		}

		return r;
	}

	// O(nlogn)
	static int LongestIncreasingSubsequenceLength() {
		// Add boundary case, when array size is one

		int[] tailTable = new int[A.length];
		int len; // always points empty slot

		tailTable[0] = A[0];
		len = 1;
		for (int i = 1; i < A.length; i++) {
			if (A[i] < tailTable[0]) {
				// new smallest value
				tailTable[0] = A[i];

			} else if (A[i] > tailTable[len - 1]) {
				// A[i] wants to extend largest subsequence
				tailTable[len++] = A[i];

			} else {
				// A[i] wants to be current end candidate of an existing
				// subsequence. It will replace ceil value in tailTable
				tailTable[CeilIndex(tailTable, -1, len - 1, A[i])] = A[i];
			}
		}
		
		printArr(tailTable);

		return len;
	}
	
	public static void printArr(int[] a) {
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		
	}

	// Driver program to test above function
	public static void main(String[] args) {
		A = new int[] { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
		A = new int[] { 2, 5, 3, 7, 11, 8, 10, 13, 6 };
		System.out.println("Length of Longest Increasing Subsequence is " + LngIncSub());
		System.out.println("Length of Longest Increasing Subsequence is " + LongestIncreasingSubsequenceLength());
	}

}
