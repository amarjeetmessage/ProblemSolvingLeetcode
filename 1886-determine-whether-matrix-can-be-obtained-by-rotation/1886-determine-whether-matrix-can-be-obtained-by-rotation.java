class Solution {

    // Transpose and then reverse each row to rotate the matrix 90 degrees
    static void rotate(int[][] matrix){
        int n = matrix.length;
        int temp;

        // Transpose
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row
        int start, end;
        for(int i = 0; i < n; i++){
            start = 0;
            end = n - 1;
            while(start < end){
                temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        }
    }

    // Check if two matrices are equal
    static boolean check(int[][] matrix, int[][] target){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                if(matrix[i][j] != target[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    // Main method to check for rotation match
    public boolean findRotation(int[][] mat, int[][] target) {
        for(int i = 0; i < 4; i++){
            if(check(mat, target)){
                return true;
            }
            rotate(mat);
        }
        return false;
    }
}
