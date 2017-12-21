package Algo.Hashing;
import Algo.Sorting.QuickSort;
/*	QN :: Find the pair with the given sum, not necessary to be adjascent 
	Time Complexity :: O(n^2)	*/
public class PairSumSortNSearch {

	static int A[];

	public static boolean printpairs(int sum) {

		int l = 0;
		int r = A.length - 1;
		while (l < r) {
			if (A[l] + A[r] == sum) {
				System.out.println("Pair with given sum " + sum + " is (" + A[l] + ", " + A[r] + ")");
				return true;
			} else if (A[l] + A[r] < sum) {
				l++;
			} else { // A[i] + A[j] > sum
				r--;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		A = new int[] { 1, 4, 6, 45, 10, 8 };
		int s = 16;
		QuickSort.a = A;
		QuickSort.quickSort(0, A.length - 1);
		printpairs(s);
	}
	
	
	/*	Let Array be {1, 4, 45, 6, 10, -8} and sum to find be 16
	
		Sort the array
		A = {-8, 1, 4, 6, 10, 45}
	
		Initialize l = 0, r = 5
		A[l] + A[r] ( -8 + 45) > 16 => decrement r. Now r = 10
		A[l] + A[r] ( -8 + 10) < 16 => increment l. Now l = 1
		A[l] + A[r] (  1 + 10) < 16 => increment l. Now l = 2
		A[l] + A[r] (  4 + 10) < 16 => increment l. Now l = 3
		A[l] + A[r] (  6 + 10) == 16 => Found candidates (return true)*/
}
