class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m+1][n+1];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0,0,m,n,grid,dp);
    }

    public int solve(int i, int j, int m, int n, int[][] grid,int[][] dp){

        if(i >= m || j >= n) return 0;

        if(grid[i][j] == 1) return 0;//this line is extra as compared to unique path 1;

        if(i == m-1 && j == n-1) return 1;

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int right = solve(i, j+1, m, n, grid,dp);
        int down = solve(i+1, j, m, n, grid,dp);

        return dp[i][j] = right + down;
    }
}