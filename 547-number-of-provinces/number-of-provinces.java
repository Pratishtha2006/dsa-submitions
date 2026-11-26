
class Solution {

    void dfs(int start, int[][] adj, boolean[] visit) {

        visit[start] = true;

        for (int neigh = 0; neigh < adj.length; neigh++) {

            if (adj[start][neigh] == 1 && visit[neigh] == false) {
                dfs(neigh, adj, visit);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;

        boolean[] visit = new boolean[n];

        int count = 0;

        for (int i = 0; i < n; i++) {

            if (visit[i] == false) {

                count++;

                dfs(i, isConnected, visit);
            }
        }

        return count;
    }
}
