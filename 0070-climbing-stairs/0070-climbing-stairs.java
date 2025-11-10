class Solution {
    public static int climbStairs(int n) {

        int[] dp = new int[n+1];
        Arrays.fill(dp , -1);

        return countWays(n, dp);
    }
    public static int countWays(int n, int[] dp) {
        //base case
        if(n == 1 || n == 2) return n; 
         
         if(dp[n] != -1) {
            return dp[n];
         }

        dp[n] = countWays(n-1,dp) + countWays(n-2,dp);

        return dp[n];

    }
}