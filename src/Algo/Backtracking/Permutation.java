package Algo.Backtracking;

public class Permutation {

	/*
	 * k is used to increase the levels 
	 * i is used to swap the char at level k, starting from a[k] till a.length 
	 * Output is printed only when k reaches the final level
	 * Backtrack, where i gets increased by 'for-loop' to print the next variation
	 */
	static void permute(char[] a, int k) {
		// BASE_CASE :: when k reaches the last level (length of the array)
		if (k == a.length) {
			for (int i = 0; i < a.length; i++) {
				System.out.print(" [" + a[i] + "] ");
			}
			System.out.println();
		} else {
			for (int i = k; i < a.length; i++) {
				char temp = a[k];
				a[k] = a[i];
				a[i] = temp;

				System.out.println("Before -> i = " + i + " k = " + k);
				permute(a, k + 1);
				System.out.println("After -> i = " + i + " k = " + k);

				// BACK_TRACK :: Unswap the swapped to make the string original
				temp = a[k];
				a[k] = a[i];
				a[i] = temp;
			}
		}
	}

	public static void main(String args[]) {
		char[] sequence = { 'a', 'b', 'c' };

		System.out.println("\nThe permuted sequences are: ");
		permute(sequence, 0);
	}
}
