package Algo.DFS;
// https://leetcode.com/problems/fair-distribution-of-cookies/solutions/3702398/back-track-c-java-beginner-friendly/
public class DistributeCookies {

    static int ans = Integer.MAX_VALUE;
    static int[] cookies, temp_sum;
    static int k;

    static void helper(int start) {
        if (start == cookies.length) {
            int max = 0;
            for (int c : temp_sum)
                max = Math.max(max, c);
            ans = Math.min(ans, max);
            return;
        }
        for (int i = 0; i < k; i++) {
            temp_sum[i] += cookies[start];
            helper(start + 1);
            temp_sum[i] -= cookies[start];
        }
    }

    public static void distributeCookies() {
        temp_sum = new int[k];
        helper( 0);
        System.out.println("Minimum of maximum total cookies obtained by a single child :: "+ans);
    }

    public static void main(String[] args) {
        cookies = new int[]{8, 10, 15};
        k = 2;
        distributeCookies();

    }
}
