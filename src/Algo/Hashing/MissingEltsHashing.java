package Algo.Hashing;

import java.util.HashSet;
import java.util.Set;

/*Time Complexity ::  O(n + (high-low+1))*/

public class MissingEltsHashing {
	static int A[];
	static int low, high;
	static Set<Integer> hasSet;
	
	static void printMissing() {
		
		hasSet = new HashSet<Integer>();
		for (int i : A) {
			hasSet.add(i);
		}
		for (int i = low; i <= high; i++) {
			if(!hasSet.contains(i)) // hasSet.contains -> O(n)
				System.out.print(i + " ");
		}
		
	}
	
	public static void main(String[] args) {
		A = new int[] {1, 3, 5, 4, 7};
		low = 6;
		high = 10;
		printMissing();
	}
}
