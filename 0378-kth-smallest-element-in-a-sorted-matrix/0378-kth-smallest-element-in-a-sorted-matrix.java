class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0], high = matrix[n - 1][n - 1];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (hasLessThanKElements(matrix, k, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    /* This will work only if the row and col both are sorted */
    private boolean hasLessThanKElements(int[][] matrix, int k, int target) {
        final int n = matrix.length;
        int row = n - 1, col = 0, count = 0;
        while (row >= 0 && col < n) {
            if (matrix[row][col] <= target) {
                count += row + 1;
                col++;
            } else {
                row--;
            }
        }
        return count < k;
    }
}