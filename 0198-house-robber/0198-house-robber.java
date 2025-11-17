class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return solve(nums, n-1,dp);
    }
    public static int solve(int[] nums, int n, int[] dp) {
        if(n == 0 ) return nums[n];
        if(n < 0) return 0;

        if(dp[n] != -1) {
            return dp[n];
        }

        int a = solve(nums, n-1,dp);
        int b = nums[n] + solve(nums, n-2,dp);

        dp[n] = Math.max(a,b);
        return dp[n];
    }
}