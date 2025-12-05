class Solution {
    public int countPartitions(int[] nums) {
        int totalSum = 0;
        
        for (int num : nums) {
            totalSum += num;
        }
        
        // If total sum is even, all (n - 1) partitions are valid
        if (totalSum % 2 == 0) {
            return nums.length - 1;
        }
        
        // If total sum is odd, no partition is valid
        return 0;
    }
}
//POTD