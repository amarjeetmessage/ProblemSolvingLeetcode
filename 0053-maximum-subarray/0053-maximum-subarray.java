class Solution {
    public int maxSubArray(int[] nums) {
        // int n = nums.length;

        // int max = Integer.MIN_VALUE;
        // for(int i = 0; i<n; i++){
        //     int sum = 0;
        //     for(int j = i; j<n; j++){
        //         sum = sum + nums[j];
        //         max = Math.max(max, sum);
        //     }
        // }
        // return max;

        //use kadane's algorithm 

        int n =nums.length;

        int sum = nums[0];
        int max = nums[0];

        for(int i = 1; i<n; i++){
            sum = Math.max(nums[i], sum + nums[i]);
            max = Math.max(max, sum);
        }
        return max;
    }
}