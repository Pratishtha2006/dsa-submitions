class Solution {
    int[][] dp;
    public int change(int k, int[] nums) {

        dp = new int[302][5002];

        for (int i = 0; i < 302; i++) {
            Arrays.fill(dp[i], -1);
        }

        return fun(0, nums, 0, k);
    }

    int fun(int i, int[] nums, int s, int k) {

        if (s == k)
            return 1;

        if (s > k || i >= nums.length)
            return 0;

        if (dp[i][s] != -1)
            return dp[i][s];

        int c1 = fun(i, nums, s + nums[i], k);

        int c2= fun(i + 1, nums, s, k);

        return dp[i][s] = c1+ c2;
    }
}