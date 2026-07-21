class Solution {
    public int maxProfit(int[] prices, int fee) {

        int buy = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {

            // Better buying opportunity
            if (prices[i] < buy) {
                buy = prices[i];
            }

            // Profitable selling opportunity
            else if (prices[i] > buy + fee) {
                profit += prices[i] - buy - fee;

                // Pretend we bought again today
                buy = prices[i] - fee;
            }
        }

        return profit;
    }
}