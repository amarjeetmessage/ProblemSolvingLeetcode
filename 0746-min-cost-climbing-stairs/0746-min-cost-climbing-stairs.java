class Solution {
    public int solve(int i, int[] cost, int[] dp) {
        if(i >= cost.length) return 0;

        if(dp[i] != -1) return dp[i];

        int oneStep = solve(i+1, cost,dp);
        int twoStep = solve(i+2, cost,dp);

        dp[i] = cost[i] + Math.min(oneStep, twoStep);
        return dp[i];
    }
    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length];
        Arrays.fill(dp, -1);
        return Math.min(solve(0,cost,dp), solve(1,cost,dp));
    }

}