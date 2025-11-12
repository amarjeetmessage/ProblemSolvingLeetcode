class Solution {
    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;

        int[][] dp = new int[n][n];
        for(int i = 0; i<n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        int mn = Integer.MAX_VALUE;
        for(int j = 0; j<n; j++) {
            int ans = solve(matrix, n, 0 ,j,dp );
            mn = Math.min(mn, ans);
        }
        return mn;
    }
    public static int solve(int[][] matrix, int n, int i , int j,int[][] dp) {
        if(j < 0 || j > n-1) return Integer.MAX_VALUE;
        if(i == n-1) return matrix[i][j];

        if(dp[i][j] != Integer.MAX_VALUE) {
            return dp[i][j];
        }

        //RECURSIVE CALL
        int a = solve(matrix, n,i+1,j-1,dp);
        int b = solve(matrix, n,i+1,j+1,dp);
        int c = solve(matrix, n,i+1,j,dp);

        dp[i][j] =  Math.min(c,Math.min(a,b)) + matrix[i][j];
        return dp[i][j];
    
    }
}