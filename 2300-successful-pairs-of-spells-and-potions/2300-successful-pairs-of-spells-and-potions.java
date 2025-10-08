import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int m = potions.length;
        int n = spells.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; ++i) {
            long s = spells[i];
            if (s == 0) {
                ans[i] = (success <= 0) ? m : 0;
                continue;
            }
            // need = ceil(success / s)
            long need = (success + s - 1) / s; // works with long
            int idx = lowerBound(potions, need);
            ans[i] = m - idx;
        }
        return ans;
    }

    // lower_bound: first index with value >= target
    private int lowerBound(int[] arr, long target) {
        int l = 0, r = arr.length; // [l, r)
        while (l < r) {
            int mid = l + (r - l) / 2;
            if ((long)arr[mid] < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
