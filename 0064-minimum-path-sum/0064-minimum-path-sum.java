class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return solve(grid, m,n, 0,0);
    }
    public static int solve(int[][] grid, int m, int n, int i, int j) {
        if(i == m-1 && j == n-1) return grid[i][j];
        if(i > m-1 || j > n-1) return Integer.MAX_VALUE;


        //recursive call
        int a = solve(grid, m,n, i+1,j);
        int b = solve(grid, m, n, i, j+1);

        return Math.min(a,b) + grid[i][j];
    }
}