import java.util.*;
class Solution {
    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {

                if(grid[i][j] == 2)
                    q.add(new int[]{i, j});

                if(grid[i][j] == 1)
                    fresh++;
            }
        }

        int time = 0;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while(!q.isEmpty() && fresh > 0) {

            int size = q.size();

            for(int i = 0; i < size; i++) {

                int[] a = q.poll();

                for(int d = 0; d < 4; d++) {

                    int x = a[0] + dx[d];
                    int y = a[1] + dy[d];

                    if(x >= 0 && y >= 0 && x < n && y < m
                       && grid[x][y] == 1) {

                        grid[x][y] = 2;
                        fresh--;
                        q.add(new int[]{x, y});
                    }
                }
            }

            time++;
        }

        if(fresh > 0)
            return -1;

        return time;
    }
}
