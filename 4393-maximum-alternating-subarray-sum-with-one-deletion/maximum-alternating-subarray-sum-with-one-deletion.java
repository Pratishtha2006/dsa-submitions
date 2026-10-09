import java.util.*;

class Solution {
    long[][][][] dp;

    long fun(int i, int[] nums, int s, int sg, int p) {
        if (i >= nums.length) {
            if (s == 0) {
                return Long.MIN_VALUE / 2;
            }
            return 0;
        }

        if (dp[i][s][sg + 1][p] != Long.MIN_VALUE / 2) {
            return dp[i][s][sg + 1][p];
        }

        long curr = 1L * nums[i] * sg;
        long m = Long.MIN_VALUE / 2;

        if (s == 0) {
            long c1 = fun(i + 1, nums, s, sg, p);
            long c2 = curr + fun(i + 1, nums, 1, -sg, p);

            m = Math.max(m, c1);
            m = Math.max(m, c2);
        } else {
            long c1 = curr + fun(i + 1, nums, 1, -sg, p);

            m = Math.max(m, 0);

            if (p == 1) {
                long c2 = fun(i + 1, nums, s, sg, 0);
                m = Math.max(m, c2);
            }

            m = Math.max(m, c1);
        }

        return dp[i][s][sg + 1][p] = m;
    }

    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;

        dp = new long[n][2][3][2];

        for (int i = 0; i < n; i++) {
            for (int s = 0; s < 2; s++) {
                for (int sg = 0; sg < 3; sg++) {
                    Arrays.fill(dp[i][s][sg], Long.MIN_VALUE / 2);
                }
            }
        }

        return fun(0, nums, 0, 1, 1);
    }
}