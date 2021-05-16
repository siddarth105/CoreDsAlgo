package Algo.Hashing;

import Algo.Sorting.QuickSort;

// https://leetcode.com/problems/3sum-with-multiplicity/

public class ThreeSumSortNSearch2 {

	static int A[];
	
	public static boolean printpairs(int sum) {

		for (int k = 0; k < A.length; k++) {
			int l = k + 1;
			int r = A.length - 1;
			while (l < r) {
				if (A[k] + A[l] + A[r] == sum) {
					System.out.println("Points with given sum " + sum + " is ("+ A[k] +", "+ A[l] + ", " + A[r] + ")");
					
					int numOfL = 1; int numOfR = 1;
					while (l+1 < r && A[l] == A[l+1]) {
                        l++; numOfL++;
                    }
					System.out.println("numOfL :: " + numOfL);
                    while (r-1 > l && A[r] == A[r-1]) {
                        r--; numOfR++;
                    }
                    System.out.println("numOfR :: " + numOfR);
                    l++; r--; 
					//return true;
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
		A = new int[] { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
		int s = 8;
		/*A = new int[] { 1, 1, 2, 2, 2, 2};
		s = 5;*/
		QuickSort.a = A;
		QuickSort.quickSort(0, A.length - 1);
		printpairs(s);
	}

}
