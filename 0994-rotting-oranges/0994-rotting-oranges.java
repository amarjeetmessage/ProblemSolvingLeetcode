class Solution {
    int rows, cols;
    int[][] time;
    int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public int orangesRotting(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        time = new int[rows][cols];

        // Step 1: initialize time matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    time[i][j] = 0;          // rotten -> time 0
                } else {
                    time[i][j] = Integer.MAX_VALUE; // fresh or empty -> INF
                }
            }
        }

        // Step 2: run DFS from every rotten orange
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    dfs(i, j, 0, grid);
                }
            }
        }

        // Step 3: find answer
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 1 && time[i][j] == Integer.MAX_VALUE) {
                    return -1;   // unreachable fresh orange
                }

                if (grid[i][j] != 0) {
                    ans = Math.max(ans, time[i][j]);
                }
            }
        }
        return ans;
    }

    private void dfs(int r, int c, int t, int[][] grid) {

        // explore 4 directions
        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {

                // only rot fresh oranges
                if (grid[nr][nc] == 1 && t + 1 < time[nr][nc]) {
                    time[nr][nc] = t + 1;
                    dfs(nr, nc, t + 1, grid);
                }
            }
        }
    }
}
