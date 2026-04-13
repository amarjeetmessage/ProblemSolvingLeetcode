class Solution {
    public int minOperations(int[] nums) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];

            // Even index → need PRIME
            if (i % 2 == 0) {
                if (!isPrime(val)) {
                    int target = nextPrime(val);
                    result += (target - val);
                }
            }
            // Odd index → need NON-PRIME
            else {
                if (isPrime(val)) {
                    int target = nextNonPrime(val);
                    result += (target - val);
                }
            }
        }

        return result;
    }

    boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    int nextPrime(int n) {
        while (!isPrime(n)) {
            n++;
        }
        return n;
    }

    int nextNonPrime(int n) {
        while (isPrime(n)) {
            n++;
        }
        return n;
    }
}