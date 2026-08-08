class Solution {

    int MOD = 1000000007;

    public int dfs(int r, int c, int[][] grid, int[][] dp) {

        if (dp[r][c] != -1) {
            return dp[r][c];
        }

        long result = 1; // Path consisting of only the current cell

        int rows = grid.length;
        int cols = grid[0].length;

        // Up
        if (r - 1 >= 0 && grid[r - 1][c] > grid[r][c]) {
            result += dfs(r - 1, c, grid, dp);
        }

        // Down
        if (r + 1 < rows && grid[r + 1][c] > grid[r][c]) {
            result += dfs(r + 1, c, grid, dp);
        }

        // Left
        if (c - 1 >= 0 && grid[r][c - 1] > grid[r][c]) {
            result += dfs(r, c - 1, grid, dp);
        }

        // Right
        if (c + 1 < cols && grid[r][c + 1] > grid[r][c]) {
            result += dfs(r, c + 1, grid, dp);
        }

        dp[r][c] = (int) (result % MOD);
        return dp[r][c];
    }

    public int countPaths(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            Arrays.fill(dp[i], -1);
        }

        long totalPaths = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                totalPaths += dfs(i, j, grid, dp);
                totalPaths %= MOD;
            }
        }

        return (int) totalPaths;
    }
}