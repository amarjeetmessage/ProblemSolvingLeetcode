class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;

        int[] leftArr = new int[n];
        int[] rightArr = new int[n];

        int leftSum = 0;
        int rightSum = 0;

        for(int i = 0; i < n; i++) {
            leftArr[i] = leftSum;
            leftSum += nums[i];
        }

        for(int i = n - 1; i >= 0; i--) {
            rightArr[i] = rightSum;
            rightSum += nums[i];
        }

        for(int i = 0; i < n; i++) {
            nums[i] = Math.abs(leftArr[i] - rightArr[i]);
        }

        return nums;
    }
}