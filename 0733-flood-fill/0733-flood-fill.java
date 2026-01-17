class Solution {
    int rows, cols;
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rows = image.length;
        cols = image[0].length;
        int oldColor = image[sr][sc];
        if (oldColor != color) {
            dfs(image, sr, sc, oldColor, color);
        }
        return image;
    }

    private void dfs(int[][] image, int r, int c, int oldColor, int newColor) {
        image[r][c] = newColor;
        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols 
                && image[nr][nc] == oldColor) {
                dfs(image, nr, nc, oldColor, newColor);
            }
        }
    }
}
