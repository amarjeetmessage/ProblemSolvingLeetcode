class Solution {
    public int solve(int n, int[] dp) {
        //Base case
        if(n < 0){
            return 0;
        }
        if(n <= 1){
            return 1;
        }

        if(dp[n] != -1) {
            return dp[n];
        }

        //recursive call
        dp[n] = solve(n-1,dp) + solve(n-2, dp);

        // return result
        return dp[n];
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n,dp);
    }
}