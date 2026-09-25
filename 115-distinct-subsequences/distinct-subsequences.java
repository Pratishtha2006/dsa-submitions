class Solution {
    int[][] dp;

    public int numDistinct(String s, String t) {

        dp = new int[s.length()][t.length()];

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                dp[i][j] = -1;
            }
        }

        return solve(0, 0, s, t);
    }

    public int solve(int i, int j, String s, String t) {

        // target completely formed
        if (j == t.length()) {
            return 1;
        }

        // source finished
        if (i == s.length()) {
            return 0;
        }

        // already calculated
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s.charAt(i) == t.charAt(j)) {

            // take OR skip
            return dp[i][j] = solve(i + 1, j + 1, s, t)
                            + solve(i + 1, j, s, t);
        }

        // characters don't match -> skip
        return dp[i][j] = solve(i + 1, j, s, t);
    }
}