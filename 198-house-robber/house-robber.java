class Solution {
    int[] dp;
     public int solve(int[] nums, int i){

        if(i>= nums.length){
            return 0;

        }

        if(dp[i]!= -1) return dp[i];
        int steal = nums[i] + solve(nums, i+2);
        int skip = solve(nums, i+1) ;

        return dp[i] = Math.max(steal, skip);

    }
    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp,-1);

        return solve(nums,0);
        
    }
}