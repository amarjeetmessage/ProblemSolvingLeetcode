class Solution {
    public int[] sortedSquares(int[] nums) {
       int n = nums.length;
       for(int i = 0 ; i<n; i++) {
        nums[i] = Math.abs(nums[i] * nums[i]);
       } 
       Arrays.sort(nums);
       return nums;
    }
}