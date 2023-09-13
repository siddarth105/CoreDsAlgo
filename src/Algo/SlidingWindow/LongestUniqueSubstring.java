package Algo.SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LongestUniqueSubstring {

    static char[] input;

    private static int getUniqueSubstringLength() {
        int right=0, left=0;
        int maxLength = 0;
        Set<Character> existingValue =  new HashSet<>();
        for (;right<input.length; right++) {
            while (existingValue.contains(input[right])) {
                //invalid scenario :: Move left to shrink the window
                existingValue.remove(input[left]);
                left ++;
            }
            existingValue.add(input[right]);
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength+1;
    }

    public static void main(String[] args) {
        input = new char[]{'p', 'w', 'w', 'k', 'e', 'w'};
        getUniqueSubstringLength();
    }

    /* Pseudocode
    for(right = 0; right < n; right++):
        update window with element at right pointer
        while (condition not valid):
            remove element at left pointer from window, move left pointer to the right
    update global max*/
}
