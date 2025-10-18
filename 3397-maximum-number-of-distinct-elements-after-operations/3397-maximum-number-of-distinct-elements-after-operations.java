import java.util.*;
//POTD
class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums); // Step 1: Sort the array
        long prev = Long.MIN_VALUE; // To handle large negative values safely
        int count = 0;

        for (int x : nums) {
            long low = (long) x - k;
            long high = (long) x + k;
            long cur = Math.max(low, prev + 1); // next distinct number

            if (cur <= high) {
                count++;
                prev = cur; // update previous assigned number
            }
            // else: skip if no space for new distinct value
        }

        return count;
    }
}
