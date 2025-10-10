class Solution {
    // Constant modulus (10^9 + 7)
    private static final long MOD = 1000000007;

    public int countGoodNumbers(long n) {
        // Count of even indices = (n + 1) / 2
        // Count of odd indices  = n / 2
        long evenCount = (n + 1) / 2;
        long oddCount = n / 2;

        // Using fast modular exponentiation (recursive)
        long evenWays = power(5, evenCount);
        long oddWays = power(4, oddCount);

        // Multiply and take mod
        return (int) ((evenWays * oddWays) % MOD);
    }

    // Recursive fast power function: (x^y) % MOD
    private long power(long x, long y) {
        // Base case
        if (y == 0) return 1;

        // Recursive divide
        long half = power(x, y / 2);

        // Combine results
        long result = (half * half) % MOD;

        // If y is odd, multiply one more x
        if (y % 2 == 1) {
            result = (result * x) % MOD;
        }

        return result;
    }
}
