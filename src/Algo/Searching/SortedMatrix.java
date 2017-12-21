package Algo.Searching;

public class SortedMatrix {

	static int[][] A;
	
	public static boolean seach(int srch) {

		int i = 0, j = A.length - 1;

		while (i < A.length && j >= 0) {
			if (A[i][j] == srch) {
				System.out.println("Element is present at \n row :: " + i + " column :: " + j);
				return true;
			} else if (A[i][j] > srch)
				j--;
			else // if A[i][j] < x
				i++;
		}

		return false;
	}
	
	public static void main(String[] args) {
		A = new int[][]{{10, 20, 30, 40},
            			{15, 25, 35, 45},
            			{27, 29, 37, 48},
            			{32, 33, 39, 50}};
        if(!seach(29))
        	System.out.println("Element is not present");
	}
}
