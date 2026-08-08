// class Solution {

//     public int calculateMinimumHP(int[][] dungeon) {
//         return dfs(0, 0, dungeon);
//     }

//     public int dfs(int row, int col, int[][] dungeon) {

//         int rows = dungeon.length;
//         int cols = dungeon[0].length;

//         // Out of bounds
//         if (row >= rows || col >= cols) {
//             return Integer.MAX_VALUE;
//         }

//         // Destination cell
//         if (row == rows - 1 && col == cols - 1) {
//             return Math.max(1, 1 - dungeon[row][col]);
//         }

//         // Minimum health needed from right and down
//         int right = dfs(row, col + 1, dungeon);
//         int down = dfs(row + 1, col, dungeon);

//         int need = Math.min(right, down) - dungeon[row][col];

//         return Math.max(1, need);
//     }
// }





class Solution {

    int[][] dp;

    public int calculateMinimumHP(int[][] dungeon) {

        int rows = dungeon.length;
        int cols = dungeon[0].length;

        dp = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            Arrays.fill(dp[i], -1);
        }

        return dfs(0, 0, dungeon);
    }

    public int dfs(int row, int col, int[][] dungeon) {

        int rows = dungeon.length;
        int cols = dungeon[0].length;

        // Out of bounds
        if (row >= rows || col >= cols) {
            return Integer.MAX_VALUE;
        }

        // Destination cell
        if (row == rows - 1 && col == cols - 1) {
            return Math.max(1, 1 - dungeon[row][col]);
        }

        // Memoization
        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        int right = dfs(row, col + 1, dungeon);
        int down = dfs(row + 1, col, dungeon);

        int need = Math.min(right, down) - dungeon[row][col];

        return dp[row][col] = Math.max(1, need);
    }
}