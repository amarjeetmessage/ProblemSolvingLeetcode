class Solution {
    public int hammingWeight(int n) {
        int count = 0; // Count of set bits (1's)

        while (n != 0) {
            // Check if last bit is 1
            if ((n & 1) == 1) {
                count++; // If LSB is 1, increase count
            }

            // Right shift n by 1 to check next bit
            n = n >>> 1; // Use unsigned right shift to handle negative numbers correctly
        }

        return count; // Return total number of 1's
    }
}
