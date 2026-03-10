class Solution {
    public long maxProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;

        long ans1, ans2, ans3;

        ans1 = Math.abs((long)nums[len-1] * nums[len-2]) * 100000;
        ans2 = Math.abs((long)nums[0] * nums[1]) * 100000;
        ans3 = Math.abs((long)nums[0] * nums[len-1]) * 100000;

        return Math.max(ans3, Math.max(ans1, ans2));
    }
}