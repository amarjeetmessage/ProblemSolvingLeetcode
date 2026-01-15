class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    islands++;
                    bfs(grid, r, c, dr, dc);
                }
            }
        }
        return islands;
    }

    private void bfs(char[][] grid, int row, int col, int[] dr, int[] dc) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        grid[row][col] = '0';

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nc >= 0 &&
                    nr < grid.length && nc < grid[0].length &&
                    grid[nr][nc] == '1') {

                    queue.offer(new int[]{nr, nc});
                    grid[nr][nc] = '0';
                }
            }
        }
    }
}
