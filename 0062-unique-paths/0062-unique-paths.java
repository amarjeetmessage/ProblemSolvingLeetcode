class Solution {
    public int uniquePaths(int m, int n) {
    
    int[][] dp = new int[m+1][n+1];

    for(int[] row : dp) {
        Arrays.fill(row , -1);
    }

    return solve(0, 0, m, n,dp);

    }

    public int solve(int i, int j , int m, int n,int[][] dp) {
        if(i == m-1 && j == n -1) return 1;
        if(i >= m || j>=n) return 0;

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int a = solve(i, j+1,m,n,dp);
        int b = solve(i+1, j,m,n,dp);

        dp[i][j] = a+b;
        return dp[i][j];
    }
}