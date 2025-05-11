class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;

        if(m*n != r*c) return mat;
        if(m==r && n==c) return mat;

        int[][] newMat = new int[r][c];
        int newIndex = 0;
        int oldIndex = 0;

        while(newIndex < r*c && oldIndex < m*n){
            newMat[newIndex / c][newIndex % c] = mat[oldIndex / n][oldIndex % n];
            newIndex++;
            oldIndex++;
        }
        return newMat;
    }
}