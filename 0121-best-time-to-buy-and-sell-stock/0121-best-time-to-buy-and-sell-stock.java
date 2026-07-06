class Solution {
    public int maxProfit(int[] prices) {
        // int n = prices.length;

        // int diff = 0;
        // int max = 0;
        // for(int i = 0; i<n; i++){
        //     for(int j = i+1; j<n;j++){
        //         if(prices[i] < prices[j]){
        //             diff = prices[j] - prices[i];
        //             max = Math.max(max, diff);
        //         }
        //     }
        // }
        // return max;


        int n = prices.length;

        int minPrice = prices[0];
        int maxProfit = 0;

        for(int i = 1; i<n; i++){
            minPrice = Math.min(minPrice, prices[i]);

            maxProfit = Math.max(maxProfit , prices[i] - minPrice);
        }
        return maxProfit;
    }
}