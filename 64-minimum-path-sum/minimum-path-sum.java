import java.util.*;

class Solution {
    int[][] dp;

    int fun(int i, int j, int[][] arr) {
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }

        if (i == 0 && j == 0) {
            return arr[0][0];
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int c1 = fun(i - 1, j, arr);
        int c2 = fun(i, j - 1, arr);

        return dp[i][j] = arr[i][j] + Math.min(c1, c2);
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return fun(m - 1, n - 1, grid);
    }
}