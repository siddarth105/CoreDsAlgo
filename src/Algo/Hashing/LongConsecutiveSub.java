package Algo.Hashing;

import java.util.HashSet;
import java.util.Set;

/* QN :: 
 * Given an array of integers, 
 * find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers,
 * the consecutive numbers can be in any order.
 *
 * TIME COMPLEXITY :: O(n)*/
public class LongConsecutiveSub {
	
	static int findLongestConseqSubseq(int arr[], int n) {
		Set<Integer> S = new HashSet<Integer>();
		int ans = 0;

		for (int i = 0; i < n; ++i)
			S.add(arr[i]);

		for (int i = 0; i < n; ++i) {
			if (!S.contains(arr[i] - 1)) { // S.contains -> O(n)
				
				// arr[i] is the starting point of the sequence
				int j = arr[i];
				while (S.contains(j)) {
					System.out.print(j + " ");
					j++;
				}
				System.out.println();
				
				if (ans < j - arr[i])
					ans = j - arr[i];
			}
		}
		return ans;
	}

	// Testing program
	public static void main(String args[]) {
		int arr[] = { 1, 9, 3, 10, 4, 20, 2 };
		int n = arr.length;
		System.out.println("Length of the Longest consecutive subsequence is " + findLongestConseqSubseq(arr, n));
	}
}
