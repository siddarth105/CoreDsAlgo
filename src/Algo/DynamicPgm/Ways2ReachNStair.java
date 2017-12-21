package Algo.DynamicPgm;
/*There are n stairs, a person standing at the bottom wants to reach the top. 
 * The person can climb either 1 stair or 2 stairs at a time. 
 * Count the number of ways, the person can reach the top.
 *      FIBONACCI SERIES + 1	
 *      w(n) = w(n-1) + w(n-2)
 *      n stairs in m ways
 *      w(n,m) = w(n-1) + w(n-2) + ... + w(n-m) */
public class Ways2ReachNStair {
	
	public static int fibonacciDP(int n, int m) {
	    int[] results = new int[n+1];
	    results[1] = 1;
	    results[2] = 1;
	    for (int i = 3; i <= n; i++) {
	    	results[i] = 0;
	    	for (int j = 1; j <= m &&  j <= i; j++) {
	    		//results[i] = results[i-1] + results[i-2] + .... + results[i-m];
	    		results[i] = results[i] +  results[i-j];
	    	}
	    }
	    return results[n];
	}

	public static void main(String[] args){
		int n = 4;
		int m = 2;
		int k = fibonacciDP(n + 1, m);
		System.out.println("Number of ways to reach " + n + " stairs climbing upto " + m 
				+ " stairs at a time is :: " + k );
	}
}
