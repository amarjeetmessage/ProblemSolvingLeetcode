class Solution {
    public int solve(int idx, int buy, int transaction, int n, int[] prices,int[][][] dp) {
        // base case
        if(idx == n || transaction == 0) return 0;

        if(dp[idx][buy][transaction] != -1){
            return dp[idx][buy][transaction];
        }

        // recursive code 
        if(buy==1) {
            return dp[idx][buy][transaction] = Math.max(-prices[idx] + solve(idx + 1, 0, transaction, n, prices,dp) , 
                                        solve(idx + 1, 1, transaction, n, prices,dp));
        }else{//sell
            return dp[idx][buy][transaction] = Math.max(prices[idx] + solve(idx + 1, 1, transaction -1, n, prices,dp), 
                                        solve(idx + 1, 0, transaction, n, prices,dp));
        }
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;

        //create dp for req size and changing variables
        int[][][] dp = new int[n+1][2][3];
        for(int i = 0; i<=n;i++){
            for(int j = 0; j<2; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(0,1,2,n,prices,dp);
    }
}