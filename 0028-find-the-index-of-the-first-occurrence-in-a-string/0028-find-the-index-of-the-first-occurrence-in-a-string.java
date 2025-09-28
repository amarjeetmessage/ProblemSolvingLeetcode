class Solution {
    
    // =========================
    // Approach 1: Using Built-in Method (Easy & Recommended)
    // =========================
    public int strStr(String haystack, String needle) {
        // The indexOf method returns the index of the first occurrence of needle
        // in haystack, or -1 if needle is not present.
        return haystack.indexOf(needle);
    }

    /* 
    // =========================
    // Approach 2: Brute Force (Check each starting position)
    // =========================
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        // Edge case: if needle is empty, return 0
        if (m == 0) return 0;

        // Loop through all possible starting positions in haystack
        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            // Check if substring starting at i matches needle
            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            // If we matched entire needle, return starting index
            if (j == m) return i;
        }

        // Needle not found in haystack
        return -1;
    }
    */

    /*
    // =========================
    // Approach 3: KMP Algorithm (Optimized for large strings)
    // =========================
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;

        // Preprocess the needle to get LPS (Longest Prefix Suffix) array
        int[] lps = computeLPS(needle);
        int i = 0, j = 0;  // i -> haystack, j -> needle

        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }

            if (j == needle.length()) {
                // Full match found, return starting index
                return i - j;
            } else if (i < haystack.length() && haystack.charAt(i) != needle.charAt(j)) {
                // Mismatch after j matches
                if (j != 0) {
                    j = lps[j - 1];  // Move j using LPS array
                } else {
                    i++;  // No match, move i forward
                }
            }
        }

        // Needle not found
        return -1;
    }

    // Function to compute LPS array for KMP
    private int[] computeLPS(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n];
        int len = 0;  // length of previous longest prefix suffix
        int i = 1;

        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];  // fall back in LPS array
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
    */
}
