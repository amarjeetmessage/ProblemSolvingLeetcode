class Solution {
    public int solve(int m, int n, String s, String t,int[][] dp) {
        // base case
        if(n == t.length()) {
            return 1;
        }
        if(m == s.length()){
            return 0;
        }

        if(dp[m][n] != -1) {
            return dp[m][n];
        }
        // match
        if(s.charAt(m) == t.charAt(n)) {
            int take = solve(m+1,n+1,s,t,dp);
            int notake = solve(m+1,n,s,t,dp);
            return dp[m][n] = take + notake;
        }
        // not match
        return dp[m][n] = solve(m+1,n,s,t,dp);
    }
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i<=m; i++){
            Arrays.fill(dp[i] , -1);
        }
        return solve(0,0,s,t,dp);
    }
}