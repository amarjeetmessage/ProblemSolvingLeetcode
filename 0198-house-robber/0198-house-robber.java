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



// // memoization
// class Solution {

//     public int maxAmountRob(int[] nums, int n, int[] dp) {
//         //base case
//         if(n == 0) return nums[n];
//         if(n == 1) return Math.max(nums[0], nums[1]);

//         dp[0] = nums[0];
//         dp[1] = Math.max(nums[0], nums[1]);

//         if(dp[n] != -1){
//             return dp[n];
//         }

//         // recursive call
//         dp[n] = Math.max( nums[n] + maxAmountRob(nums,n-2, dp), maxAmountRob(nums, n-1, dp));

//         return dp[n];
//     }
//     public int rob(int[] nums) {
//         int n = nums.length;
//         int[] dp = new int[n+1];
//         Arrays.fill(dp, -1);

//         return maxAmountRob(nums, n-1, dp);// n-1
//     }
// }





// //tabulaton -> bottom up approach
// class Solution {

//     public int maxAmountRob(int[] nums, int n, int[] dp) {

//         if (n == 0) return nums[0];
//         if (n == 1) return Math.max(nums[0], nums[1]);

//         dp[0] = nums[0];
//         dp[1] = Math.max(nums[0], nums[1]);

//         for (int i = 2; i <= n; i++) {

//             dp[i] = Math.max(
//                     nums[i] + dp[i - 2],
//                     dp[i - 1]
//             );
//         }

//         return dp[n];
//     }

//     public int rob(int[] nums) {

//         int n = nums.length;

//         int[] dp = new int[n];

//         return maxAmountRob(nums, n - 1, dp);
//     }
// }





//space optimization
class Solution {

    public int maxAmountRob(int[] nums, int n, int[] dp) {

        if (n == 0) return nums[0];
        if (n == 1) return Math.max(nums[0], nums[1]);

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i <= n; i++) {

            dp[2] = Math.max(
                    nums[i] + dp[0],
                    dp[1]
            );
            dp[0] = dp[1];
            dp[1] = dp[2];
        }

        return dp[1];
    }

    public int rob(int[] nums) {

        int n = nums.length;

        int[] dp = new int[3];

        return maxAmountRob(nums, n - 1, dp);
    }
}