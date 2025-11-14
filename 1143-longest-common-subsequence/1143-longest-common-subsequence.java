class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m+1][n+1];
    
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(text1,text2,m-1,n-1,dp);
    }
    public static int solve(String text1, String text2, int m, int n , int[][] dp) {
        if(m < 0 || n < 0) return 0;

        if(dp[m][n] != -1) {
            return dp[m][n] ;
        }

        if(text1.charAt(m) != text2.charAt(n)) {
            int a = solve(text1, text2,m-1,n,dp);
            int b = solve(text1, text2,m,n-1,dp);

            dp[m][n] =  Math.max(a,b);
            return dp[m][n];
        }else {
            dp[m][n] =  1 + solve(text1 , text2, m-1, n-1,dp);
            return dp[m][n];
        }
    }
}