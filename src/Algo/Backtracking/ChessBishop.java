package Algo.Backtracking;

/*There is a chess board of dimension n X n. 
 * You are given with 2 squares on that board S(x1,y1) ;M(x2,y2). 
 * S is a fixed point. M can move diagonally.
 *  it can move any number of steps or jumps in 1 move . 
 *  Find the minimum number of moves M needs to reach S*/

public class ChessBishop {
	
	/* There are 4 cases for this problem:
     * 1. S = M, then 0 move is needed;
     * 2. M is on diagonal lines of S, then 1 move is needed;
     * 3. M's diagonal lines have intersections with S's diagonal lines, then 2 moves are needed;
     * 4. M can never reach S.
     *
     * Through analysis, we can get that this problem is actually to find the interactions.
     * For any point on the board, we can get that the 2 diagonal lines are:
     *   a. y = x - (x0 - y0)
     *   b. y = -x + (x0 + y0), in which x0,y0 is the location of this point
     *
     * So now the problem can be simplified to that either of:
     *   a. the intersection of y = x - (x1 - y1) and y = -x + (x2 + y2) exists on the board
     *      its location is (x2 + y2 + x1 - y1) / 2, (x2 + y2 - x1 + y1) / 2
     *   b. the intersection of y = -x + (x1 + y1) and y = x - (x2 - y2) exists on the board
     *      its location is (x1 + y1 + x2 - y2) / 2, (x1 + y1 - x2 + y2) / 2
     * */
    static int findMoves(int length, Point s, Point m) {
        if ((s.x == m.x) && (s.y == m.y)) {
            return 0;
        } else if ((m.y == m.x - (s.x - s.y)) || (m.y == -1 * m.x + (s.x + s.y))) {
            return 1;
        } else {
            Point inter1 = new Point((s.x + s.y + m.x - m.y) / 2.0, (s.x + s.y - m.x + m.y) / 2.0);
            Point inter2 = new Point((m.x + m.y + s.x - s.y) / 2.0, (m.x + m.y - s.x + s.y) / 2.0);

            if (inter1.isOnBoard(length) || inter2.isOnBoard(length)) {
                return 2;
            } else {
                return -1;
            }
        }
    }

    static class Point {
        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        /* if coordinators are not integer or exceed limits, intersections are not on the board */
        boolean isOnBoard(int length) {
            if (x >= length || x < 0 || y >= length || y < 0) {
                return false;
            } else if (Math.floor(x) != x || Math.floor(y) != y) {
                return false;
            } else {
                return true;
            }
        }
    }

}
