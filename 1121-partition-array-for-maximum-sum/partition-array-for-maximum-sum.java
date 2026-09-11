import java.util.*;

class Solution {

    int[][] dp;

    int fun(int i, int p, int[] nums, int m, int k) {

        // Base case
        if (i >= nums.length) {
            return 0;
        }

        int len = i - p + 1;

        // Memoization
        if (dp[i][p] != -1) {
            return dp[i][p];
        }

        // Update maximum element of current partition
        m = Math.max(m, nums[i]);

        int ans = 0;

        if (len == k) {

            int a = m * len + fun(i + 1, i + 1, nums, 0, k);

            ans = Math.max(ans, a);

        } else {

            // Option 1: End current partition here
            int a = m * len + fun(i + 1, i + 1, nums, 0, k);

            // Option 2: Include nums[i] in current partition
            int b = fun(i + 1, p, nums, m, k);

            ans = Math.max(ans, a);
            ans = Math.max(ans, b);
        }

        return dp[i][p] = ans;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {

        dp = new int[501][501];

        // Fill dp with -1
        for (int i = 0; i < 501; i++) {
            Arrays.fill(dp[i], -1);
        }

        return fun(0, 0, arr, 0, k);
    }
}