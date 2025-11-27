class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long max = 0;
        for(int i = 0; i<=nums.length - k; i++) {
            Set<Integer> set = new HashSet<>();
            boolean isDup = false;
            long sum = 0;


            for(int j = i; j<i+k; j++) {
                if(set.contains(nums[j])) {
                    isDup = true;
                    break;
                }
                set.add(nums[j]);

                sum = sum + nums[j];
            }
            if(!isDup) {
                max = Math.max(max, sum);
            }
            
        }
        return max;
    }
}