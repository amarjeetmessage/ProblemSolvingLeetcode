class Solution {
    int rows, cols;
    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        boolean[][] vis = new boolean[rows][cols];

        int count = 0;

        for(int i = 0; i<rows; i++) {
            for(int j = 0; j< cols; j++) {
                if(grid[i][j] == '1' && vis[i][j] == false){
                    count++;
                    dfs(i, j, vis, grid);
                }
            }
        }

        return count;
    }

    public void dfs(int row, int col, boolean[][] vis, char[][] grid){

        if(row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == '0' || vis[row][col] == true){
            return;
        }

        vis[row][col] = true;

        int[][] adjList = {{row + 1, col},
        {row -1, col},
        {row, col + 1},
        {row, col - 1}};

        for(int[] neigh : adjList) {
            dfs(neigh[0], neigh[1], vis, grid);
        }

        // dfs(row+1,col,vis,grid);
        // dfs(row-1,col,vis,grid);
        // dfs(row,col+1,vis,grid);
        // dfs(row,col-1,vis,grid);
    }
}