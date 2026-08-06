// class Solution {

//     public int minimumDifference(int[] nums) {
//         int n = nums.length;
//         return solve(0, 0, 0, n / 2, n / 2, nums);
//     }

//     public int solve(int i, int sum1, int sum2, int n1, int n2, int[] nums) {

//         // Base Case
//         if (i == nums.length) {

//             // Both arrays have exactly n elements
//             if (n1 == 0 && n2 == 0) {
//                 return Math.abs(sum1 - sum2);
//             }

//             // Invalid partition
//             return Integer.MAX_VALUE;
//         }

//         int ans = Integer.MAX_VALUE;

//         // Put current element into Array1
//         if (n1 > 0) {
//             ans = Math.min(ans,solve(i + 1, sum1 + nums[i], sum2, n1 - 1, n2, nums));
//         }

//         // Put current element into Array2
//         if (n2 > 0) {
//             ans = Math.min(ans,solve(i + 1, sum1 , sum2 + nums[i], n1 , n2-1, nums));
//         }

//         return ans;
//     }
// }

import java.util.*;

class Solution {

    public int minimumDifference(int[] nums) {

        int n = nums.length / 2;

        List<Integer>[] left = new ArrayList[n + 1];
        List<Integer>[] right = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            left[i] = new ArrayList<>();
            right[i] = new ArrayList<>();
        }

        dfs(nums, 0, n, 0, 0, left);
        dfs(nums, n, 2 * n, 0, 0, right);

        for (int i = 0; i <= n; i++) {
            Collections.sort(right[i]);
        }

        int total = 0;
        for (int x : nums) total += x;

        int ans = Integer.MAX_VALUE;

        for (int leftCount = 0; leftCount <= n; leftCount++) {

            int rightCount = n - leftCount;

            for (int leftSum : left[leftCount]) {

                int target = total / 2 - leftSum;

                List<Integer> list = right[rightCount];

                int idx = Collections.binarySearch(list, target);

                if (idx < 0)
                    idx = -idx - 1;

                if (idx < list.size()) {
                    int chosen = leftSum + list.get(idx);
                    ans = Math.min(ans,
                            Math.abs(total - 2 * chosen));
                }

                if (idx > 0) {
                    int chosen = leftSum + list.get(idx - 1);
                    ans = Math.min(ans,
                            Math.abs(total - 2 * chosen));
                }
            }
        }

        return ans;
    }

    void dfs(int[] nums,
             int start,
             int end,
             int picked,
             int sum,
             List<Integer>[] store) {

        if (start == end) {
            store[picked].add(sum);
            return;
        }

        dfs(nums,
                start + 1,
                end,
                picked,
                sum,
                store);

        dfs(nums,
                start + 1,
                end,
                picked + 1,
                sum + nums[start],
                store);
    }
}