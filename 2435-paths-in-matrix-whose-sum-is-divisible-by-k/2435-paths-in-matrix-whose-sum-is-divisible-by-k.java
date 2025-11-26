class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int mod = 1000000007;

        int[][] dp = new int[n][k];
        dp[0][grid[0][0] % k] = 1;

        for(int i = 0; i < m; i++) {
            int[][] newDp = new int[n][k]; // for current row updates

            for(int j = 0; j < n; j++) {
                for(int r = 0; r < k; r++) {
                    if(dp[j][r] != 0) {
                        int newR = (r + grid[i][j]) % k;
                        newDp[j][newR] = (newDp[j][newR] + dp[j][r]) % mod;
                    }
                    if(j > 0 && newDp[j-1][r] != 0) {
                        int newR = (r + grid[i][j]) % k;
                        newDp[j][newR] = (newDp[j][newR] + newDp[j-1][r]) % mod;
                    }
                }
            }

            dp = newDp; // move to next row
        }

        return dp[n-1][0];
    }
}
