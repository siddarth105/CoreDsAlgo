package Algo.DFS;

import Algo.Sorting.QuickSort;

/* QN :: Given an array, print all the possible combinations that gives the sum 's'
 * ASSUMPTIONS :: 1) No duplicates are presented 
				 2) All are Non-Negative
				*/
public class MaxSubsetSum {

	static int A[];
	static int size;
	
	static void subset_sum(int c[], int c_size, int sum, int k, int target_sum) {

		//BASE_CASE
		if (target_sum == sum) {
			// We found sum
			for(int i = 0; i < c_size; i++) {
		        System.out.print(c[i] + " ");
		    }
			System.out.println();

			// constraint check
			if (k + 1 < size && sum - A[k] + A[k + 1] <= target_sum) {
				// Exclude previous added item and consider next candidate
				subset_sum(c, c_size - 1, sum - A[k], k + 1, target_sum);
			}
			return;
		} else {
			// constraint check
			if (k < size && sum + A[k] <= target_sum) {
				// generate nodes along the breadth
				for (int i = k; i < size; i++) {
					c[c_size] = A[i];

					if (sum + A[i] <= target_sum) {
						// consider next level node (along depth)
						subset_sum(c, c_size + 1, sum + A[i], i + 1, target_sum);
					}
				}
			}
		}
	}
	
	static void generateSubsets(int target_sum) {
		int[] comb = new int[size];
		int total = 0;

		// sort the set
		QuickSort.a = A;
		QuickSort.quickSort(0, A.length - 1);

		for (int i = 0; i < size; i++) {
			total += A[i];
		}

		if (A[0] <= target_sum && total >= target_sum) {
			subset_sum(comb, 0, 0, 0, target_sum);
		}
	}
	
	public static void main (String[] args) {
		/*A = new int[] {15, 22, 14, 26, 32, 9, 16, 8};*/
		A = new int[] {8, 4, 6, 2};
		size = A.length;
		/*int s = 53;*/
		int s = 10;
		
		generateSubsets(s);
		
	}
	
	/*
	ALGORITHM :-
	1) Similar to permutations
	2) k is used to move down the level
    3) i is used to move left to right
    4) Limit the generation of nodes using the constraint check
    */
}
