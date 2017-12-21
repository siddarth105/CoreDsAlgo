package Algo.DynamicPgm;

public class LargestSumArray {

	/*QN :: Find the sub-array with the largest sum 
	  Time Complexity :: O(n)
	  I/P :: -1, -3, 4, -1, -2, 1, 5, -3
	  O/P :: 4, -1, -2, 1, 5 :: 7 */
	
	/*when cur_max is not equal to cur_sum -> i is Start
	Change in max_sofar is the End*/
	
	static int maxSubArraySum(int a[], int size) {
		int max_so_far = a[0];
		int curr_max = a[0];
		int prev_max_so_far = max_so_far;
		int end = 0;
		int start = 0;

		for (int i = 1; i < size; i++) {
			int cur_sum = curr_max + a[i];
			curr_max = Math.max(a[i], cur_sum);
			max_so_far = Math.max(max_so_far, curr_max);
			
			if (cur_sum != curr_max) {
				start = i;
			}
			if (prev_max_so_far != max_so_far) {
				end = i;
			}
			
			prev_max_so_far = max_so_far;
		}
		
		System.out.println("Start index is :: "+ start);
		System.out.println("End index is :: "+ end);
		
		return max_so_far;
	}

	public static void main(String[] args) {

		int a[] = { -1, -3, 4, -1, -2, 1, 5, -3 };
		/*int a[] = {3, -10, 1, 6, -5, 4};*/
		int max_sum = maxSubArraySum(a, a.length);
		System.out.println("Maximum contiguous sum is " + max_sum);
	}
}
