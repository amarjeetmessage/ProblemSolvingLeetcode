class Solution {
    public int minPathSum(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for(int i = 0; i<dp.length; i++) {
            Arrays.fill(dp[i] , -1);
        }

        return solve(grid, m,n, 0,0,dp);
    }
    public static int solve(int[][] grid, int m, int n, int i, int j,int[][] dp) {
        if(i == m-1 && j == n-1) return grid[i][j];
        if(i > m-1 || j > n-1) return Integer.MAX_VALUE;

        if(dp[i][j] != -1) {
            return dp[i][j];
        }



        //recursive call
        int a = solve(grid, m,n, i+1,j,dp);
        int b = solve(grid, m, n, i, j+1,dp);

        dp[i][j] =  Math.min(a,b) + grid[i][j];
        return dp[i][j];
    }
}