class Solution {
    public int minOperations(int[] nums, int x) {

        int n = nums.length;
        long total = 0;

        for (int num : nums) {
            total += num;
        }

        long target = total - x;

        // Need to remove everything
        if (target == 0) {
            return n;
        }

        int i = 0;
        long sum = 0;
        int maxLen = -1;

        for (int j = 0; j < n; j++) {

            sum += nums[j];

            while (i <= j && sum > target) {
                sum -= nums[i];
                i++;
            }

            if (sum == target) {
                maxLen = Math.max(maxLen, j - i + 1);
            }
        }

        if (maxLen == -1) {
            return -1;
        }

        return n - maxLen;
    }
}