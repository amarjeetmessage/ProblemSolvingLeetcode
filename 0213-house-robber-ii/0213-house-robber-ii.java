class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0] , nums[1]);

        int[] dp = new int[n];
        Arrays.fill(dp , -1);
        int a = profit(nums, n-1, dp, 1);
        int[] ap = new int[n];
        Arrays.fill(ap , -1);
        int b = profit(nums, n-2, ap, 0);
        return Math.max(a,b);
    }
    public static int profit(int nums[], int n, int[] dp,int i) {
        //base case
        if(n < i) return 0; //or if(n == 1) return nums[1];
        
        //check it exist
        if(dp[n] != -1) {
            return dp[n];
        }

        //recurrence relation 
        int pick = profit(nums ,n-2, dp,i) + nums[n];
        int notPick = profit(nums, n-1, dp,i);

        dp[n] = Math.max(pick , notPick);
        return dp[n];
        
    }
}