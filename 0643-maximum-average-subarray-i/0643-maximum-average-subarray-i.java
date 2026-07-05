class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;

        //apply sliding window 
        int sum = 0;
       

        for(int i = 0; i<k; i++){
            sum = sum + nums[i];
        }

        //compare the first window 
        double max = (double)sum / k;

        for(int i = k; i<n; i++){
            sum = sum + nums[i] - nums[i-k];
            max = Math.max(max, (double)sum / k);
        }

        return max;

    }
}