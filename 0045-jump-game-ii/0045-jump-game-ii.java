// LeetCode 45: Jump Game II
// Different approaches included (commented)
// Optimal Greedy approach is active for submission

import java.util.*;

class Solution {

    // ---------------------------
    // Approach 1: Greedy (Optimal O(n)) ✅ ACTIVE
    // ---------------------------
    public int jump(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0; // already at last index

        int jumps = 0;         // number of jumps made
        int currentEnd = 0;    // end of current jump range
        int farthest = 0;      // farthest index we can reach

        // iterate until second last index (no need to jump from last index)
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]); // best reach from i

            if (i == currentEnd) { // must jump now
                jumps++;
                currentEnd = farthest;
                if (currentEnd >= n - 1) break; // already can reach end
            }
        }
        return jumps;
    }

    /* ---------------------------
    // Approach 2: BFS (Level-order) - O(n^2) worst case
    // ---------------------------
    public int jump(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        boolean[] visited = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        visited[0] = true;
        int jumps = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int idx = q.poll();
                int maxReach = Math.min(n - 1, idx + nums[idx]);
                for (int next = idx + 1; next <= maxReach; next++) {
                    if (next == n - 1) return jumps + 1;
                    if (!visited[next]) {
                        visited[next] = true;
                        q.add(next);
                    }
                }
            }
            jumps++;
        }
        return -1;
    }
    */

    /* ---------------------------
    // Approach 3: Bottom-up DP (O(n^2))
    // ---------------------------
    public int jump(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n - 1];
    }
    */

    /* ---------------------------
    // Approach 4: Top-down DFS + Memo (O(n^2) worst case)
    // ---------------------------
    private static final int INF = Integer.MAX_VALUE / 2;
    public int jump(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return dfs(nums, 0, memo);
    }
    private int dfs(int[] nums, int pos, int[] memo) {
        int n = nums.length;
        if (pos >= n - 1) return 0;
        if (memo[pos] != -1) return memo[pos];
        int best = INF;
        for (int step = 1; step <= nums[pos]; step++) {
            int next = pos + step;
            if (next < n) {
                int sub = dfs(nums, next, memo);
                if (sub < INF) best = Math.min(best, 1 + sub);
            }
        }
        return memo[pos] = best;
    }
    */

    /* ---------------------------
    // Approach 5: Reverse Greedy (O(n^2) worst-case)
    // ---------------------------
    public int jump(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;
        int target = n - 1, jumps = 0;
        while (target > 0) {
            int found = -1;
            for (int i = 0; i < target; i++) {
                if (i + nums[i] >= target) {
                    found = i;
                    break;
                }
            }
            if (found == -1) return -1;
            target = found;
            jumps++;
        }
        return jumps;
    }
    */
}
