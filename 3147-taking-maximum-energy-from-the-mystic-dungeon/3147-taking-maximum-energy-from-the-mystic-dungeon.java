class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int max = Integer.MIN_VALUE;

        // We will check sums starting from each of the last k elements
        for (int i = 0; i < k; i++) {
            int sum = 0;

            // Start from the last element - i, move backwards in steps of k
            for (int j = n - 1 - i; j >= 0; j -= k) {
                sum += energy[j];
                max = Math.max(max, sum);
            }
        }

        return max;
    }
}
