class Solution {
    public int solve(int n, int dp[]) {
        //base case
        if(n == 0 || n == 1) {
            return n;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        // recursive call

       return dp[n] = solve(n-1,dp) + solve(n-2, dp);

        // return result
        // return dp[n];
    }
    public int fib(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
       return solve(n, dp);
    }
}