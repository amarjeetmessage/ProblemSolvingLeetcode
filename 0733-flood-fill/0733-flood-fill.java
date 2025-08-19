class Solution {
    public void helper(int[][] image, int sr, int sc, int color, boolean[][] vis, int origColor) {
        // base case (out of bound / already visited / different color)
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length 
            || vis[sr][sc] || image[sr][sc] != origColor) {
            return;
        }

        vis[sr][sc] = true;          // mark visited
        image[sr][sc] = color;       // fill new color

        // explore 4 directions
        helper(image, sr, sc - 1, color, vis, origColor); // left
        helper(image, sr, sc + 1, color, vis, origColor); // right
        helper(image, sr - 1, sc, color, vis, origColor); // up
        helper(image, sr + 1, sc, color, vis, origColor); // down
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] vis = new boolean[image.length][image[0].length];
        int origColor = image[sr][sc];
        if (origColor != color) { // avoid infinite recursion if already same color
            helper(image, sr, sc, color, vis, origColor);
        }
        return image;
    }
}
