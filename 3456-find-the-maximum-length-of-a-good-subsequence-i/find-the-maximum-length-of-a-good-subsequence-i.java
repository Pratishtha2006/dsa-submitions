class Solution {

    int[][][] dp;

    int fun(int i, int prev, int k, int[] nums) {

        if (i == nums.length) {
            return 0;
        }

        // prev = -1 cannot be directly used as array index
        int p = prev + 1;

        if (dp[i][p][k] != -1) {
            return dp[i][p][k];
        }

        // Skip
        int skip = fun(i + 1, prev, k, nums);

        // Take
        int take = 0;

        if (prev == -1) {
            take = 1 + fun(i + 1, i, k, nums);
        }
        else if (nums[i] == nums[prev]) {
            take = 1 + fun(i + 1, i, k, nums);
        }
        else if (k > 0) {
            take = 1 + fun(i + 1, i, k - 1, nums);
        }

        return dp[i][p][k] = Math.max(take, skip);
    }

    public int maximumLength(int[] nums, int k) {

        dp = new int[nums.length][nums.length + 1][k + 1];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= nums.length; j++) {
                java.util.Arrays.fill(dp[i][j], -1);
            }
        }

        return fun(0, -1, k, nums);
    }
}