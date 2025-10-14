class Solution {
    public boolean hasIncreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        if (n < 2 * k) return false;

        // Step 1: Compute increasing sequence length
        int[] inc = new int[n];
        inc[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) inc[i] = inc[i - 1] + 1;
            else inc[i] = 1;
        }

        // Step 2: Check adjacent k-length increasing subarrays
        for (int a = 0; a + 2 * k <= n; a++) {
            int end1 = a + k - 1;
            int end2 = a + 2 * k - 1;

            // Check if both subarrays are strictly increasing
            if (inc[end1] >= k && inc[end2] >= k && nums[a + k] > nums[a + k - 1]) {
                return true;
            }
        }

        return false;
    }
}
