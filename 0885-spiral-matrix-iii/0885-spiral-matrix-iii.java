public class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] result = new int[rows * cols][2];
        int count = 0;
        int len = 1; // length of current side of spiral
        int r = rStart, c = cStart;
        result[count++] = new int[]{r, c};

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // R, D, L, U
        int dir = 0;

        while (count < rows * cols) {
            for (int i = 0; i < 2; i++) {  // Two sides at each length
                for (int j = 0; j < len; j++) {
                    r += directions[dir][0];
                    c += directions[dir][1];
                    if (r >= 0 && r < rows && c >= 0 && c < cols) {
                        result[count++] = new int[]{r, c};
                    }
                }
                dir = (dir + 1) % 4;  // Change direction
            }
            len++;  // Increase step size after completing right+down or left+up
        }

        return result;
    }
}
