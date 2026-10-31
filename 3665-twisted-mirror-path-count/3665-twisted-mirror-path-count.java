class Solution {
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int MOD = 1_000_000_007;

        // right[i][j]: paths attempting to enter (i, j) from the left
        // down[i][j]: paths attempting to enter (i, j) from above
        int[][] right = new int[m][n];
        int[][] down = new int[m][n];

        // The robot starts at (0, 0).
        right[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    // Mirror: entering from the left reflects downward.
                    if (i + 1 < m) {
                        down[i + 1][j] =
                            (int) ((down[i + 1][j] + (long) right[i][j]) % MOD);
                    }

                    // Mirror: entering from above reflects rightward.
                    if (j + 1 < n) {
                        right[i][j + 1] =
                            (int) ((right[i][j + 1] + (long) down[i][j]) % MOD);
                    }

                } else {
                    // Empty cell: paths arriving from either direction.
                    int ways = (int) (((long) right[i][j] + down[i][j]) % MOD);

                    // Move down.
                    if (i + 1 < m) {
                        down[i + 1][j] =
                            (int) ((down[i + 1][j] + (long) ways) % MOD);
                    }

                    // Move right.
                    if (j + 1 < n) {
                        right[i][j + 1] =
                            (int) ((right[i][j + 1] + (long) ways) % MOD);
                    }
                }
            }
        }

        // Count paths that arrive at the bottom-right cell.
        return (int) (((long) right[m - 1][n - 1]
                     + down[m - 1][n - 1]) % MOD);
    }
}//potd