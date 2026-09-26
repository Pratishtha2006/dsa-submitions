import java.util.Arrays;

class Solution {

    int[] dp;

    public int fun(int curr, int n) {

        if (curr == n) return 1;
        if (curr > n) return 0;

        if (dp[curr] != -1) return dp[curr];

        dp[curr] = fun(curr + 1, n) + fun(curr + 2, n);

        return dp[curr];
    }

    public int climbStairs(int n) {

        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return fun(0, n);
    }
}