package Algo.Hashing;
/*	QN :: Find the pair with the given sum, not necessary to be adjacent 
	Time Complexity :: O(n)	*/
public class PairSumHashing {

	private static final int MAX = 100000; // Max size of Hashmap -> depends on the max element in A

	static void printpairs(int arr[], int sum) {
		
		boolean[] binmap = new boolean[MAX];
		for (int i = 0; i < arr.length; ++i) {
			
			int temp = sum - arr[i];
			if (temp >= 0 && binmap[temp]) {
				System.out.println("Pair with given sum " + sum + " is (" + arr[i] + ", " + temp + ")");
			}
			binmap[arr[i]] = true;
		}
	}

	public static void main(String[] args) {
		int A[] = { 1, 4, 6, 45, 10, 8 };
		int sum = 16;
		printpairs(A, sum);
	}
}
