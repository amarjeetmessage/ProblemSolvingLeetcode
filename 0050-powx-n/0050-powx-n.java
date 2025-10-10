class Solution {
    public double myPow(double x, int n) {

        // \U0001f9e0 Base case: anything power 0 = 1
        if (n == 0) return 1.0;

        /* 
        \U0001f422 SLOW VERSION (Simple recursion) - Uncomment to test
        ------------------------------------------------------
        if (n < 0) return 1 / myPow(x, -n);  // handle negative power
        return x * myPow(x, n - 1);          // multiply x each time
        ------------------------------------------------------
        ⚠️ Time Complexity: O(n)
        This works but is too slow for large |n| (like 10^9)
        */

        // ⚡ FAST VERSION (Divide and Conquer Recursion)
        // ---------------------------------------------
        // Handle negative power
        if (n < 0) {
            x = 1 / x;
            // Edge case: n = Integer.MIN_VALUE (-2147483648)
            // Since -n overflows, adjust by adding 1 first
            if (n == Integer.MIN_VALUE) {
                return x * myPow(x, -(n + 1));
            }
            n = -n;
        }

        // Divide problem in half (Fast Exponentiation)
        double half = myPow(x, n / 2);

        // If n is even: x^n = (x^(n/2))^2
        // If n is odd:  x^n = (x^(n/2))^2 * x
        if (n % 2 == 0)
            return half * half;
        else
            return half * half * x;
    }
}
