class Solution {
    public int rob(int[] nums) {
        //dp always 1 based indexing
        int n = nums.length;
        int[] dp = new int[n+1];

        dp[1] = nums[0];
        if(n >= 2) {
            dp[2] = Math.max(nums[0], nums[1]);
        }
        

        for(int i = 3; i<=n; i++) {

            dp[i] = Math.max(dp[i-1], nums[i-1] + dp[i-2]);
        }
        return dp[n];
    }
}


 

// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;

//         int[] dp = new int[n+1];
//         Arrays.fill(dp, -1);

//         return solve(nums, n-1,dp);
//     }
//     public static int solve(int[] nums, int n, int[] dp) {
//         if(n == 0 ) return nums[n];
//         if(n < 0) return 0;

//         if(dp[n] != -1) {
//             return dp[n];
//         }

//         int a = solve(nums, n-1,dp);
//         int b = nums[n] + solve(nums, n-2,dp);

//         dp[n] = Math.max(a,b);
//         return dp[n];
//     }
// }

