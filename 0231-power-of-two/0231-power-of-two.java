class Solution {
    public boolean isPowerOfTwo(int n) {
        // Base case: 1 is 2^0, so it’s valid
        if (n == 1) {
            return true;
        }
        // If n <= 0 or n is odd, it cannot be a power of two (except 1)
        if (n <= 0 || n % 2 != 0) {
            return false;
        }
        // Recursive step: divide by 2 and check again
        return isPowerOfTwo(n / 2);
    }
}
