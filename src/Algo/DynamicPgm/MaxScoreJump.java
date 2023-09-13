package Algo.DynamicPgm;

// https://leetcode.com/problems/jump-game-vi/
public class MaxScoreJump {

    public static int maxResult(int[] nums, int k) {
        return getMaxScore(nums, k, nums.length - 1);
    }

    private static int getMaxScore(int[] nums, int k, int position) {
        // If we reach the first position, return the score at this position
        if (position == 0) {
            return nums[0];
        }

        int maxScore = Integer.MIN_VALUE;

        // Try all valid jumps from the current position
        for (int i = 1; i <= k && position - i >= 0; i++) {
            // Recursively calculate the score for the previous position
            int prevPosition = position - i;
            int scoreFromPrevPosition = getMaxScore(nums, k, prevPosition);

            // Update the maximum score
            maxScore = Math.max(maxScore, nums[position] + scoreFromPrevPosition);
        }

        return maxScore;
    }

    public static void main(String[] args) {
        int[] nums = {1, -1, -2, 4, -7, 3};
        int k = 2;
        int maxScore = maxResult(nums, k);
        System.out.println("Maximum Score: " + maxScore); // Output: 7
    }
}
