class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[][] dp = new int[n+1][amount+1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = solve(coins, amount, n-1,dp);

        if (ans >= 1000000000) {
            return -1;
        }
        return ans;
    }

    private int solve(int[] coins, int amount, int n,int[][] dp) {
        if (amount == 0) return 0;

        if (n < 0 || amount < 0) return 1000000000; // large number

        if(dp[n][amount] != -1) {
            return dp[n][amount];
        }

        int take = 1 + solve(coins, amount - coins[n], n,dp);

        int notTake = solve(coins, amount, n - 1,dp);

        dp[n][amount] = Math.min(take, notTake);
        return dp[n][amount];
    }
}
