class Solution {
    public int[] countTasks(int[] tasks, int[] shifts) {
        int n = tasks.length;
        int m = shifts.length;

        int[] ans = new int[m];

        long[] prefix = new long[n];
        prefix[0] = tasks[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + tasks[i];
        }

        long total = prefix[n - 1];
        long completed = 0;

        for (int i = 0; i < m; i++) {
            completed += shifts[i];

            if (completed >= total) {
                ans[i] = 0;
                completed = 0;
            } else {
                int idx = upperBound(prefix, completed);
                ans[i] = n - idx;
            }
        }

        return ans;
    }

    private int upperBound(long[] prefix, long target) {
        int low = 0;
        int high = prefix.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (prefix[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}