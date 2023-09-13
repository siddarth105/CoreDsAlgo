package Sample;

import java.util.ArrayList;
import java.util.List;

/*

{90, 170, 250, 300, 35, 4, 795}

0      1   2  3   4
{300, 35, 20, 15, 3}

 while(a[i] < a[i+1])
     i++

when (a[i] > a [i+1])
 buy -> i+1
 sell -> i

 */
public class Solution123 {

    public static class DayPair {
        int buy;
        int sell;
    }

    static List<DayPair> profitList = new ArrayList<DayPair>();

    public static void printInput() {
        for (DayPair dp : profitList) {
            System.out.println(dp.buy + ", " + dp.sell);
        }
    }
    public static void maxProfit(int[] stock) {
        int i=0;
        while (i < stock.length) {
            DayPair dp = new DayPair();

            while (i+1 <= stock.length-1 && stock[i] > stock[i+1]) {
                i++;
            }
            if (i >= stock.length-1) {
                break;
            }
            dp.buy = i;

            while (i+1 <= stock.length-1 && stock[i] < stock[i+1]) {
                i++;
            }
            dp.sell = i;
            profitList.add(dp);
            i++;
        }
}

    public static void main (String[] args) {
        //int[] stock = new int[]{90, 170, 250, 300, 35, 536, 795};
        int[] stock = new int[] {300, 250, 170, 90, 35, 32, 23};
        maxProfit(stock);
        printInput();
    }

}
