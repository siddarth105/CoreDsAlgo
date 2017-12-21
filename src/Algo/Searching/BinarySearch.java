package Algo.Searching;

/*	Sorting the Array before Search
 * 	Time Complexity : Worst Case :: O(log n)	*/

public class BinarySearch {
	
	public static int[] x;
	public static int srch;
	
	public static boolean binSrch() {
		
		int loIndex = 0;
		int hiIndex = x.length - 1;
		int midIndex;
		while (loIndex <= hiIndex) {
			midIndex = (loIndex + hiIndex) / 2;
			if (srch > x[midIndex])
				loIndex = midIndex + 1;
			else if (srch < x[midIndex])
				hiIndex = midIndex - 1;
			else
				break;
		}
		
		if (loIndex < hiIndex) {
			return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		x = new int[]{ -5, 12, 15, 20, 30, 72, 456 };
		srch = 31;
		if (binSrch()) {
			System.out.println("Element found");
		} else {
			System.out.println("Element not found");
		}
	}

}
