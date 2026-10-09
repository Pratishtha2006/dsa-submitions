
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) {
                    continue;
                }

                int c1 = Integer.MAX_VALUE;
                int c2 = Integer.MAX_VALUE;

                if (i > 0) {
                    c1 = grid[i - 1][j];
                }

                if (j > 0) {
                    c2 = grid[i][j - 1];
                }

                grid[i][j] += Math.min(c1, c2);
            }
        }

        return grid[m - 1][n - 1];
    }
}
