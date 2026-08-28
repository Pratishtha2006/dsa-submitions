class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers or numbers ending with 0 (but not 0 itself) cannot be palindrome
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversed = 0;

        // Build half of the reversed number
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }

        // For odd digit count, ignore the middle digit (reversed/10)
        return x == reversed || x == reversed / 10;
    }
}