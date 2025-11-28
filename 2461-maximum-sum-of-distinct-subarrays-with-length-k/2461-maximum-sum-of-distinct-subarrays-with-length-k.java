// class Solution {
//     public long maximumSubarraySum(int[] nums, int k) {
//         long max = 0;
//         for(int i = 0; i<=nums.length - k; i++) {
//             Set<Integer> set = new HashSet<>();
//             boolean isDup = false;
//             long sum = 0;


//             for(int j = i; j<i+k; j++) {
//                 if(set.contains(nums[j])) {
//                     isDup = true;
//                     break;
//                 }
//                 set.add(nums[j]);

//                 sum = sum + nums[j];
//             }
//             if(!isDup) {
//                 max = Math.max(max, sum);
//             }
            
//         }
//         return max;
//     }
// }


class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        long sum = 0;
        long max = 0;
        int left = 0;

        for(int right = 0; right < nums.length; right++) {
            // Expand window
            sum += nums[right];
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);

            // If size > k, shrink from left
            if(right - left + 1 > k) {
                freq.put(nums[left], freq.get(nums[left]) - 1);
                if(freq.get(nums[left]) == 0) {
                    freq.remove(nums[left]);
                }
                sum -= nums[left];
                left++;
            }

            // Check if window is valid (size k & all unique)
            if(right - left + 1 == k && freq.size() == k) {
                max = Math.max(max, sum);
            }
        }

        return max;
    }
}
