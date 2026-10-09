
class Solution {
    int[][] dp;
    boolean[][] visited;

    int fun(int x, int y, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if (y < 0 || y >= m) {
            return (int) 1e9;
        }

        if (x == n - 1) {
            return grid[x][y];
        }

        if (visited[x][y]) {
            return dp[x][y];
        }

        int c1 = grid[x][y] + fun(x + 1, y, grid);
        int c2 = grid[x][y] + fun(x + 1, y - 1, grid);
        int c3 = grid[x][y] + fun(x + 1, y + 1, grid);

        visited[x][y] = true;
        dp[x][y] = Math.min(c1, Math.min(c2, c3));

        return dp[x][y];
    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        dp = new int[n][m];
        visited = new boolean[n][m];

        int ans = (int) 1e9;

        for (int j = 0; j < m; j++) {
            ans = Math.min(ans, fun(0, j, matrix));
        }

        return ans;
    }
}
