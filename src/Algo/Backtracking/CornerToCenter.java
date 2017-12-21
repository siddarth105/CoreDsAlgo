package Algo.Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*NOT WORKING*/
public class CornerToCenter {
	
	
	static class Point{
		
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int maze[][];
	static int N;
	static int k;
	// For corners
	static int _row[] = {0, 0, k, k};
	static int _col[] = {0, k, 0, k};
	// For searching 4 direction
	static int row[] = { 1, 0, 0, -1};
	static int col[] = { 0, 0, -1, 1};
	
	static boolean isValid(Set<Point> visited, Point pt) {
		
		return (pt.x >= 0) && (pt.x < N) && (pt.y >= 0) && (pt.y < N) && (!visited.contains(pt));
	}
	
	static void findPathInMazeUtil(List<Point> path, Set<Point> visited, Point curr) {
		
		//BASE_CASE :: reched middle
		if (curr.x == N / 2 && curr.y == N / 2) {
			printPath(path);
			return;
		}

		// consider each direction
		for (int i = 0; i < 4; ++i) {
			
			int n = maze[curr.x][curr.y];

			// For moving in 4 directions
			int x = curr.x + row[i] * n;
			int y = curr.y + col[i] * n;

			Point next = new Point(x, y);
			
			if (isValid(visited, next)) {
				// mark cell as visited
				visited.add(next);
				path.add(next);

				findPathInMazeUtil(path, visited, next);

				// BACKTRACK
				path.remove(next);
				visited.remove(next);
			}
		}
	}
	
	
	public static void findPathInMaze() {
		
		  List<Point> path = new ArrayList<Point>();
		  Set<Point> visited = new HashSet<Point>();
		
		  for (int i = 0; i < 4; ++i)
		    {
		        int x = _row[i];
		        int y = _col[i];
		 
		        // Constructs a pair object
		        Point pt =  new Point(x, y);
		 
		        // mark cell as visited
		        visited.add(pt);
		 
		        // add cell to current path
		        path.add(pt);
		 
		        findPathInMazeUtil(path, visited, pt);
		 
		        // backtrack
		        path.remove(pt);
		        visited.remove(pt);
		    }
		  
	}
	
	public static void main(String[] args) {
		
		 maze = new int[][]
			    {
			        { 3, 5, 4, 4, 7, 3, 4, 6, 3 },
			        { 6, 7, 5, 6, 6, 2, 6, 6, 2 },
			        { 3, 3, 4, 3, 2, 5, 4, 7, 2 },
			        { 6, 5, 5, 1, 2, 3, 6, 5, 6 },
			        { 3, 3, 4, 3, 0, 1, 4, 3, 4 },
			        { 3, 5, 4, 3, 2, 2, 3, 3, 5 },
			        { 3, 5, 4, 3, 2, 6, 4, 4, 3 },
			        { 3, 5, 1, 3, 7, 5, 3, 6, 4 },
			        { 6, 2, 4, 3, 4, 5, 4, 5, 1 }
			    };
		 N = maze.length;
		 k = N - 1 ;
		 findPathInMaze();
		
	}
	
	 static void printPath(List<Point> path) {
		 for (Point pt : path) {
			 System.out.println("(" + pt.x + ", " + pt.y + ") -> ");
		 }
	 }

}
