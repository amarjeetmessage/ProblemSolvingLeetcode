class Solution {
    public boolean canJump(int[] nums) {
        int maxhead = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {  // <-- FIX: loop until i < n
            if (i > maxhead) {
                return false;
            }
            maxhead = Math.max(maxhead, i + nums[i]);
        }

        return true;
    }
}
