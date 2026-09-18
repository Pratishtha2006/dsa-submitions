import java.util.Arrays;

class Solution {
    int[][] dp;

    public int func(int i, int j, String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        // Base case
        if (i >= n || j >= m) {
            return 0;
        }

        // Already calculated
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Characters match hogye 
        if (text1.charAt(i) == text2.charAt(j)) {
            return dp[i][j] = 1 + func(i + 1, j + 1, text1, text2);
        }

        // Characters don't match
        else{
        int c1 = func(i + 1, j, text1, text2);
        int c2 = func(i, j + 1, text1, text2);

        return dp[i][j] = Math.max(c1, c2);
        }
    }


    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        dp = new int[n][m];

        // Fill dp with -1 without for loop
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return func(0, 0, text1, text2);
    }
}