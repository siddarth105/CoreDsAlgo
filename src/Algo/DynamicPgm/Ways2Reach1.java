package Algo.DynamicPgm;

public class Ways2Reach1 {

	public int memo[] = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
	public int dp[];

	public int getMinSteps(int n) {
		
		// BASE_CASE :: If the given number is itself 1, then the number of ways to reach 1 from given number is 0
		if (n == 1)
			return 0; 
		
		if (memo[n] != -1)
			return memo[n]; 
		
		int r = 1 + getMinSteps(n - 1); // '-1' step . 'r' will contain the optimal answer finally
		if (n % 2 == 0)
			r = Math.min(r, 1 + getMinSteps(n / 2)); // '/2' step
		if (n % 3 == 0)
			r = Math.min(r, 1 + getMinSteps(n / 3)); // '/3' step
		
		// save the result
		memo[n] = r; 
		
		return r;
	}
	
	// Bottom-Up Approach 
	public int getMinSteps2(int n) {
		
		dp = new int[n+1];
		
		// BASE_CASE :: If the given number is itself 1, then the number of ways to reach 1 from given number is 0
		dp[1] = 0;
		
		for(int i = 2 ; i <= n ; i ++ ) {
			dp[i] = 1 + dp[i-1]; // '-1' step
			if (i % 2 == 0)
				dp[i] = Math.min(dp[i], 1 + dp[i / 2]); // '/2' step
			if (i % 3 == 0)
				dp[i] = Math.min(dp[i], 1 + dp[i / 3]); // '/3' step
		}
		
		return dp[n];
	}
	
	
	public static void main(String[] args) {
		
		Ways2Reach1 wy = new Ways2Reach1();
		System.out.println("Shortest :: " + wy.getMinSteps(10));
		System.out.println("Shortest using top_down :: " + wy.getMinSteps2(10));
		for (int i=1; i <= 10; i++) {
			System.out.println(wy.dp[i]);
		}
	}

}
