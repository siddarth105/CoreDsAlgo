package Algo.Backtracking;

public class AdditiveNumber {

    static boolean findN3(int n1, int n2, String s, boolean result) {
        // BASE
        if (s.length() == 0 && result) {
            return true;
        }

        int sum = n1 + n2;
        int sumLength = String.valueOf(sum).length();

        // CORNER CASE :: When the length of the sum is greater than the remaining string
        if (sumLength > s.length()) {
            return false;
        }

        int sumInString = Integer.parseInt(s.substring(0, sumLength));

        if (sum == sumInString) {
            return findN3(n2, sum, s.substring(sumLength), true);
        }

        return false;
    }


    static boolean isAdditive(String number) {
        boolean isAdditive =  false;
        int n = number.length();
        for (int i=1; i < n-1; i++) {
            int n1 = Integer.parseInt(number.substring(0, i));
            for (int j=i+1; j < n; j++ ) {
                int n2 = Integer.parseInt(number.substring(i, j));
                if (findN3(n1, n2, number.substring(j), false)) {
                    return true;
                }
            }
        }
        return isAdditive;
    }

    public static void main (String[] args) {
        String number = "23143751";
        number = "199100199";
        boolean isAdditive = isAdditive(number);
        System.out.println("Is Additive :: " + isAdditive);
    }
}
