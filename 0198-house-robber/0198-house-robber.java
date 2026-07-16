// // Recursoin 
// // always give meaningfull name to function
// class Solution {

//     public int maxAmountRob(int[] nums, int n) {
//         //base case
//         if(n == 0) return nums[n];
//         if(n == 1) return Math.max(nums[0], nums[1]);

//         // recursive call
//         return Math.max( nums[n] + maxAmountRob(nums,n-2), maxAmountRob(nums, n-1));
//     }
//     public int rob(int[] nums) {
//         int n = nums.length;

//         return maxAmountRob(nums, n-1);// n-1
//     }
// }




class Solution {

    public int maxAmountRob(int[] nums, int n, int[] dp) {
        //base case
        if(n == 0) return nums[n];
        if(n == 1) return Math.max(nums[0], nums[1]);

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        if(dp[n] != -1){
            return dp[n];
        }

        // recursive call
        dp[n] = Math.max( nums[n] + maxAmountRob(nums,n-2, dp), maxAmountRob(nums, n-1, dp));

        return dp[n];
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return maxAmountRob(nums, n-1, dp);// n-1
    }
}