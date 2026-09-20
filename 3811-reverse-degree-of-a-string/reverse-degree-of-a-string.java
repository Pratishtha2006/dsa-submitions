class Solution {
    int solve(String s, int i){
        // base case
        if(i== s.length()){
            return 0;
        }

        // firstly take character from the string

        char c = s.charAt(i);

        // reverse alphabet value

        int value= 26 -(c-'a');

        // calculate current value with reverse alphabet value and index number 

        int current = value*(i+1);

        // recursive call for processing of remaining characters

        return current + solve(s, i+1);
        
    }
    public int reverseDegree(String s) {
        return solve(s,0);
        
    }
}