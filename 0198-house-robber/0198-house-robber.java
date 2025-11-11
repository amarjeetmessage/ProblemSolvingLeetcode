class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp , -1);
        return profit(nums, n-1, dp);
    }
    public static int profit(int nums[], int n, int[] dp) {
        //base case
        if(n < 0) return 0; //or if(n == 1) return nums[1];
        if(n == 0) return nums[0];
        //check it exist
        if(dp[n] != -1) {
            return dp[n];
        }

        //recurrence relation 
        int pick = profit(nums ,n-2, dp) + nums[n];
        int notPick = profit(nums, n-1, dp);

        dp[n] = Math.max(pick , notPick);
        return dp[n];
        
    }
}