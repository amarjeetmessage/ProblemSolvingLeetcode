

//POTD 



class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int countOne = 0;
        
        // Step 1: Count 1's
        for (int x : nums) {
            if (x == 1) countOne++;
        }
        
        // If we already have 1's
        if (countOne > 0) return n - countOne;
        
        // Step 2: Find shortest subarray with gcd == 1
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int g = nums[i];
            for (int j = i + 1; j < n; j++) {
                g = gcd(g, nums[j]);
                if (g == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break; // stop when gcd becomes 1
                }
            }
        }
        
        // Step 3: If no subarray found
        if (minLen == Integer.MAX_VALUE) return -1;
        
        // Step 4: Total operations = (minLen - 1) + (n - 1)
        return minLen - 1 + n - 1;
    }

    // Helper gcd function
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
