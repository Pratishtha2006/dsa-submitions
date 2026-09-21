class Solution {
    public long[] resultArray(int[] nums, int k) {

        long[] ans = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {

            long[] next = new long[k];

            // Start a new subarray
            int rem = num % k;
            next[rem]++;

            // Extend previous subarrays
            for (int r = 0; r < k; r++) {

                if (dp[r] == 0) {
                    continue;
                }

                int newRem = (int)((1L * r * rem) % k);

                next[newRem] += dp[r];
            }

            // Add to answer
            for (int r = 0; r < k; r++) {
                ans[r] += next[r];
            }

            dp = next;
        }

        return ans;
    }
}