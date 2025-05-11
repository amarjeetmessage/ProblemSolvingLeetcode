// class Solution {
//     public int maxSubArray(int[] nums) {
//         int maxSum = Integer.MIN_VALUE;
//         int currentSum = 0;

//         for(int i=0; i<nums.length; i++){
//             currentSum = currentSum + nums[i];
//             if(currentSum < 0){
//                 currentSum = 0;
//             }
//             maxSum = Math.max(currentSum,maxSum);
//         }
//         return maxSum;
//     }
// }




class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for(int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
