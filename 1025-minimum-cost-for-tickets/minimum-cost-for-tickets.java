class Solution {

    int[] dp;

    int fun(int i, int[] days, int[] costs) {

        // Base case
        if (i >= days.length) {
            return 0;
        }

        // DP: already calculated
        if (dp[i] != -1) {
            return dp[i];
        }

        // Buy 1-day pass
        int oneDay = costs[0] + fun(i + 1, days, costs);

        // Buy 7-day pass
        int j = i;

        while (j < days.length && days[j] < days[i] + 7) {
            j++;
        }

        int sevenDay = costs[1] + fun(j, days, costs);

        // Buy 30-day pass
        j = i;

        while (j < days.length && days[j] < days[i] + 30) {
            j++;
        }

        int thirtyDay = costs[2] + fun(j, days, costs);

        // Store answer in dp
        return dp[i] = Math.min(oneDay,
                Math.min(sevenDay, thirtyDay));
    }

    public int mincostTickets(int[] days, int[] costs) {

        // Create DP array
        dp = new int[days.length];

        // Fill with -1
        Arrays.fill(dp, -1);

        return fun(0, days, costs);
    }
}