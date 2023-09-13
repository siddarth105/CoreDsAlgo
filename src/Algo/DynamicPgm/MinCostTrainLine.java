package Algo.DynamicPgm;

// https://www.youtube.com/watch?v=QCEt_jhEY98&ab_channel=Code-Yao
// https://www.coddicted.com/solved-leetcode-2361-minimum-costs-using-the-train-line/
// TODO :: Issue in isRegular for recursion 
public class MinCostTrainLine {

    static int[] express, regular;
    static int expressCost;


    static int trainLine(int i, boolean isRegular) {
        if (i == 0) {
            return regular[i] < (express[i] + expressCost) ? regular[i] : (express[i] + expressCost);
        }
        int reg = regular[i] + trainLine(i-1, true);
        int exp = 0;
        if (isRegular) {
            exp = express[i] + expressCost + trainLine(i-1, false);  // Change to express
        } else {
            exp = express[i] + trainLine(i-1, false);  // Continue on express
        }
        return Math.min(reg, exp);
    }

    public static void main(String[] args) {
        regular = new int[]{1, 6, 9};
        express = new int[]{5, 2, 3};
        expressCost = 3;
        int ans = trainLine(express.length-1, true);
        System.out.println("Answer :: "+ ans);
    }



}
