import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> luckyNumbers = new ArrayList<>();

        // Step 1: Find the minimum value in each row
        for (int i = 0; i < m; i++) {
            int minRowValue = matrix[i][0];
            int minRowIndex = 0;
            // Find the minimum element in the current row
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] < minRowValue) {
                    minRowValue = matrix[i][j];
                    minRowIndex = j;
                }
            }

            // Step 2: Check if the minimum row value is the maximum in its column
            boolean isMaxInColumn = true;
            for (int k = 0; k < m; k++) {
                if (matrix[k][minRowIndex] > minRowValue) {
                    isMaxInColumn = false;
                    break;
                }
            }

            // If it's the minimum in its row and maximum in its column, it's a lucky number
            if (isMaxInColumn) {
                luckyNumbers.add(minRowValue);
            }
        }

        return luckyNumbers;
    }
}