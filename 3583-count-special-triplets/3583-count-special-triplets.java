class Solution {
    static final long MOD = 1_000_000_007;

    public int specialTriplets(int[] nums) {
        int n = nums.length;

        long ans = 0;

        // Count all occurrences first → right side
        Map<Integer, Long> rightCount = new HashMap<>();
        for (int x : nums)
            rightCount.put(x, rightCount.getOrDefault(x, 0L) + 1);

        // Left side count initially empty
        Map<Integer, Long> leftCount = new HashMap<>();

        for (int j = 0; j < n; j++) {
            int mid = nums[j];

            // Remove current element from right side (moving j)
            rightCount.put(mid, rightCount.get(mid) - 1);

            long target = (long) mid * 2;

            long left = leftCount.getOrDefault((int) target, 0L);
            long right = rightCount.getOrDefault((int) target, 0L);

            ans = (ans + (left * right) % MOD) % MOD;

            // Add current element to left side
            leftCount.put(mid, leftCount.getOrDefault(mid, 0L) + 1);
        }

        return (int) ans;
    }
}
//POTD