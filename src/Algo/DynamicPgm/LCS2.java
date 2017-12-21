package Algo.DynamicPgm;

public class LCS2 {
	
	static char z[];

	public static int LCS(char[] a, char[] b, int m, int n) {
				
		if (m==0 || n==0) {
			return 0;
		}
		if (a[m-1] == b[n-1]) {
			 z[m-1] =  a[m-1];
			 return (1 + LCS(a, b, m-1, n-1));
		} else {
		     return Math.max(LCS(a, b, m, n-1), LCS(a, b, m-1, n));
		}
	}
	
	 public static void main(String[] args) {
	        String x = "abcdefg";
	        String y = "zacg";
	        
	        z = new char[x.length()];
	        
	        int k = LCS(x.toCharArray(),y.toCharArray(),x.length(),y.length());
	        System.out.println("Length of Max Common Subseq :: " + k);
	        
	        System.out.println(z);
	}
}
