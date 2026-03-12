// class Solution {
//     public int minFallingPathSum(int[][] grid) {
// /
//         int n = grid.length;

//         int mn = Integer.MAX_VALUE;
//         for(int j = 0; j<n; j++) {
//             int ans = solve(grid, n, 0 ,j);
//             mn = Math.min(mn, ans);
//         }
//         return mn;
//     }
//     public static int solve(int[][] grid, int n, int i , int j) {
//         if(j < 0 || j > n-1) return Integer.MAX_VALUE;
//         if(i == n-1) return grid[i][j];

//         //RECURSIVE CALL
//         int a = solve(grid, n,i+1,j-1);
//         int b = solve(grid, n,i+1,j+1);
//         int c = solve(grid, n,i+1,j);

//        return Math.min(c,Math.min(a,b)) + grid[i][j];
       
    
//     }
// }

//ABOVE CODE OF MINIMUM FALLING PATH SUM 1




// class Solution {

//     public int minFallingPathSum(int[][] grid) {
//         int n = grid.length;
//         return solve(grid, 0, -1, n);
//     }

//     public int solve(int[][] grid, int row, int prevCol, int n) {

//         if(row == n) return 0;

//         int min = Integer.MAX_VALUE;

//         for(int col = 0; col < n; col++) {

//             if(col == prevCol) continue;

//             int val = grid[row][col] + solve(grid, row + 1, col, n);

//             min = Math.min(min, val);
//         }

//         return min;
//     }
// }





// //EVEN MEMOIZATION CODE WILL ALSO ALSO SHOW "TIME LIMIT EXCEEDED"
// class Solution {

//     public int minFallingPathSum(int[][] grid) {
//         int n = grid.length;

//         int[][] dp = new int[n][n + 1];

//         for(int[] row : dp) Arrays.fill(row, -1);

//         return solve(grid, 0, -1, n, dp);
//     }

//     public int solve(int[][] grid, int row, int prevCol, int n, int[][] dp) {

//         if(row == n) return 0;

//         if(dp[row][prevCol + 1] != -1) 
//             return dp[row][prevCol + 1];

//         int min = Integer.MAX_VALUE;

//         for(int col = 0; col < n; col++) {

//             if(col == prevCol) continue;

//             int val = grid[row][col] + solve(grid, row + 1, col, n, dp);

//             min = Math.min(min, val);
//         }

//         return dp[row][prevCol + 1] = min;
//     }
// }





class Solution {

    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;

        int[][] dp = new int[n][n];

        // base case: last row
        for(int j = 0; j < n; j++) {
            dp[n-1][j] = grid[n-1][j];
        }

        // fill from bottom to top
        for(int i = n-2; i >= 0; i--) {
            for(int j = 0; j < n; j++) {

                int min = Integer.MAX_VALUE;

                for(int k = 0; k < n; k++) {
                    if(k == j) continue;

                    min = Math.min(min, dp[i+1][k]);
                }

                dp[i][j] = grid[i][j] + min;
            }
        }

        int ans = Integer.MAX_VALUE;

        for(int j = 0; j < n; j++) {
            ans = Math.min(ans, dp[0][j]);
        }

        return ans;
    }
}