class Solution {
    int dp[][];

    public int fun(int i, int j, String s, String t) {

        // Base case 1: both strings finished
        if (i == s.length() && j == t.length()) {
            return 0;
        }

        // Base case 2: s is finished
        if (i == s.length()) {
            int sum = 0;
            while (j < t.length()) {
                sum += t.charAt(j);
                j++;
            }
            return sum;
        }

        // Base case 3: t is finished
        if (j == t.length()) {
            int sum = 0;
            while (i < s.length()) {
                sum += s.charAt(i);
                i++;
            }
            return sum;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = fun(i + 1, j + 1, s, t);
        }

        // Delete from s OR delete from t
        int deleteS = s.charAt(i) + fun(i + 1, j, s, t);
        int deleteT = t.charAt(j) + fun(i, j + 1, s, t);

        return dp[i][j] = Math.min(deleteS, deleteT);
    }

    public int minimumDeleteSum(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return fun(0, 0, s1, s2);
    }
}