
// // solving greedly prefer this 
// class Solution {
//     public int maxProfit(int[] prices, int fee) {

//         int buy = prices[0];
//         int profit = 0;

//         for (int i = 1; i < prices.length; i++) {

//             // Better buying opportunity
//             if (prices[i] < buy) {
//                 buy = prices[i];
//             }

//             // Profitable selling opportunity
//             else if (prices[i] > buy + fee) {
//                 profit += prices[i] - buy - fee;

//                 // Pretend we bought again today
//                 buy = prices[i] - fee;
//             }
//         }

//         return profit;
//     }
// }


// // sovle using recursion
// class Solution {

//     public int solve(int idx, int buy, int n, int[] prices, int fee) {

//         // Base Case
//         if (idx == n)
//             return 0;

//         if (buy == 1) {

//             // Buy or Skip
//             return Math.max(
//                     -prices[idx] + solve(idx + 1, 0, n, prices, fee),
//                     solve(idx + 1, 1, n, prices, fee));

//         } else {

//             // Sell or Hold
//             return Math.max(
//                     prices[idx] - fee + solve(idx + 1, 1, n, prices, fee),
//                     solve(idx + 1, 0, n, prices, fee));
//         }
//     }

//     public int maxProfit(int[] prices, int fee) {

//         int n = prices.length;

//         return solve(0, 1, n, prices, fee);
//     }
// }




// solve using dp 
class Solution {

    public int solve(int idx, int buy, int n, int[] prices, int fee,int[][] dp) {

        // Base Case
        if (idx == n)
            return 0;

        if(dp[idx][buy]  != -1){
            return dp[idx][buy];
        }

        if (buy == 1) {

            // Buy or Skip
            return dp[idx][buy] = Math.max(
                    -prices[idx] + solve(idx + 1, 0, n, prices, fee,dp),
                    solve(idx + 1, 1, n, prices, fee,dp));

        } else {

            // Sell or Hold
            return dp[idx][buy] = Math.max(
                    prices[idx] - fee + solve(idx + 1, 1, n, prices, fee,dp),
                    solve(idx + 1, 0, n, prices, fee,dp));
        }
    }

    public int maxProfit(int[] prices, int fee) {

        int n = prices.length;
        int dp[][] = new int[n+1][2];
        for(int i = 0; i<=n; i++){
            Arrays.fill(dp[i], -1);
        }

        return solve(0, 1, n, prices, fee,dp);
    }
}