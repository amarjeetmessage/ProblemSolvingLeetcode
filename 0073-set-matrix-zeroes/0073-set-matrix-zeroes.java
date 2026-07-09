class Solution {

    // ============================================================
    // APPROACH 1 : Using Extra Row & Column Arrays
    // Time  : O(m × n)
    // Space : O(m + n)
    // ============================================================
    public void setZeroesExtraSpace(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        boolean[] rows = new boolean[row];
        boolean[] cols = new boolean[col];

        // Step 1: Mark rows and columns containing 0
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        // Step 2: Make marked rows zero
        for (int i = 0; i < row; i++) {
            if (rows[i]) {
                for (int j = 0; j < col; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 3: Make marked columns zero
        for (int j = 0; j < col; j++) {
            if (cols[j]) {
                for (int i = 0; i < row; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // ============================================================
    // APPROACH 2 : Optimal (O(1) Extra Space)
    // Time  : O(m × n)
    // Space : O(1)
    // ============================================================
    public void setZeroes(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Step 1: Check if first row contains any 0
        for (int j = 0; j < col; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Step 2: Check if first column contains any 0
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // Step 3: Use first row and first column as markers
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Step 4: Zero marked rows
        for (int i = 1; i < row; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < col; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 5: Zero marked columns
        for (int j = 1; j < col; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < row; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 6: Zero first row if needed
        if (firstRowZero) {
            for (int j = 0; j < col; j++) {
                matrix[0][j] = 0;
            }
        }

        // Step 7: Zero first column if needed
        if (firstColZero) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}