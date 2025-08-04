class Solution {
    public boolean isPowerOfFour(int n) {
        // Base case: 1 is 4^0, so it’s valid
        if (n == 1) {
            return true;
        }
        // If n <= 0 or n is odd, it cannot be a power of Four (except 1)
        if (n <= 0 || n % 4 != 0) {
            return false;
        }
        // Recursive step: divide by 4 and check again
        return isPowerOfFour(n / 4);
    }
}
