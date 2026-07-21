class Solution {
    public int solve(int idx, int buy, int[] prices,int[][] dp) {
        //base case
        if(idx >= prices.length) return 0;

        if(dp[idx][buy] != -1){
            return dp[idx][buy];
        }

        // recursive call
        if(buy == 1){
            return dp[idx][buy] = Math.max(-prices[idx] + solve(idx+1, 0, prices,dp), solve(idx + 1, 1,prices,dp) );
        }else{//not bought
            return dp[idx][buy] = Math.max(+prices[idx] + solve(idx + 2, 1,prices,dp), solve(idx+1, 0 ,prices,dp));
        }
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 2][2];
        for(int i = 0; i< n+2; i++){
            Arrays.fill(dp[i] , -1);
        }
        return solve(0,1,prices,dp);
    }
}