class Solution {
    public int diagonalSum(int[][] mat) {
        int m = mat.length;
        int sum = 0;

        for(int i = 0; i<m; i++){
            sum += mat[i][i];
            
            //this condition is used very important note that how to find 
            if(i != m-i-1){
                sum += mat[i][m-i-1];
            }

        }
        return sum;
    }
}


//you can also solve this question by brute force appraoch in O(n^2)
