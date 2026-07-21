// using 2 for loop to check all possible combination -> O(n^2)

// class Solution {
//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         int max = 0;
//         for(int i = 0; i<n; i++){
//             for(int j = i+1; j<n; j++){
//                 if(prices[j] > prices[i]){
//                     max = Math.max(max, prices[j] - prices[i]);
//                 }
//             }
//         }
//         return max;
//     }
// }





// // O(n^2)
class Solution {
    public int maxProfit(int[] prices) {
       int n = prices.length;
       int prevSmallStockPrice = prices[0];
       int maxProfit = 0;

       for(int i = 1; i<n; i++){
        if(prices[i] > prevSmallStockPrice) {
            maxProfit = Math.max(maxProfit, prices[i] - prevSmallStockPrice);
        }else{
            prevSmallStockPrice = prices[i];
        }
       }

       return maxProfit;

    }
}