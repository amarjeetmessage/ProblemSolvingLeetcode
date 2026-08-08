// import java.util.*;

// // ============================================================
// // LEETCODE 1463 - CHERRY PICKUP II
// // APPROACH 1 : RECURSION
// //
// // Robot 1 starts at (0,0)
// // Robot 2 starts at (0,m-1)
// //
// // Each robot can move to:
// //      Down Left   (r+1,c-1)
// //      Down        (r+1,c)
// //      Down Right  (r+1,c+1)
// //
// // Total 9 combinations
// //
// // LL  LD  LR
// // DL  DD  DR
// // RL  RD  RR
// //
// // State
// // solve(row, col1, col2)
// //
// // Time  : O(9^n)
// // Space : O(n)
// // ============================================================

// class Solution {

//     int solve(int row,
//               int col1,
//               int col2,
//               int[][] grid) {

//         int n = grid.length;
//         int m = grid[0].length;

//         // ===========================
//         // Boundary
//         // ===========================

//         if (col1 < 0 || col1 >= m ||
//             col2 < 0 || col2 >= m)
//             return Integer.MIN_VALUE;

//         // ===========================
//         // Last Row
//         // ===========================

//         if (row == n - 1) {

//             if (col1 == col2)
//                 return grid[row][col1];

//             return grid[row][col1] + grid[row][col2];
//         }

//         // ===========================
//         // Current Cherries
//         // ===========================

//         int cherries = grid[row][col1];

//         if (col1 != col2)
//             cherries += grid[row][col2];

//         // ===========================
//         // 9 Possible Moves
//         // ===========================

//         int LL = solve(row + 1, col1 - 1, col2 - 1, grid);

//         int LD = solve(row + 1, col1 - 1, col2, grid);

//         int LR = solve(row + 1, col1 - 1, col2 + 1, grid);

//         int DL = solve(row + 1, col1, col2 - 1, grid);

//         int DD = solve(row + 1, col1, col2, grid);

//         int DR = solve(row + 1, col1, col2 + 1, grid);

//         int RL = solve(row + 1, col1 + 1, col2 - 1, grid);

//         int RD = solve(row + 1, col1 + 1, col2, grid);

//         int RR = solve(row + 1, col1 + 1, col2 + 1, grid);

//         int best = Math.max(
//                 Math.max(Math.max(LL, LD), Math.max(LR, DL)),
//                 Math.max(
//                         Math.max(DD, DR),
//                         Math.max(RL, Math.max(RD, RR))
//                 )
//         );

//         return cherries + best;
//     }

//     public int cherryPickup(int[][] grid) {

//         int m = grid[0].length;

//         return solve(0, 0, m - 1, grid);
//     }
// }






import java.util.*;

// ============================================================
// LEETCODE 1463 - CHERRY PICKUP II
// APPROACH 2 : MEMOIZATION (3D DP)
//
// State:
// dp[row][col1][col2]
//
// row  -> Current Row
// col1 -> Robot 1 Column
// col2 -> Robot 2 Column
//
// Both robots are always on the same row.
//
// Time  : O(n * m * m * 9)
//       ≈ O(n * m²)
//
// Space : O(n * m²)
// ============================================================

class Solution {

    int solve(int row,
              int col1,
              int col2,
              int[][] grid,
              int[][][] dp) {

        int n = grid.length;
        int m = grid[0].length;

        // ===========================
        // Boundary
        // ===========================

        if (col1 < 0 || col1 >= m ||
            col2 < 0 || col2 >= m)
            return Integer.MIN_VALUE;

        // ===========================
        // Last Row
        // ===========================

        if (row == n - 1) {

            if (col1 == col2)
                return grid[row][col1];

            return grid[row][col1] + grid[row][col2];
        }

        // ===========================
        // Memoization
        // ===========================

        if (dp[row][col1][col2] != -1)
            return dp[row][col1][col2];

        // ===========================
        // Current Cherries
        // ===========================

        int cherries = grid[row][col1];

        if (col1 != col2)
            cherries += grid[row][col2];

        // ===========================
        // 9 Possible Moves
        // ===========================

        int LL = solve(row + 1, col1 - 1, col2 - 1, grid, dp);

        int LD = solve(row + 1, col1 - 1, col2, grid, dp);

        int LR = solve(row + 1, col1 - 1, col2 + 1, grid, dp);

        int DL = solve(row + 1, col1, col2 - 1, grid, dp);

        int DD = solve(row + 1, col1, col2, grid, dp);

        int DR = solve(row + 1, col1, col2 + 1, grid, dp);

        int RL = solve(row + 1, col1 + 1, col2 - 1, grid, dp);

        int RD = solve(row + 1, col1 + 1, col2, grid, dp);

        int RR = solve(row + 1, col1 + 1, col2 + 1, grid, dp);

        int best = Math.max(
                Math.max(Math.max(LL, LD), Math.max(LR, DL)),
                Math.max(
                        Math.max(DD, DR),
                        Math.max(RL, Math.max(RD, RR))
                )
        );

        dp[row][col1][col2] = cherries + best;

        return dp[row][col1][col2];
    }

    public int cherryPickup(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][m];

        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, -1);
            }
        }

        return solve(0, 0, m - 1, grid, dp);
    }
}