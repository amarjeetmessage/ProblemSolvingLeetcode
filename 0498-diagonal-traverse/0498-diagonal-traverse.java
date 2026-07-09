class Solution {

    public int[] findDiagonalOrder(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        if (m == 0 || n == 0)
            return new int[0];

        int[] ans = new int[m * n];

        int index = 0;

        int row = 0;
        int col = 0;

        boolean up = true;

        while (row < m && col < n) {

            // Moving Up
            if (up) {

                while (row > 0 && col < n - 1) {
                    ans[index++] = mat[row][col];
                    row--;
                    col++;
                }

                ans[index++] = mat[row][col];

                if (col == n - 1) {
                    row++;
                } else {
                    col++;
                }

            }

            // Moving Down
            else {

                while (col > 0 && row < m - 1) {
                    ans[index++] = mat[row][col];
                    row++;
                    col--;
                }

                ans[index++] = mat[row][col];

                if (row == m - 1) {
                    col++;
                } else {
                    row++;
                }
            }

            // Change direction
            up = !up;
        }

        return ans;
    }
}