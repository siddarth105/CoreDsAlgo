package Algo.DFS;

public class SameCodeInMatrix {
	
		static int ROW = 0, COL = 0;

		boolean isSafe(int M[][], int row, int col, boolean visited[][], int val) {
			return (row >= 0) && (row < ROW) 
					&& (col >= 0) && (col < COL) 
					&& (M[row][col] == val && !visited[row][col]);
		}

		void DFS(int M[][], int row, int col, boolean visited[][]) {
			int rowNbr[] = new int[] {-1, 1, 0, 0};
			int colNbr[] = new int[] {0, 0, -1, 1,};
			visited[row][col] = true;
			int val = M[row][col];
			for (int k = 0; k < 4; ++k)
				if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited, val))
					DFS(M, row + rowNbr[k], col + colNbr[k], visited);
		}

		int countIslands(int M[][]) {
			ROW = M.length; COL = M[0].length;
			boolean visited[][] = new boolean[ROW][COL];
			int count = 0;
			int prev = -1;
			for (int i = 0; i < ROW; ++i)
				for (int j = 0; j < COL; ++j)
					if (M[i][j] != prev && !visited[i][j]) {
						DFS(M, i, j, visited);
						++count;
						System.out.println("Island - " + count);
						printIsland(visited);
					}
			return count;
		}

		public static void printIsland(boolean[][] islandVal) {
			for (int i = 0; i < islandVal.length; i++) {
				for (int j = 0; j < islandVal[i].length; j++) {
					if (islandVal[i][j])
						System.out.print(1 + " ");
					else
						System.out.print(0 + " ");
				}
				System.out.println();
			}
			System.out.println();
		}

		public static void main(String[] args) throws java.lang.Exception {
			int M[][] = new int[][] {{5,4,4},
									{4,3,4},
									{3,2,4},
									{2,2,2},
									{3,3,4},
									{1,4,4},
									{4,1,1}};
			
			/*int M[][] = new int[][] { { 1, 1, 0, 0, 0 }, 
			 { 0, 1, 0, 0, 1 }, 
			 { 1, 0, 0, 1, 1 }, 
			 { 0, 0, 0, 0, 0 },
			 { 1, 0, 1, 0, 1 } };*/						
			SameCodeInMatrix I = new SameCodeInMatrix();
			System.out.println("Number of islands is: " + I.countIslands(M));
		}

}
