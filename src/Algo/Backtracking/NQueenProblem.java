package Algo.Backtracking;

/* Java program to solve N Queen Problem using
backtracking */
public class NQueenProblem {
	public final int N = 4;

	/* A utility function to print solution */
	public void printSolution(int board[][]) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(" " + board[i][j] + " ");
			System.out.println();
		}
	}

	public boolean isSafe(int board[][], int row, int col) {
		int i, j;

		/* Check this row on left side */
		for (i = 0; i < col; i++)
			if (board[row][i] == 1)
				return false;

		/* Check upper diagonal on left side */
		for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
			if (board[i][j] == 1)
				return false;

		/* Check lower diagonal on left side */
		for (i = row, j = col; j >= 0 && i < N; i++, j--)
			if (board[i][j] == 1)
				return false;

		return true;
	}

	public boolean solveNQUtil(int board[][], int col) {
		
		// BASE : If all queens are placed then return true
		if (col >= N)
			return true;

		 // Consider this column and try placing this queen in all rows one by one
		for (int i = 0; i < N; i++) {
			// Check if queen can be placed on board[i][col]
			if (isSafe(board, i, col)) {
				/* Place this queen in board[i][col] */
				board[i][col] = 1;

				/* Move to the next column as u cant place the queen in the same column */
				if (solveNQUtil(board, col + 1))
					return true;

				/*
				 * If placing queen in board[i][col] doesn't lead to a solution
				 * then remove queen from board[i][col]
				 */
				board[i][col] = 0; // BACKTRACK
			}
		}

		// If queen can not be place in any row in this column, then return false
		return false;
	}

	public boolean solveNQ() {
		int board[][] = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

		if (solveNQUtil(board, 0) == false) {
			System.out.print("Solution does not exist");
			return false;
		}

		printSolution(board);
		return true;
	}

	public static void main(String args[]) {
		NQueenProblem Queen = new NQueenProblem();
		Queen.solveNQ();
	}
	
	/*ALGORITHM :-
	
	1) Start in the leftmost column
	2) If all queens are placed
	    return true
	3) Try all rows in the current column.  Do following for every tried row.
	    a) If the queen can be placed safely in this row then mark this [row, 
	        column] as part of the solution and recursively check if placing  
	        queen here leads to a solution.
	    b) If placing queen in [row, column] leads to a solution then return 
	        true.
	    c) If placing queen doesn't lead to a solution then umark this [row, 
	        column] (Backtrack) and go to step (a) to try other rows.
	4) If all rows have been tried and nothing worked, return false to trigger 
	    backtracking.
	    
	    DIRECTION TO BE CHECKED :-
	    
	    	 \
	    	  \
	    <----  .
	          /
	    	 /
	*/
}
