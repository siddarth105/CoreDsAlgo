package Algo.DynamicPgm;

public class MinJumps {

	// TIME_COMPLEXITY :: O(n)
	static int minJumps(int arr[]) {
		if (arr.length <= 1)
			return 0;

		// Return -1 if not possible to jump
		if (arr[0] == 0)
			return -1;

		// initialization
		int maxReach = arr[0];
		int step = arr[0];
		int jump = 1;

		for (int i = 1; i < arr.length; i++) {

			// BASE_CASE : Check if we have reached the end of the array
			if (i == arr.length - 1)
				return jump;

			maxReach = Math.max(maxReach, i + arr[i]);
			step--;

			// If no further steps left
			if (step == 0) {
				// we must have used a jump
				jump++;

				// Check if the current index/position or lesser index
				// is the maximum reach point from the previous indexes
				if (i >= maxReach)
					return -1;

				// re-initialize the steps to the amount
				// of steps to reach maxReach from position i.
				step = maxReach - i;
			}
		}

		return -1;
	}

	public static void main(String[] args) {

		int[] arr = { 2, 3, 1, 1, 4};
		//arr = new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		System.out.println("Minimum number of jumps to reach end is : " + minJumps(arr));
	}

}
