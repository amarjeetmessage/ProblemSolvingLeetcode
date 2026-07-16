// class Solution {
//     public int solve(int[] nums, int end, int start) {
//         if(end < start) return 0;

//         int pick = nums[end] + solve(nums, end-2,start);
//         int notpick = solve(nums, end-1, start);

//         return Math.max(pick, notpick);
//     }
//     public int rob(int[] nums) {
//         int n = nums.length;

//         if(n == 1) return nums[0];
//         if(n == 2) return Math.max(nums[0], nums[1]);

//         int ans1 = solve(nums, n-1, 1);
//         int ans2 = solve(nums, n-2, 0);

//         return Math.max(ans1, ans2);
//     }
// }



// // memoization
// class Solution {

//     public int solve(int[] nums, int end, int start, int[] dp) {

//         if (end < start) {
//             return 0;
//         }

//         if (dp[end] != -1) {
//             return dp[end];
//         }

//         int pick = nums[end] + solve(nums, end - 2, start, dp);

//         int notPick = solve(nums, end - 1, start, dp);

//         dp[end] = Math.max(pick, notPick);

//         return dp[end];
//     }

//     public int rob(int[] nums) {

//         int n = nums.length;

//         if (n == 1) return nums[0];
//         if (n == 2) return Math.max(nums[0], nums[1]);

//         int[] dp1 = new int[n];
//         int[] dp2 = new int[n];

//         Arrays.fill(dp1, -1);
//         Arrays.fill(dp2, -1);

//         // Case 1: Exclude first house
//         int ans1 = solve(nums, n - 1, 1, dp1);

//         // Case 2: Exclude last house
//         int ans2 = solve(nums, n - 2, 0, dp2);

//         return Math.max(ans1, ans2);
//     }
// }







// class Solution {

//     public int solve(int[] nums, int start, int end) {

//         if (start == end) {
//             return nums[start];
//         }

//         int[] dp = new int[nums.length];

//         dp[start] = nums[start];
//         dp[start + 1] = Math.max(nums[start], nums[start + 1]);

//         for (int i = start + 2; i <= end; i++) {

//             dp[i] = Math.max(
//                     nums[i] + dp[i - 2],
//                     dp[i - 1]
//             );
//         }

//         return dp[end];
//     }

//     public int rob(int[] nums) {

//         int n = nums.length;

//         if (n == 1) {
//             return nums[0];
//         }

//         // Case 1: Exclude last house
//         int ans1 = solve(nums, 0, n - 2);

//         // Case 2: Exclude first house
//         int ans2 = solve(nums, 1, n - 1);

//         return Math.max(ans1, ans2);
//     }
// }





class Solution {

    public int solve(int[] nums, int start, int end) {

        // Only one house in this range
        if (start == end) {
            return nums[start];
        }

        int prev2 = nums[start];
        int prev1 = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {

            int curr = Math.max(
                    nums[i] + prev2,
                    prev1
            );

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        // Case 1: Exclude last house
        int ans1 = solve(nums, 0, n - 2);

        // Case 2: Exclude first house
        int ans2 = solve(nums, 1, n - 1);

        return Math.max(ans1, ans2);
    }
}