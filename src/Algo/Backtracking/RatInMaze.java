package Algo.Backtracking;

public class RatInMaze {
	
	public static int n = 4;
	
	public static boolean isValid(int[][] mazeArray, int x, int y) {
		
		return (x < n && y < n && mazeArray[x][y] == 1);
		
	}
	
	public static boolean solveMaze(int[][] mazeArray, int x, int y, int[][] resultArray) {
		
		// BASE_CASE
		if (x == (n-1) && y == (n-1)) {
			resultArray[x][y] = 1;
			return true;
		}
		
		if (isValid(mazeArray, x, y)) {
			
			resultArray[x][y] = 1;
			
			// RECURSION :: Move in X
			if (solveMaze(mazeArray, x + 1, y, resultArray)) {
				return true;
			}
			
			// RECURSION :: Move in Y
			if (solveMaze(mazeArray, x, y + 1, resultArray)) {
				return true;
			}
			
			//BACK_TRACK
			resultArray[x][y] = 0;
			return false;
		}
		
		return false;
	}
	
	public static int[][] getMaze(int[][] mazeArray) {
		int[][] resultArray = {{0,0,0,0}, {0,0,0,0}, {0,0,0,0}, {0,0,0,0}}; 
		
		boolean val = solveMaze(mazeArray, 0, 0 , resultArray);
		if (!val) {
			resultArray = null;
		}
		return resultArray;
	}
	
	public static void main (String[] args) {
		
		int[][]  mazeArray = {{1,0,0,1},
							  {1,1,1,0}, 
							  {1,0,1,0}, 
							  {0,1,1,1}};
		System.out.println("Given Maze : - ");
		for (int i=0; i < mazeArray.length; i++) {
			for (int j =0; j < mazeArray[i].length; j++) {
				System.out.print(mazeArray[i][j] + " ");
			}
			System.out.println();
		}
		
		int[][] resultArray = getMaze(mazeArray);
		
		if (null != resultArray) {
			System.out.println("Rat's Path : - ");
			for (int i=0; i < resultArray.length; i++) {
				for (int j =0; j < resultArray[i].length; j++) {
					System.out.print(resultArray[i][j] + " ");
				}
				System.out.println();
			}
		} else {
			System.out.println("Locked Maze :- No path for the rat");
		}
	}

}
