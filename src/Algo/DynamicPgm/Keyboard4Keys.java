package Algo.DynamicPgm;
// QN :: https://leetcode.ca/2017-09-11-651-4-Keys-Keyboard/
public class Keyboard4Keys {

    public static int maxA(int n) {
        // Base case: If n is less than or equal to 6, the best strategy is to press 'A' for each keystroke
        if (n <= 6) {
            return n;
        }

        int maxAs = 0;

        // Try different breakpoints for the Ctrl-A, Ctrl-C, Ctrl-V strategy
        // j is the breakpoint where we start to do Ctrl-A, Ctrl-C, Ctrl-V
        for (int j = n - 3; j >= 1; j--) {
            // maxA(j) is the result before starting Ctrl-A, Ctrl-C, Ctrl-V
            // (n - j - 1) is the number of Ctrl-V presses (i.e., the number of times we can paste)
            int current = maxA(j) * (n - j - 1);
            maxAs = Math.max(maxAs, current);
        }

        return maxAs;
    }

    public static void main(String[] args) {

        int n = 7; // Example number of keystrokes
        System.out.println("Maximum number of A's with " + n + " keystrokes: " + maxA(n));
    }
}
