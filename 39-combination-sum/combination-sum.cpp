void fun(int i,int s,int target,vector<int>&nums,vector<int>&t,vector<vector<int>>&ans){
    if(s==target){
        ans.push_back(t);
        return ;
    }

    if(s>target || i>=nums.size()){
        return ;
    }

    // vector<int>v1=t;
    // v1.push_back(nums[i]);

    t.push_back(nums[i]);
    fun(i,s+nums[i],target,nums,t,ans);
    t.pop_back();

    fun(i+1,s,target,nums,t,ans);

    
}


class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& nums, int target) {
        vector<vector<int>>ans;
        vector<int>t;
        fun(0,0,target,nums,t,ans);
        return ans;
    }
};