// /* 
// Short selling is a trading strategy where an investor sells a stock first without owning it, expecting its price to fall. Later, the investor buys the stock back at a lower price and returns it to the lender, earning the difference as profit.

// */

// // agar short selling buy kiye to short selling hi sell karunga
// // normal buy par hi normal sell kar sakte hai 
// class Solution {
//     public long solve(int idx, int buy, int transaction, int n, int[] prices) {
//         //base case
//         if(transaction == 0) return 0;

//         // agar stock me [23] ek size ka prices array ho to use short sell karke 23 return kar dete BUT ham buy hi nahi kar paye kyuki ab aage option hi nahi to ek MIN_Value return kardo 
//         //yaha ham idx == n par 0 return nahi kar sakte hai
//         if(idx == n) {
//             return buy == 1 ? Integer.MIN_VALUE : 0;
//         }

//         //if buy == 2 : ya to mein buy karunga , ya nahi karunga ,ya short sell wala buy karunga 
//         if( buy == 2) {
//             return Math.max(-prices[idx] + solve(idx + 1, 0,transaction,n,prices), Math.max(solve(idx+1, 2,transaction, n, prices), prices[idx] + solve(idx+1, 1,transaction, n, prices)));
//         }
//         //if(buy == 1):short sell karunga ya nahi karunga
//         else if(buy == 1) {
//             return Math.max(solve(idx+1,1,transaction,n, prices), 
//                    -prices[idx] + solve(idx + 1,2,transaction-1,n,prices));
//         }else{// normal sell karunga ya nahi karunga
//             return Math.max(solve(idx+1,0,transaction,n, prices), 
//                    prices[idx] + solve(idx + 1,2,transaction-1,n,prices));
//         }
//     }
//     public long maximumProfit(int[] prices, int k) {
//         int n = prices.length;
//         return solve(0,2,k,n,prices);
//     }
// }










// memoization
 
class Solution {
    public long solve(int idx, int buy, int transaction, int n, int[] prices, long[][][] dp) {
        //base case
        if(transaction == 0) return 0;

        if(idx == n) {
            return buy == 1 ? Integer.MIN_VALUE : 0;
        }

        if(dp[idx][buy][transaction] != -1){
            return dp[idx][buy][transaction];
        }

      
        if( buy == 2) {
            return dp[idx][buy][transaction] = Math.max(-prices[idx] + solve(idx + 1, 0,transaction,n,prices,dp), Math.max(solve(idx+1, 2,transaction, n, prices,dp), prices[idx] + solve(idx+1, 1,transaction, n, prices,dp)));
        }
        else if(buy == 1) {
            return dp[idx][buy][transaction] = Math.max(solve(idx+1,1,transaction,n, prices,dp), 
                   -prices[idx] + solve(idx + 1,2,transaction-1,n,prices,dp));
        }else{
            return dp[idx][buy][transaction] = Math.max(solve(idx+1,0,transaction,n, prices,dp), 
                   prices[idx] + solve(idx + 1,2,transaction-1,n,prices,dp));
        }
    }
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        //note create dp array of long 
        long dp[][][] = new long[n+1][3][k+1];
        for(int i = 0; i<=n; i++){
            for(int j = 0; j<3; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(0,2,k,n,prices,dp);
    }
}