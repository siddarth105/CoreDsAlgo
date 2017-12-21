package Algo.DynamicPgm;

public class Fibonacci {
	
	public static int fibonacciDP(int n) {
	    int[] results = new int[n+1];
	    results[1] = 1;
	    results[2] = 1;
	    System.out.print(results[1]+ " " + results[2]+ " ");
	    for (int i = 3; i <= n; i++) {
	        results[i] = results[i-1] + results[i-2];
	        System.out.print(results[i]+ " ");
	    }
	    return results[n];
	}

	public static void main(String[] args){
		fibonacciDP(10);
	}

}
