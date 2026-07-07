// solve this again

// class Solution {
//     public int maxSubarraySumCircular(int[] nums) {
//        int n = nums.length;

//        int max = Integer.MIN_VALUE;
//         for(int i = 0; i<n; i++){
//             int sum = 0;
//             for(int j = 0; j<n; j++){
//                 int index = (i + j) % n;
//                 sum = sum + nums[index];
//                 max = Math.max(max, sum);
//             }
//         } 
//         return max;
//     }
// }

class Solution {

    public int maxSubarraySumCircular(int[] nums) {

        int total = 0;

        int currMax = nums[0];
        int maxSum = nums[0];

        int currMin = nums[0];
        int minSum = nums[0];

        total = nums[0];

        for (int i = 1; i < nums.length; i++) {

            total += nums[i];

            // Kadane for Maximum Subarray
            currMax = Math.max(nums[i], currMax + nums[i]);
            maxSum = Math.max(maxSum, currMax);

            // Kadane for Minimum Subarray
            currMin = Math.min(nums[i], currMin + nums[i]);
            minSum = Math.min(minSum, currMin);
        }

        // All numbers are negative
        if (maxSum < 0)
            return maxSum;

        return Math.max(maxSum, total - minSum);
    }
}