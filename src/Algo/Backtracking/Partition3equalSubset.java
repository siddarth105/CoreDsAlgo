package Algo.Backtracking;

import java.util.Arrays;

// QN :: https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/
// ANS :: https://www.youtube.com/watch?v=mBk4I0X46oI
public class Partition3equalSubset {

    static int target;
    static int[] subsets;
    static int[] nums;

    public static boolean canPartitionIntoThreeSubsets(int[] input, int k) {

        nums = input;
        int totalSum = Arrays.stream(nums).sum();

        // If the total sum isn't divisible by 3, return false
        if (totalSum % k != 0) {
            return false;
        }

        target = totalSum / k;
        int n = nums.length;

        // Sort in descending order to optimize backtracking by trying larger numbers first
        Arrays.sort(nums);

        // If the largest number is greater than the target sum, no valid partition exists
        if (nums[n - 1] > target) {
            return false;
        }

        // Array to track the sum of each of the three subsets
        subsets = new int[k];

        // Backtracking function to check if the partition is possible
        //return backtrack(n - 1);
        return backtrackOpt(0, k, 0, new boolean[nums.length]);
    }

    private static boolean backtrackOpt(int index, int k, int subsetSum, boolean[] usedIndices) {
        if (k == 0) {
            return true;
        }
        if (subsetSum == target) {
            backtrackOpt(0, k-1, 0, usedIndices);
            return true;
        }

        for (int i = index; i < nums.length; i++) {
            if(!usedIndices[i] && nums[i] + subsetSum <= target) {
                usedIndices[i] = true;
                if (backtrackOpt(i+1, k, nums[i] + subsetSum, usedIndices)) {
                    return true;
                }
                usedIndices[i] = false;
            }
        }
        return false;
    }

    // Backtracking helper function
    private static boolean backtrack(int index) {
        // Base case: if all elements are placed, check if all subsets have the target sum
        if (index < 0) {
            return subsets[0] == target && subsets[1] == target && subsets[2] == target;
        }

        // Try placing the current element in each subset
        for (int i = 0; i < subsets.length; i++) {
            // If adding nums[index] to subsets[i] doesn't exceed the target, proceed
            if (subsets[i] + nums[index] <= target) {
                subsets[i] += nums[index];

                // Recursively attempt to partition the rest of the numbers
                if (backtrack(index - 1)) {
                    return true;
                }

                // Backtrack: remove the number from the current subset
                subsets[i] -= nums[index];
            }

            // Optimization: If any subset is still empty (i.e., sum is 0), break early
            if (subsets[i] == 0) {
                break;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int k = 3, j =4;
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {1, 2, 3, 4, 6, 8, 12};
        int[] nums3 = {4, 3, 2, 3, 5, 2, 1};
        //System.out.println(canPartitionIntoThreeSubsets(nums1, k));
        //System.out.println(canPartitionIntoThreeSubsets(nums2, k));
        System.out.println(canPartitionIntoThreeSubsets(nums3, j));
    }

}
