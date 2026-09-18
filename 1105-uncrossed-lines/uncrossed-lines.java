import java.util.Arrays;

class Solution {
    int[][] dp;

    public int func(int i, int j, int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;

        // Base case
        if (i >= n || j >= m) {
            return 0;
        }

        // Already calculated
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Characters match hogye 
        if (arr1[i] == arr2[j]) {
            return dp[i][j] = 1 + func(i + 1, j + 1, arr1, arr2);
        }

        // Characters don't match
        else{
        int c1 = func(i + 1, j,arr1,arr2);
        int c2 = func(i, j + 1, arr1,arr2);

        return dp[i][j] = Math.max(c1, c2);
        }
    }


    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        dp = new int[n][m];

        // Fill dp with -1 without for loop
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return func(0, 0, nums1, nums2);
    }
}