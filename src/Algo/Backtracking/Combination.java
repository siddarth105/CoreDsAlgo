package Algo.Backtracking;

public class Combination {
	
	static char A[];
	static int n,r;
	static char data[];
	
	/* A[]  ---> Input Array
    data[] ---> Temporary array to store current combination
    index  ---> Current index in data[]
    r ---> Size of a combination to be printed */
	public static void printCombination(int index, char data[], int i) {
		
		if (index == r) {
			for (int k = 0; k < r; k++) {
				System.out.print(data[k] + " ");
			}
			System.out.println();
			return;
		}
		
		if (i >= n) {
			return;
		}
		
		data[index] = A[i];
		printCombination(index+1, data, i+1);
		printCombination(index, data, i+1);
	}
	
	
	public static void main(String[] args) {
		A = new char[]{'a', 'b', 'c', 'd', 'e'};
		r = 3;
        n = A.length;
        data = new char[r];
        printCombination(0, data, 0);
	}

}
