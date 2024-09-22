package Algo.BFS;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/number-of-provinces/description/
public class ProvincePbm {




        boolean[] vis;

        public int findCircleNum(int[][] isConnected) {
            int n = isConnected.length;
            vis = new boolean[n];
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (!vis[i]) {
                    Queue<Integer> q = new LinkedList<>();
                    q.add(i);
                    vis[i] = true;
                    count++;


                    while (!q.isEmpty()) {
                        int elt = q.poll();
                        for (int j = 0; j < isConnected.length; j++) {
                            if (isConnected[elt][j] == 1 && !vis[j]) {
                                vis[j] = true;
                                q.add(j);
                            }
                        }
                    }
                }
            }
            return count;
        }

        private void bfs(int[][] isConnected, int v, boolean[] vis) {

        }





/*

    1       2
    |       |
    3       4 -- 5

 */
}
