import java.util.Arrays;

class Solution {

    public int solve(int[] nums, int i, int end, int[] dp) {

        if (i > end) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int steal = nums[i] + solve(nums, i + 2, end, dp);
        int skip = solve(nums, i + 1, end, dp);

        return dp[i] = Math.max(steal, skip);
    }

    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        // Case 1: Exclude the last house
        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);
        int case1 = solve(nums, 0, n - 2, dp1);

        // Case 2: Exclude the first house
        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);
        int case2 = solve(nums, 1, n - 1, dp2);

        return Math.max(case1, case2);
    }
}