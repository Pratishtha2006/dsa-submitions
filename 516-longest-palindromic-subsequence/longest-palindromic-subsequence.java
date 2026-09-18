class Solution {
    int dp[][];
    public int func(int i, int j, String str){
        // i out of bound
        if(i>j){
            return 0;

        }  
        //one character is always a palindrome 
        if(i==j){
            return 1;

        }
        // already calculated
        if (dp[i][j] != -1) {
            return dp[i][j];

        }
        // character match
        if (str.charAt(i) == str.charAt(j)) {
            return dp[i][j] = 2 + func(i + 1, j - 1, str);
        }
        //elements match nhi hue
        
        int c1 = func(i+1,j,str);
        int c2 = func(i,j-1,str);

        return dp[i][j] = Math.max(c1,c2);
    
    }
    public int longestPalindromeSubseq(String s){

        dp = new int[s.length()][s.length()];
        for(int i=0; i < dp.length; i++){
            Arrays.fill(dp[i], -1);

        
        }

        return func(0,s.length()-1,s);
        
    }
}