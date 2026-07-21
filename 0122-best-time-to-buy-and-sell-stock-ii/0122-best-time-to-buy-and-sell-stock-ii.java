class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int sum = 0;
        int profit =0;
        int buy = prices[0];

        for(int i = 1; i<n; i++) {
            if(prices[i] > buy){
                profit = prices[i] - buy;
                sum = sum + profit;
                buy = prices[i];
            }else{
                buy = prices[i];
            }
        }
        return sum;
    }
}