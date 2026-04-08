class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return findans(0, arr, k, dp);
    }

    public int findans(int s, int[] arr, int k, int[] dp) {
        if (s >= arr.length) return 0;

        if (dp[s] != -1) return dp[s];

        int max = 0;
        int ans = 0;

        for (int i = s; i < Math.min(s + k, arr.length); i++) {
            max = Math.max(max, arr[i]);
            int size = i - s + 1;

            int ans1 = max * size;
            int ans2 = findans(i + 1, arr, k, dp);

            ans = Math.max(ans, ans1 + ans2);
        }

        return dp[s] = ans;
    }
}