package Algo.DynamicPgm;

public class PathWithMaxAvg {
	
	static int a[][];
	
	static double maxSumPath () {
		int[][] dp = new int[a.length + 1][a.length + 1];
		dp[0][0] = a[0][0];
		
		for (int i = 1; i < a.length; i++) {
			dp[i][0] = dp[i-1][0] + a[i][0];
		}
		
		for (int i = 1; i < a.length; i++) {
			dp[0][i] = dp[0][i-1] + a[0][i];
		}
		
		for (int i = 1; i < a.length; i++) {
			for(int j = 1; j < a.length; j++) {
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + a[i][j];
			}
		}
		
		return dp[a.length-1][a.length-1];
	}
	
	public static void main (String[] args) {
		a = new int[][] {{1, 2, 3},
						 {6, 5, 4},
						 {7, 3, 9}}; 
		double max_sum = maxSumPath();
		System.out.println("Path with maximum sum :: " + max_sum);
		System.out.println("Path with maximum avg :: " + max_sum/(2*a.length -1) );
	}

}
