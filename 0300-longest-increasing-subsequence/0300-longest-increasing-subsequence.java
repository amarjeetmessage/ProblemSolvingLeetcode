class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1]; // dp[curr][prev+1]
        
        // Initialize dp with -1 meaning "not calculated yet"
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(nums, 0, -1, dp);
    }

    private int solve(int[] nums, int curr, int prev, int[][] dp) {
        if (curr == nums.length) return 0;

        if (dp[curr][prev + 1] != -1) {
            return dp[curr][prev + 1]; // return memoized answer
        }

        int notTake = solve(nums, curr + 1, prev, dp);

        int take = 0;
        if (prev == -1 || nums[curr] > nums[prev]) {
            take = 1 + solve(nums, curr + 1, curr, dp);
        }

        return dp[curr][prev + 1] = Math.max(take, notTake);
    }
}





// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         return solve(nums, 0, -1); // prev index = -1 because nothing chosen yet
//     }

//     private int solve(int[] nums, int curr, int prev) {
//         if (curr == nums.length) return 0;

//         // Option 1: Skip current element
//         int notTake = solve(nums, curr + 1, prev);

//         int take = 0;
//         // Option 2: Take current element if valid
//         if (prev == -1 || nums[curr] > nums[prev]) {
//             take = 1 + solve(nums, curr + 1, curr);
//         }

//         return Math.max(take, notTake);
//     }
// }