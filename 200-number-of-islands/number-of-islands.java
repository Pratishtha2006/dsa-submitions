
class Solution {

    void dfs(int r, int c, char[][] grid, boolean[][] visit) {

        visit[r][c] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {

            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nc >= 0 &&
                nr < grid.length && nc < grid[0].length &&
                grid[nr][nc] == '1' && visit[nr][nc] == false) {

                dfs(nr, nc, grid, visit);
            }
        }
    }

    public int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visit = new boolean[n][m];

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == '1' && visit[i][j] == false) {

                    count++;

                    dfs(i, j, grid, visit);
                }
            }
        }

        return count;
    }
}
