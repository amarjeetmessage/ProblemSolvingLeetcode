import java.util.*;

class Solution {
    public int missingInteger(int[] nums) {

        int n = nums.length;

        // Step 1: find sum of longest sequential prefix
        int sum = nums[0];

        for(int i = 1; i < n; i++) {
            if(nums[i] == nums[i-1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }

        // Step 2: store elements in set for fast lookup
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }

        // Step 3: find smallest missing number >= sum
        int x = sum;
        while(set.contains(x)) {
            x++;
        }

        return x;
    }
}