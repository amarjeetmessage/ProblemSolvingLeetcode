class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;
        // S_prev[i] = S_i(j-1) for i = 0..n (prefix sums for previous job)
        long[] S_prev = new long[n + 1];
        long tPrev = 0L; // t[j-1]

        for (int j = 0; j < m; ++j) {
            // Build prefix sums for current job j: S_curr[i] = sum_{a=1..i} p[a][j]
            long[] S_curr = new long[n + 1];
            for (int i = 1; i <= n; ++i) {
                S_curr[i] = S_curr[i - 1] + (long) skill[i - 1] * (long) mana[j];
            }

            if (j == 0) {
                tPrev = 0L; // first potion starts at time 0
            } else {
                long nextT = Long.MIN_VALUE;
                // t[j] = max over i of (t[j-1] + S_prev[i] - S_curr[i-1])
                for (int i = 1; i <= n; ++i) {
                    long candidate = tPrev + S_prev[i] - S_curr[i - 1];
                    if (candidate > nextT) nextT = candidate;
                }
                tPrev = nextT;
            }

            // swap: current column becomes previous for next iteration
            S_prev = S_curr;
        }

        // makespan = t[m-1] + total processing time of last potion (S_n(m-1) = S_prev[n])
        return tPrev + S_prev[n];
    }
}
