import java.util.*;

class Solution {

    Set<String> set = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {

        int left = 0;
        int right = 0;

        // Find how many '(' and ')' need to be removed
        for (char c : s.toCharArray()) {

            if (c == '(') {
                left++;
            } 
            else if (c == ')') {

                if (left > 0) {
                    left--;
                } 
                else {
                    right++;
                }
            }
        }

        backtrack(s, 0, left, right, 0, new StringBuilder());

        return new ArrayList<>(set);
    }

    void backtrack(String s, int index,
                   int leftRemove, int rightRemove,
                   int balance, StringBuilder path) {

        // Invalid
        if (balance < 0) {
            return;
        }

        // End of string
        if (index == s.length()) {

            if (leftRemove == 0 &&
                rightRemove == 0 &&
                balance == 0) {

                set.add(path.toString());
            }

            return;
        }

        char c = s.charAt(index);

        // Parenthesis
        if (c == '(') {

            // Remove '('
            if (leftRemove > 0) {
                backtrack(
                    s, index + 1,
                    leftRemove - 1,
                    rightRemove,
                    balance,
                    path
                );
            }

            // Keep '('
            path.append(c);

            backtrack(
                s, index + 1,
                leftRemove,
                rightRemove,
                balance + 1,
                path
            );

            path.deleteCharAt(path.length() - 1);

        } 
        else if (c == ')') {

            // Remove ')'
            if (rightRemove > 0) {
                backtrack(
                    s, index + 1,
                    leftRemove,
                    rightRemove - 1,
                    balance,
                    path
                );
            }

            // Keep ')' only if it has matching '('
            if (balance > 0) {

                path.append(c);

                backtrack(
                    s, index + 1,
                    leftRemove,
                    rightRemove,
                    balance - 1,
                    path
                );

                path.deleteCharAt(path.length() - 1);
            }

        } 
        else {
            // Letter → always keep
            path.append(c);

            backtrack(
                s, index + 1,
                leftRemove,
                rightRemove,
                balance,
                path
            );

            path.deleteCharAt(path.length() - 1);
        }
    }
}