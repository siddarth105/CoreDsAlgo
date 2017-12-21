package Algo.Hashing;

import java.util.HashSet;
import java.util.Set;

public class PairPrdtHashing {
	
	static int A[];
	
	public static boolean isProd(int prd) {
		
		Set<Integer> st = new HashSet<Integer>();
		
		for (int i = 0; i < A.length; i++) {
			if (prd % A[i] == 0) {
				if (st.contains(prd / A[i])) {
					return true;
				}
				st.add(A[i]);
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		A = new int[] {10, 20, 9, 40};
		int x = 400;
		System.out.println("IS-PROD :: " + isProd(x));
	}
}
