// class Solution {
//     public int solve(int[] nums, int i , int j) {
//         if(i == j) return nums[i];

//         // recursive case
//         int left = nums[i] - solve(nums, i+1, j);
//         int right = nums[j] - solve(nums, i, j-1);

//         return Math.max(left, right);
//     }
//     public boolean predictTheWinner(int[] nums) {
//         return solve(nums, 0, nums.length -1) >= 0;
//     }
// }





class Solution {
    public int solve(int[] nums, int i , int j, int[][] dp) {
        if(i == j) return nums[i];

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        // recursive case
        int left = nums[i] - solve(nums, i+1, j,dp);
        int right = nums[j] - solve(nums, i, j-1, dp);

        return dp[i][j] = Math.max(left, right);
    }
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int i = 0; i<=n; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(nums, 0, n-1,dp) >= 0;
    }
}