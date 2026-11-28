
import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
       Queue<int[]> q = new LinkedList<>();

        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {

                if(grid[i][j] == 2)
                    q.add(new int[]{i,j});

                else if(grid[i][j] == 1)
                    fresh++;
            }
        }

        int day = 0;
           while(!q.isEmpty() && fresh > 0) {

            int currRot = q.size();

            while(currRot > 0) {

                int[] a = q.poll();
                int x = a[0];
                int y = a[1];
                if(y-1 >= 0 && grid[x][y-1] == 1) {
                    grid[x][y-1] = 2;
                    fresh--;
                    q.add(new int[]{x,y-1});
                }

           
                if(y+1 < m && grid[x][y+1] == 1) {
                    grid[x][y+1] = 2;
                    fresh--;
                    q.add(new int[]{x,y+1});
                }

           
                if(x-1 >= 0 && grid[x-1][y] == 1) {
                    grid[x-1][y] = 2;
                    fresh--;
                    q.add(new int[]{x-1,y});
                }
                if(x+1 < n && grid[x+1][y] == 1) {
                    grid[x+1][y] = 2;
                    fresh--;
                    q.add(new int[]{x+1,y});
                }

                currRot--;
            }

            day++;
        }

        if(fresh > 0)
            return -1;
       return day;
    }
}