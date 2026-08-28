class Solution {

    List<String> ans = new ArrayList<>();

    void fun(int i, String s, String tmp, String[] map) {

        
        if (i >= s.length()) {
            ans.add(tmp);
            return;
        }

        
        int curr = s.charAt(i) - '0';
        String str = map[curr];

        
        for (int j = 0; j < str.length(); j++) {

            tmp += str.charAt(j);       
            fun(i + 1, s, tmp, map);    
            tmp = tmp.substring(0, tmp.length() - 1); 
        }
    }

    public List<String> letterCombinations(String s) {

        String[] map = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        ans.clear();

        if (s.length() == 0)
            return ans;

        fun(0, s, "", map);

        return ans;
    }
}