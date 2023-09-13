package Algo.SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubsWithKdistinct {

    static char[] input;

    private static int longestSubsWithKdistinct(int k) {
        int right=0, left=0;
        int maxLength = 0;
        Set<Character> existingValue =  new HashSet<>();
        for (;right<input.length; right++) {

        }
        return maxLength;
    }

    public static void main(String[] args) {
        //input = new char[]{'p', 'w', 'w', 'k', 'e', 'w'};
        input = new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'c'};
        longestSubsWithKdistinct(2);
    }
}
