class Solution {

    // Approach 1: Brute Force (O(n^2)) - simple but slow
    /*
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int prod = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) prod *= nums[j];
            }
            result[i] = prod;
        }
        return result;
    }
    */

    // Approach 2: Using Division (O(n)) - only works if no zeros
    /*
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int total = 1;
        for (int num : nums) total *= num;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) result[i] = total / nums[i];
        return result;
    }
    */

    // Approach 3: Prefix & Suffix Arrays (O(n), O(n) space)
    /*
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] result = new int[n];

        left[0] = 1;
        for (int i = 1; i < n; i++) left[i] = left[i-1] * nums[i-1];

        right[n-1] = 1;
        for (int i = n-2; i >=0; i--) right[i] = right[i+1] * nums[i+1];

        for (int i = 0; i < n; i++) result[i] = left[i] * right[i];
        return result;
    }
    */

    // Approach 4: Optimized O(1) space ✅ (Recommended)
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Step 1: Fill result with left products
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i-1] * nums[i-1];
        }

        // Step 2: Multiply with right products dynamically
        int rightProduct = 1;
        for (int i = n-1; i >=0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return result;
    }
}
