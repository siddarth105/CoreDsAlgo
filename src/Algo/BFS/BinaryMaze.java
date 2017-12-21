package Algo.BFS;

import java.util.ArrayDeque;

public class BinaryMaze {

	class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	};

	class QueueNode {
		Point pt;
		int dist;

		public QueueNode(Point pt, int dist) {
			this.pt = pt;
			this.dist = dist;
		}
	};

	static int rowNum[] = { -1, 0, 0, 1 };
	static int colNum[] = { 0, -1, 1, 0 };
	static int ROW, COL, shtDist = -1;

	public static boolean isValid(int[][] mat, boolean[][] visited, int row, int col) {
		return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) 
				&& mat[row][col] == 1 && !visited[row][col];
	}

	public static int bfs(int[][] mat, Point src, Point dest, BinaryMaze bm) {

		if (mat[src.x][src.y] != 1 || mat[dest.x][dest.y] != 1)
			return shtDist;

		boolean[][] visited = new boolean[ROW][COL];
		visited[src.x][src.y] = true;
		ArrayDeque<QueueNode> q = new ArrayDeque<QueueNode>();
		QueueNode sNode = bm.new QueueNode(src, 0);
		q.push(sNode);

		while (!q.isEmpty()) {
			QueueNode curr = q.peekLast();
			Point pt = curr.pt;

			if (pt.x == dest.x && pt.y == dest.y)
				return curr.dist;
			
			q.remove(curr);

			for (int i = 0; i < 4; i++) {
				int row = pt.x + rowNum[i];
				int col = pt.y + colNum[i];

				if (isValid(mat, visited, row, col)) {
					visited[row][col] = true;
					QueueNode Adjcell = bm.new QueueNode(bm.new Point(row, col), curr.dist + 1);
					q.push(Adjcell);
				}
			}
		}

		return shtDist;
	}

	public static void main(String[] args) {
		int mat[][] = new int[][] { { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 }, 
									{ 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
									{ 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 }, 
									{ 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 }, 
									{ 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
									{ 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 }, 
									{ 1, 0, 1, 0, 0, 0, 0, 0, 0, 1 }, 
									{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
									{ 1, 1, 1, 0, 0, 0, 1, 0, 0, 1 } };
				
		ROW = mat.length;
		COL = mat[0].length;
		BinaryMaze bm = new BinaryMaze();
		Point source = bm.new Point(8, 0);
		Point dest = bm.new Point(7, 2);

		int dist = bfs(mat, source, dest, bm);

		if (dist != shtDist)
			System.out.println("Shortest Path is " + dist);
		else
			System.out.println("Shortest Path doesn't exist");
	}
}
