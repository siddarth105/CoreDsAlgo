package Algo.Backtracking;

// QN :: https://leetcode.com/problems/restore-ip-addresses/description/?envType=problem-list-v2&envId=backtracking&difficulty=MEDIUM
public class IpPartitioning {

    static String input;
    static int n;

    // Time Complexity :: O(3^N)
    // k -> iterates through the given string
    // i -> iterates through the subsets(4)
    public static boolean partitionIp(int k, int i, int[] c) {
        // i => number of subsets(4)
        if (i > 3) {
            return false;
        }

        // Last 2 digits || Last 3 digits < 256
        if (k >= n-3
                && (k > n-3 || Integer.parseInt(input.substring(k, n-1)) < 256)) {
            c[i] = Integer.parseInt(input.substring(k, n-1));
            printOutput(c);
        }

        for (int j = 1; j < 4 && k+j < n-1; j++) { // k+j < n-1 => To handle OutOfBound Exception
            int firtNum = Integer.parseInt(input.substring(k, k+j));
            if (firtNum < 256) {
                c[i] = firtNum;
                if (partitionIp (k+j, i+1, c)) {
                    return true;
                }
                c[i] = 0;
            }
        }
        return false;
    }

    public static void main (String[] args) {
        input = "25525511135";
        n = input.length();
        int[] c = new int[4];
        if (n > 12) { // If the input has more than 12 digits
            System.out.println("Cant partition");
            return;
        }
        partitionIp(0,0, c);
    }

    private static void printOutput(int[] c) {
        System.out.print("value :: ");
        for (int z = 0; z< c.length; z++) {
            System.out.print(c[z] + ",");
        }
        System.out.println();
    }
}
