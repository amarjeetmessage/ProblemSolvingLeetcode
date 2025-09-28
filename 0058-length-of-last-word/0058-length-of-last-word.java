class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        int n = s.length();

        // Step 1: skip trailing spaces
        int i = n - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Step 2: count characters of the last word
        while (i >= 0 && s.charAt(i) != ' ') {
            count++;
            i--;
        }

        return count;
    }
}
