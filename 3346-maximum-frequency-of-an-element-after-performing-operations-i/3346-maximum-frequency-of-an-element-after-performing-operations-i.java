import java.util.Arrays;
//POTD
class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        int maxFreq = 1;

        for (int right = 0; right < n; right++) {
            // shrink window until it fits within 2*k range
            while (nums[right] - nums[left] > 2 * k) {
                left++;
            }

            int windowSize = right - left + 1;

            // We can only perform numOperations total
            int possibleFreq = Math.min(windowSize, numOperations + 1);

            maxFreq = Math.max(maxFreq, possibleFreq);
        }

        return maxFreq;
    }
}
