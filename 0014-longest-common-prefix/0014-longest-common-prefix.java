class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        // Take first string as base
        String prefix = strs[0];

        // Compare with each next string
        for (int i = 1; i < strs.length; i++) {
            // Keep reducing prefix until it matches the start of current string
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
