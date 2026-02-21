class Solution {
    int rows, cols;

    public void dfs(int row, int col, char[][] grid, boolean vis[][]) {
        //out of bound
        if(row<0 || row>= rows || col<0 || col>=cols || grid[row][col] == '0' || vis[row][col]) {
            return;
        }
        vis[row][col] = true;
        int adjList[][] = {
            {row-1,col},
            {row+1,col},
            {row,col+1},
            {row,col-1}
        };
        for(int neighbour[] : adjList) {
            dfs(neighbour[0],neighbour[1],grid,vis);
        }
    }

    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int islands = 0;

        boolean[][] vis = new boolean[rows][cols];

        for(int i =0; i<rows; i++) {
            for(int j = 0; j<cols; j++) {
                if(grid[i][j] == '1' && !vis[i][j]) {
                    dfs(i,j,grid,vis);
                    islands++;
                }
            }
        }

        return islands;
    }
}

//just ques of like finding connected component graph 
