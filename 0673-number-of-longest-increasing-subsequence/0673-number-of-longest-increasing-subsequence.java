class Solution {
    
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        
        int[] len = new int[n];
        int[] count = new int[n];
        
        int maxLen = 0;
        
        for (int i = 0; i < n; i++) {
            solve(nums, i, len, count);
            maxLen = Math.max(maxLen, len[i]);
        }
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (len[i] == maxLen) {
                ans += count[i];
            }
        }
        
        
        return ans;
    }
    
    private void solve(int[] nums, int i, int[] len, int[] count) {
        
        // base case
        if (len[i] != 0) return;  // already computed
        
        len[i] = 1;
        count[i] = 1;
        
        for (int j = 0; j < i; j++) {
            solve(nums, j, len, count);
            
            if (nums[j] < nums[i]) {
                
                if (len[j] + 1 > len[i]) {
                    len[i] = len[j] + 1;
                    count[i] = count[j];
                } 
                else if (len[j] + 1 == len[i]) {
                    count[i] += count[j];
                }
            }
        }
    }
}