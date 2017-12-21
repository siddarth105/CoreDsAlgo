package Algo.Searching;

/*QN :: a 2D matrix contains only zero's and one's
	  	all rows are sorted
	  	find the row with maximum number of 1's
	  	
  TIME-COMPLEXITY :: O(nlogn)
   					 Binary search for a single row = logn
   					 Binary search for n rows = nlogn
*/

public class Max1Row {
	static int[][] a;
	
	public static int getMaxOne() {
		
		int maxOne = 0;
		int row = 0;
		
		for (int i = 0; i < a.length; i++) {
			int indx = binSrch(a[i]);
			int oneNum = a[i].length - indx;
			if (oneNum > maxOne) {
				maxOne = oneNum;
				row = i;
			}
		}
		
		return row;
	}
	
	public static int binSrch(int[] b){
		
		int l = 0;
		int r = b.length - 1;
		
		while (l < r) {
			int mid = l + (r-l)/2;
			if (b[mid] == 0) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		
		return l;
		
	}
	
	public static void main (String[] args) {
		
		a = new int[][]{{0,0,0,0,1,1,1,1},
						{0,0,1,1,1,1,1,1},
						{1,1,1,1,1,1,1,1},
						{0,0,0,0,0,0,0,1},
						{0,0,0,0,0,0,0,0}};
						
		getMaxOne();
		
	}
}
