package Algo.DynamicPgm;
// https://leetcode.com/problems/shopping-offers/description/?envType=problem-list-v2&envId=dynamic-programming&difficulty=MEDIUM
public class ShoppingOffers {

    private static int[] price, needs;
    private static int[][] special;

    private static int total_amount;

    private static int getMinimumAmount (int[] curr, int amount, int j) {
        if (curr == needs || j >= special.length) {
            return amount;
        }

        //int amoutWithoutSpecial = getAmount(curr); // A + 2B + C = 12
        //int[] curWithoutSpecial = getCurWithoutSpecial(curr);  // A + 2B + C
        if (checkNeedsGreaterSpecial(j)) {
            int specialAmount = special[j][special[j].length-1]; // A+B=4
            int[] curWithSpecial = removeSpecialFromNeeds(j);  // B + C -> remaining after special
            int amountWithSpecial = getAmountForCurr(curWithSpecial); // B+C=7  -> sum of the remaining
            amount = Math.min(specialAmount + amount + getMinimumAmount(curWithSpecial, amountWithSpecial, j+1),
                    getMinimumAmount(curr, amount , j+1));

        } else {
            amount = getMinimumAmount(curr, amount, j+1);
        }
        return amount;
    }


    private static int getAmountForCurr(int[] cur) {
        int amount = 0;
        for (int i=0; i < cur.length; i++) {
            amount += cur[i]*price[i];
        }
        return amount;
    }

    private static int[] removeSpecialFromNeeds(int j) {
        int[] cur = new int[needs.length];
        for (int i=0; i < special[j].length-1; i++) {
            cur[i] = needs[i] - special[j][i];
        }
        return cur;
    }
    private static boolean checkNeedsGreaterSpecial(int j) {

        for (int i=0; i < special[j].length-1; i++) {
            if (needs[i] < special[j][i]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        price = new int[]{2,3,4};  needs = new int[]{1,2,1};
        special = new int[][]{{1,1,0,4},{2,2,1,9}};
        int[] cur = new int[needs.length];
        total_amount = getAmountForCurr(needs);
        int amount = getMinimumAmount(cur, 0, 0);
        System.out.println("Minimum total amount needed : "+amount);
    }

    /*private static int getAmount(int[] cur) {
        int amount = 0;
        for (int i = 0; i < needs.length; i++) {
            amount += (needs[i]-cur[i])*price[i];
        }
        return amount;
    }

    private static int[] getCurWithoutSpecial(int[] curr) {
        int[] curWithoutSpecial = new int[curr.length];
        for (int i=0; i < needs.length; i++) {
            curWithoutSpecial[i] = curr[i] + needs[i];
        }
        return curWithoutSpecial;
    }*/
}
