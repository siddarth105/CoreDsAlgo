package Algo.DynamicPgm;

public class LisLen {
	
	static int A[];

	// Binary search (note boundaries in the caller)
	// A[] is ceilIndex in the caller
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

	static int LngIncSub() {

		int[] tailTable = new int[A.length];
		
		tailTable[0] = A[0];
		int len = 1;

		
		for (int i = 1; i < A.length; i++) {
			if (A[i] < tailTable[0])
				// new smallest value
				tailTable[0] = A[i];

			else if (A[i] > tailTable[len - 1])
				// A[i] wants to extend largest subsequence
				tailTable[len++] = A[i];

			else
				// A[i] wants to be current end candidate of an existing subsequence. It will replace ceil value in tailTable
				tailTable[CeilIndex(tailTable, -1, len - 1, A[i])] = A[i];
		}

		return len;
	}

	// Driver program to test above function
	public static void main(String[] args) {
		A = new int[]{ 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		System.out.println("Length of Longest Increasing Subsequence is " + LngIncSub());
	}

}
