package Algo.DynamicPgm;

//https://www.geeksforgeeks.org/coin-change-dp-7/
public class CoinSum {
    static int[] coins;

    static int count (int i, int s) {
        if (i < 0 || s < 0) {
            return 0;
        }

        if (s == 0) {
            return 1;
        }

        if (i == 0 && s - coins[i] == 0) {
            return 1;
        }

        return count(i, s - coins[i]) + count(i - 1, s);
    }

    public static void main (String[] args) {
        coins = new int[]{ 1, 2, 3 };
        int n = coins.length;
        System.out.println("Count :: " + count(n-1, 4));
    }
}
