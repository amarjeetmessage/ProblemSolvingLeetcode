class Solution {
    public boolean validPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            int j = s.length() - 1 - i;

            if (s.charAt(i) != s.charAt(j)) {
                // Mismatch mila -> try skip left OR skip right
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
        }
        // Koi mismatch hi nahi -> already palindrome
        return true;
    }

    private boolean isPalindrome(String s, int left, int right) {
        for (int i = left, j = right; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
