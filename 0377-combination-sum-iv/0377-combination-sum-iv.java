class Solution {
    public int solve(int n, int target, int[] nums, int[] dp) {
        //base case 
        if(target == 0) return 1;
        if(target < 0) return 0;

        if(dp[target] != -1){
            return dp[target];
        }

        // recursive call
        int result = 0;
        for(int i = 0; i<n; i++){
            result = result + solve(n, target - nums[i], nums, dp);
        }
        return dp[target] = result;
    }
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int dp[] = new int[target + 1];
        Arrays.fill(dp, -1);

        return solve(n, target, nums,dp);
    }
}