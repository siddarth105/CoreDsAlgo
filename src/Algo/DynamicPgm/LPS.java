package Algo.DynamicPgm;
/*TIME_COMPLEXITY :: O(n^2)*/
public class LPS {
	
	public static void print(boolean[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j]) {
					System.out.print("t ");
				} else {
					System.out.print("f ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void printSubStr(String val, int low, int high) {
		for (int i = low; i <= high; ++i) {
			System.out.print(val.charAt(i));
		}
	}
	
	public static int print(boolean[][] arr, int[] c) {
		
		for (int i=0; i < c.length; i++)
	    {
	        if (arr[0][i] == true)
	            c[i] = 0;
	        else
	        {
	            c[i] = 99999;
	            for(int j=0; j < i; j++)
	            {
	                if(arr[j+1][i] == true && 1+c[j]<c[i])
	                    c[i]=1+c[j];
	            }
	        }
	    }
	  
	    return c[c.length -1];
	}

	public static int lps(String val) {

		int n = val.length();
		boolean table[][] = new boolean[n][n];
		int[] c = new int[n];
		int maxLength = 1;

		// All substrings of length 1 are palindromes
		for (int i = 0; i < n; i++) {
			table[i][i] = true;
		}

		// Check for sub-string of length 2
		int start = 0;
		for (int i = 0; i < n -1; i++) {
			if (val.charAt(i) == val.charAt(i + 1)) {
				table[i][i + 1] = true;
				start = i;
				maxLength = 2;
			}
		}

		// Check for lengths greater than 2. k is length of substring
		for (int k = 3; k <= n; ++k) {
			// Fix the starting index
			for (int i = 0; i < n - k + 1; ++i) {
				// Get the ending index of substring from
				// starting index i and length k
				int j = i + k - 1;

				// checking for sub-string from ith index to
				// jth index iff str[i+1] to str[j-1] is a palindrome
				if (table[i + 1][j - 1] && val.charAt(i) == val.charAt(j)) {
					table[i][j] = true;
					if (k > maxLength) {
						start = i;
						maxLength = k;
					}
				}
			}
		}
		
		System.out.println("Minimum cuts required :: " + print(table, c));

		printSubStr(val, start, start + maxLength - 1);
		return maxLength;
	}

	public static void main(String[] args) {
		String val = "forgeeksskeegfor";
		//val = "ababbbabbababa"; 
		lps(val);
	}
}
