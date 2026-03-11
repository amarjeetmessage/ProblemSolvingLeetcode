// class Solution {
//     public int uniquePathsWithObstacles(int[][] grid) {

//         int m = grid.length;
//         int n = grid[0].length;

//         int[][] dp = new int[m+1][n+1];

//         for(int[] row : dp) {
//             Arrays.fill(row, -1);
//         }

//         return solve(0,0,m,n,grid,dp);
//     }

//     public int solve(int i, int j, int m, int n, int[][] grid,int[][] dp){

//         if(i >= m || j >= n) return 0;

//         if(grid[i][j] == 1) return 0;//this line is extra as compared to unique path 1;

//         if(i == m-1 && j == n-1) return 1;

//         if(dp[i][j] != -1) {
//             return dp[i][j];
//         }

//         int right = solve(i, j+1, m, n, grid,dp);
//         int down = solve(i+1, j, m, n, grid,dp);

//         return dp[i][j] = right + down;
//     }
// }







// class Solution {
//     public int uniquePathsWithObstacles(int[][] grid) {

//         int m = grid.length;
//         int n = grid[0].length;

//         int[][] dp = new int[m][n];

//         // start cell
//         if(grid[0][0] == 1) return 0;
//         dp[0][0] = 1;

//         for(int i = 0; i < m; i++){
//             for(int j = 0; j < n; j++){

//                 if(grid[i][j] == 1){
//                     dp[i][j] = 0;
//                     continue;
//                 }

//                 if(i > 0)
//                     dp[i][j] += dp[i-1][j];

//                 if(j > 0)
//                     dp[i][j] += dp[i][j-1];
//             }
//         }

//         return dp[m-1][n-1];
//     }
// }













class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m + 1][n + 1];

        if (obstacleGrid[m - 1][n - 1] == 1) {
            return 0;//b/c not possible to reach at destination
        }

        // for(int i=0;i<=m;i++){
        //     dp[i][n]=0;
        // }
        // for(int j=0;j<=n;j++){
        //     dp[m][j]=0;
        // }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = 1;
                    continue;
                }

                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }

        return dp[0][0];
    }
}