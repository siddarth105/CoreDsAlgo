package Algo.Backtracking;

public class Sudoku {
	
	/** Method for backtracking
	 * row & col should be local variables to identify the previous values, in case of recursion 
	 * @param input -> 2D array which is mutable in java, retains the change
	 * @param row	-> Points to the row where it is '0'
	 * @param col	-> Points to the column where it is '0'
	 * @param flag  -> to perform backtrack, based on the '0' in the 2D Array
	 * 			    -> Default Value :: true
	 * 				-> TRUE, when moving forward and false in backtracking
	 * @return
	 */
	private static boolean solveSudoku(int[][] input, int row, int col, boolean flag) {
		
		/*
		 * Loop that points to the '0' in "input"
		 * by making row and col point towards it
		 * makes the flag = false, stating that the array is not filled
		 */
		
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length; j++) {
				if (input[i][j] == 0) {
					row = i;
					col = j;
					flag = false;
					break;
				}
			}
			if (!flag) {
				break;
			}
		}
		
		/* End-Point, if the array is filled*/
		if (flag) {
			return true;
		}
		
		/*SUDOKU - fill the blanks by iterating the number 1 - 9 */
		
		for (int i = 1; i <= 9; i++) {
			if (sudokuLogic(input,i, row, col)) {
				// Fill the 2D array by 'i', after satisfying SUDOKU logic
				input[row][col] = i;
				
				// Recursion for the future value
				if(solveSudoku(input, 0, 0, true))
					return true;
				
				// Back tracking, if the future value doesn't satisfy SUDOKU logic
				input[row][col] = 0;
			}
		}
		//Back tracking
		return false;
	}
	
	
	/**
	 * SUDOKU logic
	 * Method to identify if 'i' is repeated in the row, column and current Square
	 * @return false if 'i' is repeated
	 */
	private static boolean sudokuLogic(int[][] input, int i, int row, int col){
		
		return checkRowSafety(input,i,row,col) && checkColSafety(input,i,row,col) && checkSqSafety(input,i,row,col);
	}
	
	private static boolean checkRowSafety (int[][] input, int value, int row, int col) {
		
		for (int j = 0; j < input[row].length; j++) {
			if (input[row][j] == value) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean checkColSafety (int[][] input, int value, int row, int col) {
		
		for (int i = 0; i < input.length; i++) {
			if (input[i][col] == value) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean checkSqSafety (int[][] input, int value, int row, int col) {
		
		int r1 = row - row%3;
		int c1 = col - col%3;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (input[i + r1][j + c1] == value) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	public static void main (String []args) {
		
		int[][] input = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};
		
		System.out.println("Input ... ");
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length; j++) {
				System.out.print(input[i][j] + " ");
			}
			System.out.println();
		}
		
		if(!solveSudoku(input, 0, 0, true)) {
			System.out.println("\nSudoku cant be solved");
		}
		
		System.out.println("\nOutput :-");

		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length; j++) {
				System.out.print(input[i][j] + " ");
			}
			System.out.println();
		}
	}

}
