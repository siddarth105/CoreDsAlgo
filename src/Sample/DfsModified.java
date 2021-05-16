package Sample;
import java.util.*;

public class DfsModified {
	
	static int ROW, COL;
	static Set<String> s = new HashSet<>();
	static int ct;
	
	static boolean isSafe(char M[][], int row, int col, boolean visited[][]) {
		return (row >= 0) && (row < ROW) 
				&& (col >= 0) && (col < COL) 
				&& (M[row][col] == '1' && !visited[row][col]);
	}
	
	static void DFS(char M[][], int row, int col, boolean visited[][]) {
		int rowNbr[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
		int colNbr[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };
		visited[row][col] = true;
		if (M[col][row] == '1' && !s.contains(col+"-"+row)) {
			s.add(row+"-"+col);
		}
		for (int k = 0; k < 8; ++k)
			if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited))
				DFS(M, row + rowNbr[k], col + colNbr[k], visited);
	}
	
	
	static int countIslands(char M[][]) {
		ROW = M.length;
		COL = M[0].length;		
		boolean visited[][] = new boolean[ROW][COL];
		int count = 0;
		for (int i = 0; i < ROW; ++i)
			for (int j = 0; j < COL; ++j)
				if (M[i][j] == '1' && !visited[i][j]) {
					DFS(M, i, j, visited);
					++count;
					System.out.println("Island - " + count);
				}

		return count;
	}
	
	 public static int countGroups(List<String> related) {
	        char[][] M = new char[related.get(0).length()][related.size()];
	        for (int i=0; i < related.size(); i++) {
	            M[i] = related.get(i).toCharArray();
	            M[i][i] = '0';
	        }
	        ct = countIslands(M);
	        return calculateFinalCount();

	}
	 
	static int calculateFinalCount() {
		Set<Integer> finalSet = new HashSet<Integer>();
		for (String val : s) {
			String[] v = val.split("-");
			finalSet.add(Integer.valueOf(v[0]));
			finalSet.add(Integer.valueOf(v[1]));
		}
		for (int i=0; i<ROW; i++) {
			if(!finalSet.contains(i)) {
				ct++;
			} 
		}
		return ct;
	} 

	public static void main(String[] args) {
		List<String> lst = new ArrayList<>();
		lst.add("1100");
		lst.add("1110");
		lst.add("0110");
		lst.add("0001");
		ct = countGroups(lst);
		System.out.println("Groups :: " + ct);
		System.out.println("After");

	}

}
