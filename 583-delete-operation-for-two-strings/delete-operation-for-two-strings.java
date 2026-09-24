class Solution {
    int dp[][];
    public int fun(int i, int j, String s, String t){
        
        if(i >= s.length() || j >= t.length()){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
            
        }
        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = 1 + fun(i+1, j+1, s, t);
        }

        else{
            int c1 = fun(i+1, j, s, t);
            int c2 = fun(i, j+1, s, t);
            return dp[i][j] = Math.max(c1, c2);
        }
        
        
        
    }
    public int minDistance(String word1, String word2) {
         int n = word1.length();
        int m = word2.length();
        dp = new int[n][m];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int lcs = fun(0, 0 , word1, word2);

        return (n + m)- 2 * lcs;


        
    }
}