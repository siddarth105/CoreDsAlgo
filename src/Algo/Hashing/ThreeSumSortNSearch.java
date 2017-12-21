package Algo.Hashing;

import Algo.Sorting.QuickSort;

public class ThreeSumSortNSearch {

	static int A[];
	
	
	public static boolean printpairs(int sum) {

		for (int k = 0; k < A.length; k++) {
			int l = k + 1;
			int r = A.length - 1;
			while (l < r) {
				if (A[k] + A[l] + A[r] == sum) {
					System.out.println("Points with given sum " + sum + " is ("+ A[k] +", "+ A[l] + ", " + A[r] + ")");
					return true;
				} else if (A[k] + A[l] + A[r] < sum) {
					l++;
				} else { // A[i] + A[j] > sum
					r--;
				}
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		A = new int[] { 1, 4, 6, 45, 10, 8 };
		int s = 11;
		QuickSort.a = A;
		QuickSort.quickSort(0, A.length - 1);
		printpairs(s);
	}
}
