import java.util.*;

class Solution {
    public long maximumTotalDamage(int[] power) {
        // 1. count frequencies
        Map<Integer, Long> cnt = new HashMap<>();
        for (int p : power) {
            cnt.put(p, cnt.getOrDefault(p, 0L) + 1L);
        }
        // 2. unique sorted list
        List<Integer> unique = new ArrayList<>(cnt.keySet());
        Collections.sort(unique);
        int m = unique.size();

        // 3. nxt array: for each i, the index to jump to if we take unique[i]
        int[] nxt = new int[m];
        for (int i = 0; i < m; i++) {
            long val = unique.get(i);
            long limit = val + 2;
            // binary search for first index > limit
            int lo = i + 1, hi = m;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if ((long)unique.get(mid) > limit) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }
            nxt[i] = lo;
        }

        // 4. dp memo
        long[] dp = new long[m + 1];  // dp[m] = 0
        for (int i = m - 1; i >= 0; i--) {
            // skip
            long skip = dp[i + 1];
            // take
            long damage = unique.get(i);
            long take = damage * cnt.get(unique.get(i)) + ( (nxt[i] <= m) ? dp[nxt[i]] : 0 );
            dp[i] = Math.max(skip, take);
        }

        return dp[0];
    }
}
