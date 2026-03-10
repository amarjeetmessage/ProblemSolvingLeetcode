class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int ans = 1;
        int ans2 = 1;
        for(int i = nums.length - 1; i>nums.length -4; i--) {
            ans = ans * nums[i];
        }
        
        ans2 = nums[0] * nums[1] * nums[nums.length -1];
        return Math.max(ans, ans2);
    }
}