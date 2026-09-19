class Solution {

    int[][] dp;

    int fun(int i, int p, int[] arr) {

        if (i == arr.length) {
            return 0;
        }

        // p + 1 because p can be -1
        if (dp[i][p + 1] != -1) {
            return dp[i][p + 1];
        }

        int skip = fun(i + 1, p, arr);

        int take = 0;

        if (p == -1 || arr[i] > arr[p]) {
            take = 1 + fun(i + 1, i, arr);
        }

        return dp[i][p + 1] = Math.max(take, skip);
    }

    public int lengthOfLIS(int[] nums) {

        int n = nums.length;

        dp = new int[n][n + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return fun(0, -1, nums);
    }
}