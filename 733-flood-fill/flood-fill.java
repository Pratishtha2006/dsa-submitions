
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    int oldColor = image[sr][sc];

        if (oldColor == newColor) {
            return image;
        }

        dfs(image, sr, sc, oldColor, newColor);

        return image;
    }

    public void dfs(int[][] image, int r, int c, int oldColor, int newColor) {

        int n = image.length;
        int m = image[0].length;

        if (r < 0 || c < 0 || r >= n || c >= m) {
            return;
        }
        if (image[r][c] != oldColor) {
            return;
        }

        
        image[r][c] = newColor;
        dfs(image, r + 1, c, oldColor, newColor);
        dfs(image, r - 1, c, oldColor, newColor);
        dfs(image, r, c + 1, oldColor, newColor);
        dfs(image, r, c - 1, oldColor, newColor);
    }
}
