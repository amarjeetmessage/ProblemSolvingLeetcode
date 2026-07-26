class Solution {
    public int solve(int n, int[] dp){
        // base case
        if( n == 0) return 0;
        int result = 0;
        int min = Integer.MAX_VALUE;

        if(dp[n] != -1){
            return dp[n];
        }
        for(int i = 1; i*i <=n; i++){
            result = 1 + solve(n - (i*i), dp);
            min = Math.min(min, result);
        }
        return dp[n] = min;
    }
    public int numSquares(int n) {
        int[] dp = new int[10001];
        Arrays.fill(dp, -1);
        return solve(n,dp);
    }
}