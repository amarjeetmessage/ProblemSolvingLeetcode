class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        
        int n = arr.length;
        int[] best = new int[n];

        Arrays.fill(best, Integer.MAX_VALUE);

        int left = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {

            sum += arr[right];

            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            if (sum == target) {

                int currLen = right - left + 1;

                // Current subarray ke left mein koi valid
                // subarray available hai?
                if (left > 0 && best[left - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, currLen + best[left - 1]);
                }

                minLen = Math.min(minLen, currLen);
            }

            // index right tak ki best valid subarray
            best[right] = minLen;
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}