class Solution {
    public int scoreOfParentheses(String s) {
        return solve(s, 0, s.length() - 1);
    }

    int solve(String s, int l, int r) {
        // Base case: ()
        if (r - l == 1) {
            return 1;
        }

        int balance = 0;

        // Find the first balanced part
        for (int i = l; i <= r; i++) {
            if (s.charAt(i) == '(')
                balance++;
            else
                balance--;

            // First complete group
            if (balance == 0) {
                // Whole string is one pair: (A)
                if (i == r) {
                    return 2 * solve(s, l + 1, r - 1);
                }

                // AB → score(A) + score(B)
                return solve(s, l, i) + solve(s, i + 1, r);
            }
        }

        return 0;
    }
}