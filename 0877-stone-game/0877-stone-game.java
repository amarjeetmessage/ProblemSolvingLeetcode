class Solution {
    public int solve(int[] piles , int i, int j, int[][] dp) {
        // even no of piles 
        // must be win strictly

        // base case
        if(i == j){
            return piles[i];
        } 

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        // recursive case
        int alice = piles[i] - solve(piles, i+1, j,dp);
        int bob = piles[j] - solve(piles, i , j-1,dp);

        return dp[i][j] = Math.max(alice, bob);
        
    }
    public boolean stoneGame(int[] piles) {
        int n=piles.length;
        int[][] dp = new int[n][n];
        for(int i = 0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
     return solve(piles, 0, piles.length -1,dp) > 0 ? true:false;  
    }
}