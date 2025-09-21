class Solution {
    public void setZeroes(int[][] matrix) {

        //BRUTE FORCE APPROACH

        // int m = matrix.length;
        // int n = matrix[0].length;

        // boolean[] row = new boolean[m];
        // boolean[] col = new boolean[n];

        // // Step 1: Mark rows & cols that need to be zero
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (matrix[i][j] == 0) {
        //             row[i] = true;
        //             col[j] = true;
        //         }
        //     }
        // }

        // // Step 2: Set zeroes
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (row[i] || col[j]) {
        //             matrix[i][j] = 0;
        //         }
        //     }
        // }



        // //BETTER APPROACH
        // int m = matrix.length;
        // int n = matrix[0].length;

        // int[] row = new int[m];
        // int[] column = new int[n];

        // for(int i = 0; i<m; i++){
        //     for(int j= 0; j<n; j++){
        //         if(matrix[i][j] == 0){
        //             row[i] = 1;
        //             column[j] = 1;
        //         }
        //     }
        // }

        // for(int i = 0; i<m; i++){
        //     for(int j= 0; j<n; j++){
        //         if(row[i] == 1 || column[j] == 1){
        //             matrix[i][j] = 0;
        //         }
        //     }
        // }




        //OPTIMAL APPROACH
        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRow = false, firstCol = false;

        // Check first row
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) firstRow = true;
        }

        // Check first column
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) firstCol = true;
        }

        // Use first row & col as markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Update matrix based on markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Handle first row
        if (firstRow) {
            for (int j = 0; j < n; j++) matrix[0][j] = 0;
        }

        // Handle first column
        if (firstCol) {
            for (int i = 0; i < m; i++) matrix[i][0] = 0;
        }
    }
}
