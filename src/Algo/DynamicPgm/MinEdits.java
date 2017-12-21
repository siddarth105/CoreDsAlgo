package Algo.DynamicPgm;
/*QN :-
Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required to convert ‘str1′ into ‘str2′.
	1.Insert
	2.Remove
	3.Replace	*/
public class MinEdits {
	
	/*TIME_COMPLEXITY :: O(3^m)*/
	static int editDist(String str1, String str2, int m, int n) {
		// If first string is empty, insert all characters of second string into first
		if (m == 0)
			return n;

		// If second string is empty, remove all characters of first string
		if (n == 0)
			return m;

		// If last characters of two strings are same
		if (str1.charAt(m - 1) == str2.charAt(n - 1))
			return editDist(str1, str2, m - 1, n - 1);

		return 1 + Math.min(editDist(str1, str2, m, n - 1), // Insert
				Math.min(editDist(str1, str2, m - 1, n), // Remove
						editDist(str1, str2, m - 1, n - 1)) // Replace
		);
	}
	
	/*	TIME_COMPLEXITY: O(m x n)
		SPACE_COMPLEXITY: O(m x n)*/
	static int editDistDP(String str1, String str2, int m, int n) {
		
		int dp[][] = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0) {
					dp[i][j] = j;

				} else if (j == 0) {
					dp[i][j] = i; 

				} else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];

				} else {
					dp[i][j] = 1 + Math.min(dp[i][j - 1], // Insert
									Math.min(dp[i - 1][j], // Remove
									dp[i - 1][j - 1])); // Replace
				}
			}
		}

		printArray(dp);
		return dp[m][n];
	}
	
	public static void printArray(int dp[][]) {
		
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		String str1 = "sunday";
        String str2 = "saturday";
        System.out.println(editDist( str1 , str2 , str1.length(), str2.length()));
        
        str1 = "geek";
        str2 = "gesek";
        System.out.println(editDistDP( str1 , str2 , str1.length(), str2.length()));
	}
}
/*	ALGORITHM :- 
	1. If last characters of two strings are same, nothing much to do. Ignore last characters and get count for remaining strings. So we recur for lengths m-1 and n-1.
	2. Else (If last characters are not same), we consider all operations on ‘str1′, consider all three operations on last character of first string, recursively compute minimum cost for all three operations and take minimum of three values.
		Insert: Recur for m and n-1
		Remove: Recur for m-1 and n
		Replace: Recur for m-1 and n-1	*/