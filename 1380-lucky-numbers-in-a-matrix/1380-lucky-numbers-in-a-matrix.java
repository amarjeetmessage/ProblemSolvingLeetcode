import java.util.*;

class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int minIdx = 0;
            int min = Integer.MAX_VALUE;

            // Find min element in the row
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    minIdx = j;
                }
            }

            // Check if the min element is also the max in its column
            boolean isLucky = true;
            for (int k = 0; k < matrix.length; k++) {
                if (matrix[k][minIdx] > matrix[i][minIdx]) {
                    isLucky = false;
                    break;
                }
            }

            if (isLucky) {
                arr.add(matrix[i][minIdx]);
            }
        }
        return arr;
    }
}
