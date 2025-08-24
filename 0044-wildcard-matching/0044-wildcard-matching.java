class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        boolean dp[][] = new boolean[n+1][m+1];

        // initialise
        dp[0][0] = true;  // empty string matches empty pattern

        for (int i = 1; i <= n; i++) {
            dp[i][0] = false; // non-empty string can't match empty pattern
        }

        for (int j = 1; j <= m; j++) {
            if (p.charAt(j-1) == '*') {
                dp[0][j] = dp[0][j-1]; // '*' can match empty string
            }
        }

        // bottom-up
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } 
                else if (p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                    // dp[i-1][j] → '*' matches current char
                    // dp[i][j-1] → '*' matches empty
                } 
                else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }
}
