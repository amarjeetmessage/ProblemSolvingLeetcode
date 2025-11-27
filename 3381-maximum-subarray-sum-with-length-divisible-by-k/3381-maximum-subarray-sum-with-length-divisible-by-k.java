class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] minPrefix = new long[k];
        Arrays.fill(minPrefix, Long.MAX_VALUE);

        long prefix = 0;
        long max = Long.MIN_VALUE;
        
        // initial prefix index 0 → remainder 0
        minPrefix[0] = 0;

        for(int i = 0; i < n; i++) {
            prefix += nums[i];
            int r = (i + 1) % k;

            if(minPrefix[r] != Long.MAX_VALUE) {
                max = Math.max(max, prefix - minPrefix[r]);
            }

            minPrefix[r] = Math.min(minPrefix[r], prefix);
        }

        return max;
    }
}

//POTD
