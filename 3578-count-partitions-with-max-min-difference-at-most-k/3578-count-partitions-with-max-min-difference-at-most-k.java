class Solution {
    static final int MOD = 1_000_000_007;

    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        long[] dp = new long[n + 1];
        long[] prefix = new long[n + 1];

        dp[0] = 1;
        prefix[0] = 1;

        Deque<Integer> maxDQ = new ArrayDeque<>();
        Deque<Integer> minDQ = new ArrayDeque<>();

        int l = 0;

        for (int i = 1; i <= n; i++) {
            int val = nums[i - 1];

            // Maintain max deque
            while (!maxDQ.isEmpty() && nums[maxDQ.peekLast()] <= val)
                maxDQ.pollLast();
            maxDQ.offerLast(i - 1);

            // Maintain min deque
            while (!minDQ.isEmpty() && nums[minDQ.peekLast()] >= val)
                minDQ.pollLast();
            minDQ.offerLast(i - 1);

            // Shrink window if invalid
            while (nums[maxDQ.peekFirst()] - nums[minDQ.peekFirst()] > k) {
                l++;
                if (maxDQ.peekFirst() < l) maxDQ.pollFirst();
                if (minDQ.peekFirst() < l) minDQ.pollFirst();
            }

            // dp transition using prefix sum
            dp[i] = prefix[i - 1];
            if (l > 0) dp[i] = (dp[i] - prefix[l - 1] + MOD) % MOD;

            prefix[i] = (prefix[i - 1] + dp[i]) % MOD;
        }

        return (int) dp[n];
    }
}
//POTD
