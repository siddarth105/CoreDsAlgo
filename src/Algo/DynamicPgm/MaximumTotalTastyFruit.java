package Algo.DynamicPgm;

// 0-1 Knapsack
// https://leetcode.ca/2022-11-19-2431-Maximize-Total-Tastiness-of-Purchased-Fruits/
public class MaximumTotalTastyFruit {

    static int[] price, taste;

    static int maxTaste(int i, int maxAmt, int maxCoupon) {
        if (maxAmt == 0 || price.length == 0) {
            return 0;
        }

        if (i < 0) {
            return 0;
        }

        if (price[i] <= maxAmt || price[i]/2 <= maxAmt) {
            int t1 = 0 , t2 = 0;
            if (price[i] <= maxAmt) {
                t1 = taste[i] + maxTaste(i-1, maxAmt - price[i], maxCoupon);
            }
            if (price[i]/2 <= maxAmt && maxCoupon != 0) {
                t2 = taste[i] + maxTaste(i-1, maxAmt - price[i]/2, maxCoupon-1);
            }
            int t3 = maxTaste(i-1, maxAmt, maxCoupon);
            return Math.max(Math.max(t1, t2),t3);
        } else {
            return maxTaste(i-1, maxAmt, maxCoupon);
        }
    }

    public static void main (String[] args) {
        price = new int[]{10,20,20};
        taste = new int[]{5,8,8};
        int maxAmt = 20;
        int maxCoupon = 1;
        int maxTaste = maxTaste(taste.length-1, maxAmt, maxCoupon);
        System.out.println("Maximum taste :: "+ maxTaste);
    }

}
