class Solution {
    
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;  // matched, move in s
            }
            j++;  // always move in t
        }
        
        return i == s.length(); // if i reached end of s, it's subsequence
    }
}
