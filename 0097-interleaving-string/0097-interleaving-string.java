class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;

        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        return solve(0, 0, s1, s2, s3, dp);
    }

    public boolean solve(int i, int j, String s1, String s2, String s3, int[][] dp) {
        int k = i + j;

        // base case
        if (k == s3.length()) {
            return true;
        }

        // memo check
        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }

        boolean ans = false;

        // take from s1
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            ans = ans || solve(i + 1, j, s1, s2, s3, dp);
        }

        // take from s2
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            ans = ans || solve(i, j + 1, s1, s2, s3, dp);
        }

        dp[i][j] = ans ? 1 : 0;
        return ans;
    }
}