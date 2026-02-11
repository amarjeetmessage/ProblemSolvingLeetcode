class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int result = 0;
        
        // Important: prefix sum 0 at index -1
        map.put(0, -1);
        
        for (int i = 0; i < n; i++) {
            
            // Convert even → +1, odd → -1
            if ((nums[i] & 1) == 0)
                prefixSum += 1;
            else
                prefixSum -= 1;
            
            if (map.containsKey(prefixSum)) {
                result = Math.max(result, i - map.get(prefixSum));
            } else {
                // Store first occurrence only
                map.put(prefixSum, i);
            }
        }
        
        return result;
    }
}
//potd