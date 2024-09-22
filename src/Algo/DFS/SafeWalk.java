package Algo.DFS;
// https://leetcode.com/problems/find-a-safe-walk-through-a-grid/description/?envType=problem-list-v2&envId=heap-priority-queue&difficulty=MEDIUM
public class SafeWalk {

    public static int[][] input;
    public static boolean[][] visited;
    public static int m,n;

    public static boolean walkable(int r, int c, int health) {
        visited[r][c] = true;
        if (health <= 0) {
            return false;
        }

        if (r == m-1 && c == n-1) {
            return true;
        }
        boolean down = false, right = false, up = false, left = false;

        // up
        if (r-1 >= 0 && !visited[r-1][c] && health - input[r-1][c] > 0) {
            up = walkable (r-1, c, health - input[r-1][c]);
        }

        // down
        if (r+1 < m && !visited[r+1][c] && health - input[r+1][c] > 0) {
            down = walkable (r+1, c, health - input[r+1][c]);
        }

        // right
        if (c+1 < n && !visited[r][c+1] && health - input[r][c+1] > 0) {
            right = walkable (r, c+1, health - input[r][c+1]);
        }

        // left
        if (c-1 >= 0 && !visited[r][c-1] && health - input[r][c-1] > 0) {
            left = walkable (r, c-1, health - input[r][c-1]);
        }

        return up || down || left || right;
    }

    public static void main(String[] args){
        input = new int[][]{{0, 1, 0, 0, 0}, {0, 1, 0, 1, 0}, {0, 0, 0, 1, 0}};
        m = input.length; n = input[0].length;
        visited = new boolean[m][n];
        boolean result = walkable(0, 0, 1);
        System.out.println("Can walk : " + result);

    }
}
