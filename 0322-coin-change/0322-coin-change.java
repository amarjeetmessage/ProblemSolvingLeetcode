class Solution {

    public int solve(int n, int amount, int[] coins,int[][] dp){
        // base case
        if(n==0) return (int)1e9;
        if(amount == 0) return 0;
        if(amount < 0) return (int)1e9;

        if(dp[n][amount] != -1){
            return dp[n][amount];
        }

        //recursive call
        dp[n][amount] = Math.min(solve(n-1,amount,coins,dp) , 1+solve(n, amount-coins[n-1], coins,dp));

        return dp[n][amount];
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int i = 0; i<=n; i++){
            Arrays.fill(dp[i] , -1);
        }
        int ans = solve(n,amount,coins,dp);
        return ans >= 1e9 ? -1 : ans;
    }
}