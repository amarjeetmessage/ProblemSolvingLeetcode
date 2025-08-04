class Solution {
    public boolean isPowerOfThree(int n) {
        // Base case: 1 is 3^0, so it’s valid
        if (n == 1) {
            return true;
        }
        // If n <= 0 or n is odd, it cannot be a power of Three (except 1)
        if (n <= 0 || n % 3 != 0) {
            return false;
        }
        // Recursive step: divide by 3 and check again
        return isPowerOfThree(n / 3);
    }
}
