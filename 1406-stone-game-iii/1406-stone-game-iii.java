class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        Integer[] dp = new Integer[n];

        int diff = solve(0, stoneValue, dp);

        if (diff > 0) return "Alice";
        if (diff < 0) return "Bob";
        return "Tie";
    }
     private int solve(int i, int[] arr, Integer[] dp) {
        if (i >= arr.length)
            return 0;

        if (dp[i] != null)
            return dp[i];

        int sum = 0;
        int best = Integer.MIN_VALUE;

        for (int k = 0; k < 3 && i + k < arr.length; k++) {
            sum += arr[i + k];
            best = Math.max(best, sum - solve(i + k + 1, arr, dp));
        }

        return dp[i] = best;
    }
}