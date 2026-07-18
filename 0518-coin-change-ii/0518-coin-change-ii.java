// class Solution {
//     public int totalWays(int n, int amount, int[] coins) {
//         if( n == 0) return 0;
//         if(amount < 0) return 0;
//         if( amount == 0) return 1;

//         int res = totalWays(n-1, amount, coins) + totalWays(n, amount - coins[n-1], coins);

//         return res;
//     }
//     public int change(int amount, int[] coins) {
//         int n = coins.length;

//         return totalWays(n, amount, coins);
//     }
// }





// memoization

// class Solution {
//     public int totalWays(int n, int amount, int[] coins, int[][] dp) {
//         if( n == 0) return 0;
//         if(amount < 0) return 0;
//         if( amount == 0) return 1;

//         if(dp[n][amount] != -1){
//             return dp[n][amount];
//         }

//         return dp[n][amount] = totalWays(n-1, amount, coins,dp) + totalWays(n, amount - coins[n-1], coins,dp);
//     }
//     public int change(int amount, int[] coins) {
//         int n = coins.length;
//         int[][] dp = new int[n+1][amount+1];
//         for(int i = 0; i<n+1; i++){
//             Arrays.fill(dp[i] , -1);
//         }

//         return totalWays(n, amount, coins,dp);
//     }
// }








//tabulation

class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int i = 0; i<n+1; i++){
            Arrays.fill(dp[i] , 0);
        }
        // first col 1 kar do first row 0 pahle se hi hai 
        for(int i =0; i<=n; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i<=n; i++){
            for(int j = 1; j<= amount; j++){
                if(j-coins[i-1]>=0){

                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][amount];
    }
}

