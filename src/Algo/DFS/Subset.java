package Algo.DFS;
//Generate all the subsets of a given set
public class Subset {
	
	static char A[];
	static int size;
	
	static void generateSubsets(char[] c, int c_size, int k) {
		
		for(int i = 0; i < c_size; i++) {
	        System.out.print(c[i] + " ");
	    }
		System.out.println();
		
		for (int i = k; i < size; i++) {
			c[c_size] = A[i];
			generateSubsets(c, c_size+1, i+1);
		}
	}
	
	public static void main(String[] args) {
		A = new char[]{'a', 'b', 'c'};
		size = A.length;
		generateSubsets(new char[size], 0, 0);
	}

}
