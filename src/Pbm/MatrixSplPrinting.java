package Pbm;

public class MatrixSplPrinting {

	public static void spiralPrint(int[][] a) {
		int k = 0;
		int l = 0;
		int m = a.length;
		int n = a[0].length;

		while (k < m && l < n) {

			for (int i = l; i < n; i++) {
				System.out.print(a[k][i] + " ");
			}
			k++;

			for (int i = k; i < m; i++) {
				System.out.print(a[i][n - 1] + " ");
			}
			n--;

			if (k < m) {
				for (int i = n-1; i >= l; i--) {
					System.out.print(a[m-1][i] + " ");
				}
				m--;
			}

			if (l < n) {
				for (int i = m-1; i >= k; i--) {
					System.out.print(a[i][l] + " ");
				}
				l++;
			}
		}
	}

	public static void main(String[] args) {
		int a[][] =  {{ 1,  2,  3, 4}, 
					  {12, 13, 14, 5}, 
					  {11, 16, 15, 6}, 
					  {10,  9,  8, 7}};
		spiralPrint(a);
	}

}
