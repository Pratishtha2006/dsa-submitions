class Solution {

    int[][] dp = new int[101][2];

    int fun(int i, int f, int[] nums) {

        if (i == nums.length - 1) {
            if (f == 0)
                return nums[i];
            return 0;
        }

        if (i >= nums.length) {
            return 0;
        }

        if (dp[i][f] != -1)
            return dp[i][f];

        int ans = 0;

        if (i == 0) {

            int a = nums[i] + fun(i + 2, 1, nums);
            int b = fun(i + 1, f, nums);

            ans = Math.max(ans, a);
            ans = Math.max(ans, b);

        } else {

            int a = nums[i] + fun(i + 2, f, nums);
            int b = fun(i + 1, f, nums);

            ans = Math.max(ans, a);
            ans = Math.max(ans, b);
        }

        return dp[i][f] = ans;
    }

    public int rob(int[] nums) {

        // Equivalent to memset(dp, -1, sizeof(dp))
        for (int i = 0; i < 101; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }

        return fun(0, 0, nums);
    }
}