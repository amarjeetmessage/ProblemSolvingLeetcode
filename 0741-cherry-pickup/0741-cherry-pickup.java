// class Solution {

//     int findMaximumCherryPick(int r1, int c1,
//                               int r2, int c2,
//                               int n,
//                               int[][] grid) {

//         // Boundary check
//         if (r1 >= n || r2 >= n || c1 >= n || c2 >= n)
//             return Integer.MIN_VALUE;

//         // Thorn cell
//         if (grid[r1][c1] == -1 || grid[r2][c2] == -1)
//             return Integer.MIN_VALUE;

//         // Destination
//         if (r1 == n - 1 && c1 == n - 1)
//             return grid[n - 1][n - 1];

//         int cherries = grid[r1][c1];

//         // Don't count twice if both persons are on same cell
//         if (r1 != r2 || c1 != c2)
//             cherries += grid[r2][c2];

//         // DD, DR, RD, RR
//         int DD = findMaximumCherryPick(r1 + 1, c1,
//                                        r2 + 1, c2,
//                                        n, grid);

//         int DR = findMaximumCherryPick(r1 + 1, c1,
//                                        r2, c2 + 1,
//                                        n, grid);

//         int RD = findMaximumCherryPick(r1, c1 + 1,
//                                        r2 + 1, c2,
//                                        n, grid);

//         int RR = findMaximumCherryPick(r1, c1 + 1,
//                                        r2, c2 + 1,
//                                        n, grid);

//         int pick = Math.max(
//                         Math.max(DD, DR),
//                         Math.max(RD, RR));

//         if (pick == Integer.MIN_VALUE)
//             return Integer.MIN_VALUE;

//         return cherries + pick;
//     }

//     public int cherryPickup(int[][] grid) {

//         int n = grid.length;

//         int answer = findMaximumCherryPick(
//                 0, 0,
//                 0, 0,
//                 n, grid);

//         return Math.max(0, answer);
//     }
// }




// class Solution {

//     int findMaximumCherryPick(int r1, int c1,
//             int r2,
//             int n,
//             int[][] grid) {

//         // for avoiding 4d dp if we have r1,c1 and r2 then we can also find c2 directly 
//         int c2 = (r1 + c1) - r2;

//         // Boundary check
//         if (r1 >= n || r2 >= n || c1 >= n || c2 >= n
//                 || c2 < 0)
//             return Integer.MIN_VALUE;

//         // Thorn cell
//         if (grid[r1][c1] == -1 || grid[r2][c2] == -1)
//             return Integer.MIN_VALUE;

//         // Destination
//         if (r1 == n - 1 && c1 == n - 1)
//             return grid[n - 1][n - 1];

//         int cherries = grid[r1][c1];

//         // Don't count the same cell twice
//         if (r1 != r2 || c1 != c2)
//             cherries += grid[r2][c2];

//         // DD
//         int DD = findMaximumCherryPick(r1 + 1, c1,
//                 r2 + 1,
//                 n, grid);

//         // DR
//         int DR = findMaximumCherryPick(r1 + 1, c1,
//                 r2,
//                 n, grid);

//         // RD
//         int RD = findMaximumCherryPick(r1, c1 + 1,
//                 r2 + 1,
//                 n, grid);

//         // RR
//         int RR = findMaximumCherryPick(r1, c1 + 1,
//                 r2,
//                 n, grid);

//         int pick = Math.max(
//                 Math.max(DD, DR),
//                 Math.max(RD, RR));

//         if (pick == Integer.MIN_VALUE)
//             return Integer.MIN_VALUE;

//         return cherries + pick;
//     }

//     public int cherryPickup(int[][] grid) {

//         int n = grid.length;

//         int answer = findMaximumCherryPick(0, 0, 0, n, grid);

//         return Math.max(0, answer);
//     }
// }



import java.util.*;

class Solution {

    int findMaximumCherryPick(int r1, int c1,
                              int r2,
                              int n,
                              int[][] grid,
                              int[][][] dp) {

        int c2 = (r1 + c1) - r2;

        // Boundary check
        if (r1 >= n || r2 >= n || c1 >= n || c2 >= n || c2 < 0)
            return Integer.MIN_VALUE;

        // Thorn cell
        if (grid[r1][c1] == -1 || grid[r2][c2] == -1)
            return Integer.MIN_VALUE;

        // Destination
        if (r1 == n - 1 && c1 == n - 1)
            return grid[n - 1][n - 1];

        // Memoization
        if (dp[r1][c1][r2] != -1)
            return dp[r1][c1][r2];

        int cherries = grid[r1][c1];

        // Avoid double counting
        if (r1 != r2 || c1 != c2)
            cherries += grid[r2][c2];

        // Four possible moves
        int DD = findMaximumCherryPick(r1 + 1, c1,
                                       r2 + 1,
                                       n, grid, dp);

        int DR = findMaximumCherryPick(r1 + 1, c1,
                                       r2,
                                       n, grid, dp);

        int RD = findMaximumCherryPick(r1, c1 + 1,
                                       r2 + 1,
                                       n, grid, dp);

        int RR = findMaximumCherryPick(r1, c1 + 1,
                                       r2,
                                       n, grid, dp);

        int pick = Math.max(
                        Math.max(DD, DR),
                        Math.max(RD, RR));

        if (pick == Integer.MIN_VALUE)
            return dp[r1][c1][r2] = Integer.MIN_VALUE;

        return dp[r1][c1][r2] = cherries + pick;
    }

    public int cherryPickup(int[][] grid) {

        int n = grid.length;

        int[][][] dp = new int[n][n][n];

        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, -1);
            }
        }

        int answer = findMaximumCherryPick(0, 0, 0, n, grid, dp);

        return Math.max(0, answer);
    }
}