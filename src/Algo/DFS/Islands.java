package Algo.DFS;
//https://www.interviewbit.com/problems/word-search-board/
public class Islands {

	// No of rows and columns
	static final int ROW = 5, COL = 5;

	// Core Logic : to identify the cells
	boolean isSafe(int M[][], int row, int col, boolean visited[][]) {
		// row number is in range, column number is in range, value is 1 and NOT VISITED
		return (row >= 0) && (row < ROW) 
				&& (col >= 0) && (col < COL) 
				&& (M[row][col] == 1 && !visited[row][col]);
	}

	/*
	 * A utility function to do DFS for a 2D boolean matrix Change the neighbor
	 * cells if diagonal should be excluded
	 */
	void DFS(int M[][], int row, int col, boolean visited[][]) {
		// 8 neighbors of the given cell
		int rowNbr[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
		int colNbr[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };

		// Mark this cell as visited
		visited[row][col] = true;

		// Recur for all CONNECTED(1) neighbors
		for (int k = 0; k < 8; ++k)
			if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited))
				DFS(M, row + rowNbr[k], col + colNbr[k], visited);
	}

	int countIslands(int M[][]) {
		// Initially all cells are unvisited
		boolean visited[][] = new boolean[ROW][COL];

		// Initialize count as 0 and traverse through the all cells of given
		// matrix
		int count = 0;
		for (int i = 0; i < ROW; ++i)
			for (int j = 0; j < COL; ++j)
				/*
				 * If a cell with value 1 is not visited yet, then new island
				 * found, Visit all neighbor cells in this island and increment
				 * island count
				 */
				if (M[i][j] == 1 && !visited[i][j]) {
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

	// Driver method
	public static void main(String[] args) throws java.lang.Exception {
		int M[][] = new int[][] { { 1, 1, 0, 0, 0 }, 
								  { 0, 1, 0, 0, 1 }, 
								  { 1, 0, 0, 1, 1 }, 
								  { 0, 0, 0, 0, 0 },
								  { 1, 0, 1, 0, 1 } };
		Islands I = new Islands();
		System.out.println("Number of islands is: " + I.countIslands(M));
	}

}